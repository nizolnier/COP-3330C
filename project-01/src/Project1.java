/*
Nicole Zolnier and Trae Roy
Project 1 - 02/08/2022
*/

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Project1 {
    public static void main(String[] args) {

        // initalize setup
        Course[] courseList = setup();
        // class variable
        Project1 sol = new Project1();

        // assign class variables
        Student[] studentList = new Student[10];
        Faculty[] facultyList = new Faculty[10];
        TAs[] tasList = new TAs[10];

        // display menu and scan choice
        displayMenu();
        String ans = sol.choiceInput();

        // while loop

        while(!Objects.equals(ans, "3")) {
            switch (ans) {
                // case 1, choice 1
                case "1" -> enterInfo(sol, studentList, facultyList, tasList, courseList);

                // case 2, choice 2
                case "2" -> printSchedule(sol, studentList, facultyList, tasList);

                case " 3" -> {
                    break;
                }

                // invalid choice reprint menu and get choice
                default -> {
                    displayMenu();
                    ans = sol.choiceInput();
                }
            }
        }

        displayGoodbye();

    }

    // functions
    private final Scanner input = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("___________Choose one of the options____________________");
        System.out.println("1.  Enter the information of the faculty, the TA or the student");
        System.out.println("2.  Print schedule");
        System.out.println("3.  Exit Program");
    }

    public String choiceInput() {
        System.out.println("\tEnter your selection: ");
        return input.nextLine();
    }

    public int intInput(String prompt) {
        System.out.println(prompt);
        return input.nextInt();
    }

    public String stringInput(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    public static void displayGoodbye() {
        System.out.println("Goodbye! ");
    }

    public static void printSchedule(Project1 sol, Student[] studentList, Faculty[] facultyList, TAs[] tasList) {
        int id = sol.intInput("Enter UCF id number: ");

        for (Faculty element : facultyList) {
            if (element.getId() == id) {
                System.out.println("Record Found: " + element.getName() + ", Faculty");
                System.out.println("Rank: " + element.getRank() + ", Office: " + element.getOfficeLocation());
                System.out.println("Lectures taught: " + element.getLecturesTaught());
                break;
            }
        }

        for(Student element : studentList) {
            if(element.getId() == id) {
                System.out.println("Record Found: " + element.getName() + ", Student");
                System.out.println("Lectures Taken: " + element.getLecturesTaken());

                break;
            }
        }

        for(TAs element : tasList) {
            if(element.getId() == id) {
                System.out.println("Record Found: " + element.getName() + ", TA");
                System.out.println("Lectures Taken: " + element.getLecturesTaken());
                System.out.println("Labs supervised: " + element.getLabsSupervised());
                break;
            }
        }

    }

    public static Course[] setup() {
        Course[] courses = new Course[3];
        // COT6578
        courses[0] = new Course();
        courses[0].setPrefix("COT6578");
        courses[0].setCourseNumber(89745);
        courses[0].setModality("F2F");
        courses[0].setLab(false);
        courses[0].setDescription("Advanced Computer theory, Graduate");

        // COP5698
        courses[1] = new Course();
        courses[1].setPrefix("COP5698");
        courses[1].setCourseNumber(69745);
        courses[1].setModality("F2F");
        courses[1].setLab(true);
        courses[1].labNumber = new ArrayList<Integer>();
        courses[1].labTaId = new ArrayList<Integer>();
        courses[1].labNumber.add(19745);
        courses[1].labTaId.add(1234567);
        courses[1].labNumber.add(36598);
        courses[1].labTaId.add(2589631);
        courses[1].labNumber.add(20315);
        courses[1].labTaId.add(7845129);
        courses[1].setDescription("Programming Languages, Graduate");


        // COP 3330
        courses[2] = new Course();
        courses[2].setPrefix("COP3330");
        courses[2].setCourseNumber(80000);
        courses[2].setModality("F2F");
        courses[2].setLab(false);
        courses[2].setDescription("Introduction Object Oriented Programming, Undergraduate");

        return courses;
    }


    public static void enterInfo(Project1 sol, Student[] studentList, Faculty[] facultyList, TAs[] tasList, Course[] courseList) {
        String name, choice;
        int id;

        name = sol.stringInput("Enter Name: ");
        id = sol.intInput("Enter UCF id number: ");
        sol.input.nextLine();
        choice = sol.stringInput("Enter F for Faculty, T for TA or S for Student: ");

        switch(choice) {
            case "f":
            case "F":
                enterFacultyInfo(sol, name, id, facultyList, courseList);
                break;
            case "t":
            case "T":
                enterTaInfo(sol, name, id, tasList, courseList);
                break;
            case "s":
            case "S":
                enterStudentInfo(sol, name, id, studentList, courseList);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    public static void enterStudentInfo(Project1 sol, String name, int id, Student[] studentList, Course[] courseList) {
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.lecturesTaken = new ArrayList<Course>();

        int lectures = sol.intInput("Enter how many Lectures taken by " + name + ":");

        for(int i = 1; i <= lectures; i++) {
            System.out.println("Collecting info of Lecture " + i + ":");
            int crn = sol.intInput("\n\tEnter crn: ");
            
            for (Course element : courseList) {
                if (element.getCourseNumber() == crn) {
                    System.out.println(element.getDescription());
                    s.lecturesTaken.add(element);
                    break;
                }
                else {
                    System.out.println("Invalid Course");
                    break;
                }
            }

        }

        ArrayList<Student> studentArrayList = new ArrayList<Student>(Arrays.asList(studentList));

        studentArrayList.add(s);

        studentList = studentArrayList.toArray(studentList);

    }

    public static void enterTaInfo(Project1 sol, String name, int id, TAs[] taList, Course[] courseList) {
        TAs t = new TAs();
        t.setId(id);
        t.setName(name);
        t.labsSupervised = new ArrayList<Integer>();

        int crn;

        int lectures = sol.intInput("Enter how many Lectures taken by " + name + ":");

        for(int i = 1; i <= lectures; i++) {
            System.out.println("Collecting info of Lecture " + i + ":");
            crn = sol.intInput("\n\tEnter crn: ");
        }

        int labs = sol.intInput("\n\tNow, enter how many Labs, " + name + " is supervising: ");

        for(int i = 1; i <= labs; i++) {
            System.out.println("Collecting info of Lab " + i + ":");
            crn = sol.intInput("\n\tEnter crn: ");
            for (Course element : courseList) {
                if (element.getCourseNumber() == crn) {
                    System.out.println(element.getDescription());
                    t.labsSupervised.add(crn);
                    break;
                }
                else {
                    System.out.println("Invalid Course");
                    break;
                }
            }
        }

        ArrayList<TAs> taArrayList = new ArrayList<TAs>(Arrays.asList(taList));

        taArrayList.add(t);

        taList = taArrayList.toArray(taList);

    }

    public static void enterFacultyInfo(Project1 sol, String name, int id, Faculty[] facultyList, Course[] courseList) {
        Faculty f = new Faculty();
        f.setName(name);
        f.setId(id);
        f.lecturesTaught = new ArrayList<Course>();
        
        String rank = sol.stringInput("Enter the rank of " + name + "."); 
        String officeLocation = sol.stringInput("Enter the location of " + name + "'s office.");
        int lecturesTaught = sol.intInput("Enter how many Lectures are taught by " + name + ":");

        f.setRank(rank);
        f.setOfficeLocation(officeLocation);

        for(int i = 1; i <= lecturesTaught; i++) {
            System.out.println("Collecting info of Lecture " + i + ":");
            int crn = sol.intInput("\n\tEnter crn: ");
            for (Course element : courseList) {
                if (element.getCourseNumber() == crn) {
                    System.out.println(element.getDescription());
                    f.lecturesTaught.add(element);
                    break;
                }
                else {
                    System.out.println("Invalid Course");
                    break;
                }
            }
        }

        
        ArrayList<Faculty> facultyArrayList = new ArrayList<Faculty>(Arrays.asList(facultyList));

        facultyArrayList.add(f);

        facultyList = facultyArrayList.toArray(facultyList);
    }

    // ------ classes ------
    static class Course {
        private String prefix;
        private int courseNumber;
        private String modality;
        private boolean lab;
        public ArrayList<Integer> labNumber;
        public ArrayList<Integer> labTaId;
        private String description;


        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public int getCourseNumber() {
            return courseNumber;
        }

        public void setCourseNumber(int courseNumber) {
            this.courseNumber = courseNumber;
        }

        public String getModality() {
            return modality;
        }

        public void setModality(String modality) {
            this.modality = modality;
        }

        public boolean isLab() {
            return lab;
        }

        public void setLab(boolean lab) {
            this.lab = lab;
        }

        public ArrayList<Integer> getlabNumber() {
            return labNumber;
        }

        public ArrayList<Integer> getlabTaId() {
            return labTaId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    static class Student {
        protected String name;
        protected int id;
        protected boolean graduate;
        public ArrayList<Course> lecturesTaken;


        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isGraduate() {
            return graduate;
        }

        public void setGraduate(boolean graduate) {
            this.graduate = graduate;
        }

        public ArrayList<Course> getLecturesTaken() {
            return lecturesTaken;
        }

        public void setLecturesTaken(ArrayList<Course> lecturesTaken) {
            this.lecturesTaken = lecturesTaken;
        }
    }

    static class Faculty {
        private String name;
        private int id;
        private String rank;
        private String officeLocation;
        public ArrayList<Course> lecturesTaught;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getOfficeLocation() {
            return officeLocation;
        }

        public void setOfficeLocation(String officeLocation) {
            this.officeLocation = officeLocation;
        }

        public ArrayList<Course> getLecturesTaught() {
            return lecturesTaught;
        }

        public void setLecturesTaught(ArrayList<Course> lecturesTaught) {
            this.lecturesTaught = lecturesTaught;
        }

    }

    static class TAs extends Student {
        public ArrayList<Integer> labsSupervised;
        private Faculty advisor;
        private String expectedDegree;


        public ArrayList<Integer> getLabsSupervised() {
            return labsSupervised;
        }

        public Faculty getAdvisor() {
            return advisor;
        }

        public void setAdvisor(Faculty advisor) {
            this.advisor = advisor;
        }

        public String getExpectedDegree() {
            return expectedDegree;
        }

        public void setExpectedDegree(String expectedDegree) {
            this.expectedDegree = expectedDegree;
        }
    }
}