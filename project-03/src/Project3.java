/*
Nicole Zolnier and Nathan Reeves
Project 3 - 04/25/2022
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Project3 {
    public static void main(String[] args) throws FileNotFoundException {
        // creating an arraylist for the people and one for the lectures
        ArrayList<Person> ucfPeople = new ArrayList<Person>();
        ArrayList<Lecture> ucfLectures = setup();

        // calling the loop with choices
        loopMenuChoices(ucfLectures, ucfPeople);

        // when the loop breaks, it prints goodbye
        displayGoodbye();
    }

    // methods to get input
    public static String choiceInput() {
        System.out.println("\tEnter your selection: ");
        return new Scanner(System.in).nextLine();
    }

    public static int idInput() {
        System.out.println("Enter UCF id: ");
        int id;

        // loop that is going to break when the id meets the requirements
        while(true) {
            try {
                // scan
                String input = new Scanner(System.in).nextLine();

                // if the input is different 7, it is going to thrown a new id exception
                if(input.length() != 7) {
                    throw new IdException();
                }

                // if it is not, it is going to try to parse it to an int
                id = Integer.parseInt(input);

                break;
            } catch (IdException e) {
                // print the message from the toString method
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Please enter an integer.");
            }
        }

        return id;
    }

    public static int intInput(String prompt) {
        System.out.println(prompt);

        int inp;
        // here is to avoid that the user doesn't enter an integer
        // it scans the line and tries to convert it into an int
        // if that fails, it is going to print a message and redo the scan
        while (true) {
            try {
                String input = new Scanner(System.in).nextLine();
                inp = Integer.parseInt(input);

                break;
            } catch (Exception e) {
                System.out.println("Please enter an integer.");
            }
        }

        return inp;

    }

    public static String stringInput(String prompt) {
        System.out.println(prompt);
        return new Scanner(System.in).nextLine();
    }

    // -------------
    // method that saves the lectures from the file
    public static ArrayList<Lecture> setup() {
        ArrayList<Lecture> lecs = new ArrayList<Lecture>();
        String buffer, prefix, modality, location, description;
        int courseNumber;
        boolean graduate, lab;
        String[] token;
        Lecture l;
        int labCourse;
        String labLocation;
        Scanner s;


        while(true) {
            try {
                // try to get the file
                // if not, it will throw an exception
                String filePath = stringInput("Enter the absolute path of the file: ");
                s = new Scanner(new File(filePath));
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Sorry no such file");
            }
        } 
        
        while (s.hasNextLine()) {
            buffer = s.nextLine();
            token = buffer.split(",");

            // when the token only has 2 things (crn and location) then it's a lab
            if (token.length == 2) {
                labCourse = Integer.parseInt(token[0]);
                labLocation = token[1].trim();

                // get the last saved lecture and add in the labs
                lecs.get(lecs.size() - 1).addLab(new Lab(labCourse, labLocation));
            } else {
                // order = 69745,COP5698,Programming Languages,Graduate,F2F,CB2-122,YES
                courseNumber = Integer.parseInt(token[0]);
                prefix = token[1];
                description = token[2];
                graduate = (token[3].equalsIgnoreCase("graduate"));
                modality = token[4];

                // if the modality is online, it ends on token[4]
                if (modality.equalsIgnoreCase("f2f") || modality.equalsIgnoreCase("mixed")) {
                    location = token[5];
                    lab = (token[6].equalsIgnoreCase("yes"));
                } else {
                    location = "";
                    lab = false;
                }

                // add new lecture
                l = new Lecture(prefix, courseNumber, modality, location, description, graduate, lab);
                lecs.add(l);
            }

        }

        return lecs;
    }

    // method to print the menu options
    public static void displayMenu() {
        System.out.println("___________Choose one of the options____________________");
        System.out.println("1. Add a new faculty to the schedule.");
        System.out.println("2. Enroll a student to a lecture.");
        System.out.println("3. Print the Schedule of a faculty.");
        System.out.println("4. Print the schedule of an TA.");
        System.out.println("5. Print the schedule of a student.");
        System.out.println("6. Delete a scheduled lecture.");
        System.out.println("7. Exit Program.");
    }

    public static void loopMenuChoices(ArrayList<Lecture> lecs, ArrayList<Person> people) {
        String ans;
        // using a do while to do everything at least once
        // while the answer is not 7
        do {
            // print the menu and get the choice from user
            displayMenu();
            ans = choiceInput();
            // analyze each case, if it doesnt match any, it is just gonna do it again
            if (ans.equals("1")) {
                addFaculty(lecs, people);
            } else if (ans.equals("2")) {
                addStudent(lecs, people);
            } else if (ans.equals("3")) {
                printFaculty(people);
            } else if (ans.equals("4")) {
                printTA(people);
            } else if (ans.equals("5")) {
                printStudent(people);
            } else if (ans.equals("6")) {
                deleteLecture(lecs, people);
            } else if (ans.equals("7")) {
                break;
            }

        } while (!ans.equals("7"));
    }

    public static void addFaculty(ArrayList<Lecture> lecs, ArrayList<Person> people) {
        // getting some info
        String name = stringInput("Enter name: ");
        int id = idInput();
        // if the user enter an id that is already in use, it is going to keep asking
        // for a new id until it's an available id

        while (checkValidId(id, people)) {
            id = intInput("Sorry, that UCF id is already in use. Enter a new UCF id: ");
        }
        // collecting more info
        String rank = stringInput("Enter rank: ");
        String officeLocation = stringInput("Enter office location: ");
        int numLecs = intInput("Enter how many lectures");
        ArrayList<Lecture> lecturesTaught = new ArrayList<Lecture>();

        // to add in lectures, i did it with a for loop based on the number of lecture
        int crn;
        for (int i = 0; i < numLecs; i++) {
            // get the crn for the (i+1) lecture
            crn = intInput("Enter the crn of the " + (i + 1) + "° lecture to assign to " + name);

            // if the lecture exists in the arraylist of lecs
            if (lectureExists(crn, lecs)) {
                // if the lecture has a lab, we need to assign ta's
                if (findLecture(crn, lecs).lab) {
                    System.out.println(findLecture(crn, lecs) + " has labs. Please assign a TA for each lab");
                    // for each lab, get a ta
                    for (int j = 0; j < findLecture(crn, lecs).labs.size(); j++) {
                        // get the ta id
                        int taId = intInput("Enter the UCF id of the TA for " + findLecture(crn, lecs).labs.get(j));

                        // if the ta is a student or a ta present in the people's list
                        if (taStudentExists(taId, people)) {
                            // then we just simply add lab to the ta
                            findTA(taId, people).addLabSupervised(findLecture(crn, lecs).labs.get(j));
                        } else {
                            // if not, we create the ta
                            String taName = stringInput("Enter name of the TA");
                            boolean graduate = true;
                            String advisorName = stringInput("Enter TA's supervisor's name:");
                            String expectedDegree = stringInput("Enter TA's degree seeking:");
                            TA t = new TA(taName, taId, graduate, advisorName, expectedDegree);

                            System.out.println("\n");
                            // add the lab to the new ta
                            t.addLabSupervised(findLecture(crn, lecs).labs.get(j));
                            // add ta to list of people
                            people.add(t);

                        }
                    }
                }

                // add lecture and print that it was added
                System.out.println(findLecture(crn, lecs) + " added!");
                lecturesTaught.add(findLecture(crn, lecs));
            }
        }

        // add faculty and print that they were added
        people.add(new Faculty(name, id, rank, officeLocation, lecturesTaught));
        System.out.println("New faculty added!");

    }

    public static void addStudent(ArrayList<Lecture> lecs, ArrayList<Person> people) {
        // get student id
        int id = idInput();

        // so if the student exists
        if (studentExists(id, people)) {
            // get how many lectures we are gonna enroll the student in
            int numLecs = intInput("Enter how many lectures");
            int crn;

            // for loop based on number of lectures
            for (int i = 0; i < numLecs; i++) {
                // get the crn for the (i+1) lecture
                crn = intInput(
                        "Enter the crn of the " + (i + 1) + "° lecture to enroll " + findStudent(id, people).name);

                // if the lecture exists in the arraylist of lecs
                if (lectureExists(crn, lecs)) {
                    // if the student is not a graduate student and they are trying to enroll in a
                    // graduate class, i just skip the crn
                    if (findLecture(crn, lecs).graduate && !findStudent(id, people).graduate) {
                        System.out.println("This is a graduate level class");
                        continue;
                    }
                    // if the lecture has labs
                    if (findLecture(crn, lecs).lab) {
                        // generate a random lab
                        Random myRand = new Random();
                        int randomLab = myRand.nextInt(findLecture(crn, lecs).labs.size() + 1);

                        // print that the lecture has labs and that the student was assigned to the
                        // random lab
                        System.out.println(findLecture(crn, lecs) + " has these labs:\n" + findLecture(crn, lecs).labs);
                        System.out.println("[" + findStudent(id, people).name + "] is added to lab "
                                + findLecture(crn, lecs).labs.get(randomLab));

                        // add the lab to student's lab list
                        findStudent(id, people).labsTaken.add(findLecture(crn, lecs).labs.get(randomLab));
                    }

                    // add the lecture to student's schedule and print that the student was enrolled
                    System.out.println("Student enrolled!");
                    findStudent(id, people).lecturesTaken.add(findLecture(crn, lecs));
                }
            }

            System.out.println("Student enrolled!");
        } else if (taExists(id, people)) {
            // a ta is also an student so they can be enrolled in classes too
            // this is the same thing as the first if statement, just now using findTA
            // instead of findStudent
            int numLecs = intInput("Enter how many lectures");
            int crn;

            for (int i = 0; i < numLecs; i++) {
                crn = intInput("Enter the crn of the " + (i + 1) + "° lecture to enroll " + findTA(id, people).name);
                if (lectureExists(crn, lecs)) {
                    if (findLecture(crn, lecs).graduate && !findTA(id, people).graduate) {
                        System.out.println("This is a graduate level class");
                        continue;
                    }
                    if (findLecture(crn, lecs).lab) {
                        Random myRand = new Random();

                        int randomLab = myRand.nextInt(findLecture(crn, lecs).labs.size() + 1);

                        System.out.println(findLecture(crn, lecs) + " has these labs:\n" + findLecture(crn, lecs).labs);
                        System.out.println("[" + findTA(id, people).name + "] is added to lab "
                                + findLecture(crn, lecs).labs.get(randomLab));

                        findTA(id, people).labsTaken.add(findLecture(crn, lecs).labs.get(randomLab));
                    }

                    System.out.println("Student enrolled!");
                    findTA(id, people).lecturesTaken.add(findLecture(crn, lecs));
                }
            }

            System.out.println("Student enrolled!");

        } else {
            // if the student is not found, we create a new one
            // get some information
            String name = stringInput("Enter name:");
            String grad = stringInput("Are you a graduate student?");
            boolean graduate = (grad.equalsIgnoreCase("yes"));

            int numLecs = intInput("Enter how many lectures");
            ArrayList<Lecture> lecturesTaken = new ArrayList<Lecture>();
            ArrayList<Lab> labsTaken = new ArrayList<Lab>();

            // here is the same loop from the other 2 cases, nothing new to see
            int crn;
            for (int i = 0; i < numLecs; i++) {
                crn = intInput("Enter the crn of the " + (i + 1) + "° lecture to enroll " + name);
                if (lectureExists(crn, lecs)) {
                    if (findLecture(crn, lecs).graduate && !graduate) {
                        System.out.println("This is a graduate level class");
                        continue;
                    }
                    if (findLecture(crn, lecs).lab) {
                        Random myRand = new Random();

                        int randomLab = myRand.nextInt(findLecture(crn, lecs).labs.size() + 1);

                        System.out.println(findLecture(crn, lecs) + " has these labs:\n" + findLecture(crn, lecs).labs);
                        System.out.println(
                                "[" + name + "] is added to lab " + findLecture(crn, lecs).labs.get(randomLab));

                        labsTaken.add(findLecture(crn, lecs).labs.get(randomLab));
                    }

                    lecturesTaken.add(findLecture(crn, lecs));
                }
            }

            // add the student to the people's list and print that they were enrolled
            people.add(new Student(name, id, graduate, lecturesTaken, labsTaken));
            System.out.println("New student enrolled!");
        }

    }

    // methods to print a faculty/student/ta
    // basically the same for everything, it just changes the class type
    public static void printFaculty(ArrayList<Person> people) {
        // get the id
        int id = idInput();

        // if it exists, print the record found
        if (facultyExists(id, people)) {
            System.out.println("Record found");
            System.out.println(findFaculty(id, people));
        } else {
            // if not, say sorry :(
            System.out.println("Sorry, no record found");
        }

    }

    public static void printStudent(ArrayList<Person> people) {
        int id = idInput();

        if (studentExists(id, people)) {
            System.out.println("Record found");
            System.out.println(findStudent(id, people));
        } else {
            System.out.println("Sorry, no record found");
        }

    }

    public static void printTA(ArrayList<Person> people) {
        int id = idInput();

        if (taExists(id, people)) {
            System.out.println("Record found");
            System.out.println(findTA(id, people));
        } else {
            System.out.println("Sorry, no record found");
        }

    }

    // method to delete a lecture
    public static void deleteLecture(ArrayList<Lecture> lecs, ArrayList<Person> people) {
        // get the course number of lecture to be deleted
        int crn = intInput("Enter crn of the lecture to delete:");
        // if the lecture is on the list
        if (lectureExists(crn, lecs)) {
            // loop through the people in the array
            for (Person p : people) {
                // if that lecture is in any array list for any entity, remove it from the
                // entity's array list

                if (p instanceof Faculty && ((Faculty) p).lecturesTaught.contains(findLecture(crn, lecs))) {
                    ((Faculty) p).lecturesTaught.remove(findLecture(crn, lecs));
                }

                if (p instanceof Student && ((Student) p).lecturesTaken.contains(findLecture(crn, lecs))) {
                    ((Student) p).lecturesTaken.remove(findLecture(crn, lecs));
                }

                if (p instanceof TA && ((TA) p).lecturesTaken.contains(findLecture(crn, lecs))) {
                    ((TA) p).lecturesTaken.remove(findLecture(crn, lecs));
                }

            }

            // now if the lecture has labs too
            if (findLecture(crn, lecs).lab) {
                // loop through the lab and through the people array
                for (Lab l : findLecture(crn, lecs).labs) {
                    for (int i = 0; i < people.size(); i++) {
                        Person p = people.get(i);
                        // if the lab is in any array list from a student or ta, remove it from the
                        // student/ta's labs array list
                        if (p instanceof Student && ((Student) p).labsTaken.contains(l)) {
                            ((Student) p).labsTaken.remove(l);
                        }

                        if (p instanceof TA && ((TA) p).labsTaken.contains(l)) {
                            ((TA) p).labsTaken.remove(l);
                        }

                        if (p instanceof TA && ((TA) p).labsSupervised.contains(l)) {
                            ((TA) p).labsSupervised.remove(l);

                            // if the ta is not supervising any labs no more
                            if (((TA) p).labsSupervised.size() == 0) {
                                // the ta returns to only being a student
                                Student s = new Student((TA) p);
                                // replace the ta with only student
                                people.set(i, s);
                            }
                        }

                    }
                }
            }

            // print that the lecture was deleted
            System.out.println(findLecture(crn, lecs) + " deleted");
            // delete the lecture
            lecs.remove(findLecture(crn, lecs));
        }
    }

    // methods to see if a student/ta/student or ta/faculty exists in the array list
    public static boolean studentExists(int id, ArrayList<Person> people) {
        for (Person p : people) {
            if (p.id == id && p instanceof Student) {
                return true;
            }
        }
        return false;
    }

    public static boolean taStudentExists(int id, ArrayList<Person> people) {
        for (Person p : people) {
            if (p.id == id && (p instanceof TA || p instanceof Student)) {
                return true;
            }
        }
        return false;
    }

    public static boolean taExists(int id, ArrayList<Person> people) {
        for (Person p : people) {
            if (p.id == id && p instanceof TA) {
                return true;
            }
        }
        return false;
    }

    public static boolean facultyExists(int id, ArrayList<Person> people) {
        for (Person p : people) {
            if (p.id == id && p instanceof Faculty) {
                return true;
            }
        }
        return false;
    }

    // method to see if a lecture exists in the array list
    public static boolean lectureExists(int crn, ArrayList<Lecture> lecs) {
        for (Lecture l : lecs) {
            if (l.courseNumber == crn) {
                return true;
            }
        }
        return false;
    }

    // method to get the lecture based on the crn
    public static Lecture findLecture(int crn, ArrayList<Lecture> lecs) {
        Lecture lec = new Lecture();
        for (Lecture l : lecs) {
            if (l.courseNumber == crn) {
                lec = l;
                break;
            }
        }
        return lec;
    }

    // method to get a student/ta/faculty based on the id
    public static Student findStudent(int id, ArrayList<Person> people) {
        Student s = new Student();
        for (Person p : people) {
            if (p.id == id && (p instanceof Student)) {
                s = (Student) p;
            }
        }
        return s;
    }

    public static TA findTA(int id, ArrayList<Person> people) {
        TA t = new TA();
        for (Person p : people) {
            if (p.id == id && p instanceof TA) {
                t = (TA) p;
            }
        }
        return t;
    }

    public static Faculty findFaculty(int id, ArrayList<Person> people) {
        Faculty f = new Faculty();
        for (Person p : people) {
            if (p.id == id && p instanceof Faculty) {
                f = (Faculty) p;
            }
        }
        return f;
    }

    // method check if the id is in use or available
    public static boolean checkValidId(int id, ArrayList<Person> people) {
        for (Person p : people) {
            if (p.id == id) {
                return true;
            }
        }
        return false;
    }

    // method to print goodbye :)
    public static void displayGoodbye() {
        System.out.println("Goodbye!");
    }
}

class Lecture {
    public String prefix;
    public int courseNumber;
    public String modality;
    public String location;
    public String description;
    public boolean graduate;
    public boolean lab;
    public ArrayList<Lab> labs = new ArrayList<Lab>();

    // method use in setup function to add lab to a lecture
    public void addLab(Lab lab) {
        this.labs.add(lab);
    }

    // constructors
    public Lecture() {
    }

    public Lecture(String prefix, int courseNumber, String modality, String location, String description,
            boolean graduate, boolean lab) {
        this.prefix = prefix;
        this.courseNumber = courseNumber;
        this.modality = modality;
        this.location = location;
        this.description = description;
        this.graduate = graduate;
        this.lab = lab;
    }

    // toString method in format like [COT6578/Advanced Computer theory]
    public String toString() {
        return "[" + prefix + "/" + description + "]";
    }

}

class Lab {
    public int courseNumber;
    public String location;

    // constructor
    public Lab(int courseNumber, String location) {
        this.courseNumber = courseNumber;
        this.location = location;
    }

    // toString method in format [91862]
    public String toString() {
        return "[" + courseNumber + "]";
    }

}

abstract class Person {
    public String name;
    public int id;

    // constructors
    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // basic too string method
    public String toString() {
        return "----------------------------\nName: " + name + "\nUCF ID: " + id;
    }
}

class Faculty extends Person {
    public String rank;
    public String officeLocation;
    public ArrayList<Lecture> lecturesTaught;

    // constructors
    public Faculty() {
    }

    public Faculty(String name, int id, String rank, String officeLocation, ArrayList<Lecture> lecturesTaught) {
        super(name, id);
        this.rank = rank;
        this.officeLocation = officeLocation;
        this.lecturesTaught = lecturesTaught;
    }

    // override toString method to include lectures taught
    public String toString() {
        return super.toString() + "\nLectures Taught: " + lecturesTaught + "\n----------------------------";
    }

}

class Student extends Person {
    public boolean graduate;
    public ArrayList<Lecture> lecturesTaken;
    public ArrayList<Lab> labsTaken;

    // constructors
    public Student() {
    }

    public Student(String name, int id, boolean graduate, ArrayList<Lecture> lecturesTaken, ArrayList<Lab> labsTaken) {
        super(name, id);
        this.graduate = graduate;
        this.lecturesTaken = lecturesTaken;
        this.labsTaken = labsTaken;
    }

    // construct a student with ta information
    public Student(TA ta) {
        super(ta.name, ta.id);
        this.graduate = ta.graduate;
        this.lecturesTaken = ta.lecturesTaken;
        this.labsTaken = ta.labsTaken;
    }

    // override toString method to include lectures taken and labs taken
    public String toString() {
        return super.toString() + "\nLectures Taken: " + lecturesTaken + "\nLabs taken: " + labsTaken
                + "\n----------------------------";
    }

}

class TA extends Student {
    public ArrayList<Lab> labsSupervised;
    public String advisorName;
    public String expectedDegree;

    // method used in addFaculty method, assign a lab to ta
    public void addLabSupervised(Lab l) {
        labsSupervised.add(l);
    }

    // constructors
    public TA() {
    }

    // constructor for addFaculty method, empty lecturesTaken, labsTaken and
    // labsSupervised
    public TA(String name, int id, boolean graduate, String advisorName, String expectedDegree) {
        super(name, id, graduate, new ArrayList<Lecture>(), new ArrayList<Lab>());
        this.labsSupervised = new ArrayList<Lab>();
        this.advisorName = advisorName;
        this.expectedDegree = expectedDegree;
    }

    public TA(String name, int id, boolean graduate, ArrayList<Lecture> lecturesTaken, ArrayList<Lab> labsTaken,
            ArrayList<Lab> labsSupervised,
            String advisorName, String expectedDegree) {
        super(name, id, graduate, lecturesTaken, labsTaken);
        this.labsSupervised = labsSupervised;
        this.advisorName = advisorName;
        this.expectedDegree = expectedDegree;
    }

    // override toString method to include lectures taken, labs taken and labs
    // supervised
    public String toString() {
        return "----------------------------\nName: " + name + "\nUCF ID: " + id + "\nLectures Taken: "
                + lecturesTaken + "\nLabs Taken: " + labsTaken
                + "\nLabs Supervised: "
                + labsSupervised + "\n----------------------------";
    }

}

// new class to handle the id exception
class IdException extends Exception {
    public String toString() {
        return "Sorry incorrect format. (Ids are 7 digits)";
    }
}