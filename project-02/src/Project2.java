
/*
Nicole Zolnier
Project 2
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Person> ucfPeople = new ArrayList<Person>();
        ArrayList<Lecture> ucfLectures = setup();

        // testing out constructors and toString
        Faculty f = new Faculty("John", 5555, "Professor", "CB2", ucfLectures);
        Student s = new Student("Sam", 2222, true, ucfLectures, ucfLectures.get(3).labs);

        TA t = new TA("Anna", 3333, false, ucfLectures, ucfLectures.get(3).labs, ucfLectures.get(3).labs, "John",
                "phd");
        System.out.println(f);
        System.out.println(s);
        System.out.println(t);

        loopMenuChoices(ucfLectures, ucfPeople);

        displayGoodbye();
    }

    // input methods
    public static String choiceInput() {
        System.out.println("\tEnter your selection: ");
        return new Scanner(System.in).nextLine();
    }

    public static int intInput(String prompt) {
        System.out.println(prompt);
        return new Scanner(System.in).nextInt();
    }

    public static String stringInput(String prompt) {
        System.out.println(prompt);
        return new Scanner(System.in).nextLine();
    }

    // -------------
    public static ArrayList<Lecture> setup() throws FileNotFoundException {
        ArrayList<Lecture> lecs = new ArrayList<Lecture>();
        String buffer, prefix, modality, location, description;
        int courseNumber;
        boolean graduate, lab;
        String[] token;
        Lecture l;

        Scanner s = new Scanner(new File("lec.txt"));

        int labCourse;
        String labLocation;

        while (s.hasNextLine()) {
            buffer = s.nextLine();
            token = buffer.split(",");

            if (token.length == 2) {
                labCourse = Integer.parseInt(token[0]);
                labLocation = token[1].trim();

                // get the last saved lec and add in the labs
                lecs.get(lecs.size() - 1).addLab(new Lab(labCourse, labLocation));
            } else {
                // order = 69745,COP5698,Programming Languages,Graduate,F2F,CB2-122,YES
                courseNumber = Integer.parseInt(token[0]);
                prefix = token[1];
                description = token[2];
                graduate = (token[3].equalsIgnoreCase("graduate"));
                modality = token[4];
                // if the modality is online, it ends on token[4]
                if (modality.equalsIgnoreCase("f2f")) {
                    location = token[5];
                    lab = (token[6].equalsIgnoreCase("yes"));
                } else {
                    location = "";
                    lab = false;
                }

                l = new Lecture(prefix, courseNumber, modality, location, description, graduate, lab);
                lecs.add(l);
            }

        }

        return lecs;
    }

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
        do {
            displayMenu();
            ans = choiceInput();
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
        String name = stringInput("Enter name: ");
        int id = intInput("Enter UCF id: ");
        while (checkValidId(id, people)) {
            id = intInput("Sorry, that UCF id is already in use. Enter a new UCF id: ");
        }
        String rank = stringInput("Enter rank: ");
        String officeLocation = stringInput("Enter office location: ");
        int numLecs = intInput("Enter how many lectures");
        ArrayList<Lecture> lecturesTaught = new ArrayList<Lecture>();

        int crn;
        for (int i = 0; i < numLecs; i++) {
            crn = intInput("Enter the crn of the " + (i + 1) + "° lecture to assign to this faculty");
            if (lectureExists(crn, lecs)) {
                if (findLecture(crn, lecs).lab) {
                    for (int j = 0; j < findLecture(crn, lecs).labs.size(); j++) {
                        int taId = intInput("Enter the UCF id of the TA");

                        if (taExists(taId, people)) {
                            // TODO print added
                            findTA(taId, people).addLabSupervised(findLecture(crn, lecs).labs.get(j));
                        } else {
                            String taName = stringInput("Enter name of the TA");
                            boolean graduate = true;
                            String advisorName = stringInput("Enter TA's supervisor's name:");
                            String expectedDegree = stringInput("Enter TA's degree seeking");

                            people.add(new TA(taName, taId, graduate, advisorName, expectedDegree));

                        }
                    }
                }

                // TODO print lecture prefix/name
                lecturesTaught.add(findLecture(crn, lecs));
            }
        }

        people.add(new Faculty(name, id, rank, officeLocation, lecturesTaught));

        System.out.println("New faculty added!");

    }

    public static void addStudent(ArrayList<Lecture> lecs, ArrayList<Person> people) {
        int id = intInput("Enter UCF id: ");
        if (studentExists(id, people)) {
            int numLecs = intInput("Enter how many lectures");
            int crn;

            for (int i = 0; i < numLecs; i++) {
                crn = intInput("Enter the crn of the " + (i + 1) + "° lecture to enroll student");
                if (lectureExists(crn, lecs)) {
                    if (findLecture(crn, lecs).graduate && !findStudent(id, people).graduate) {
                        System.out.println("This is a graduate level class");
                        continue;
                    }
                    if (findLecture(crn, lecs).lab) {
                        Random myRand = new Random();

                        int randomLab = myRand.nextInt(findLecture(crn, lecs).labs.size() + 1);

                        // TODO print lecture prefix/name
                        findStudent(id, people).labsTaken.add(findLecture(crn, lecs).labs.get(randomLab));
                    }
                    findStudent(id, people).lecturesTaken.add(findLecture(crn, lecs));
                }
            }

            System.out.println("Student enrolled!");
        } else if (taExists(id, people)) {

            int numLecs = intInput("Enter how many lectures");
            int crn;

            for (int i = 0; i < numLecs; i++) {
                crn = intInput("Enter the crn of the " + (i + 1) + "° lecture to enroll student");
                if (lectureExists(crn, lecs)) {
                    if (findLecture(crn, lecs).graduate && !findTA(id, people).graduate) {
                        System.out.println("This is a graduate level class");
                        continue;
                    }
                    if (findLecture(crn, lecs).lab) {
                        Random myRand = new Random();

                        int randomLab = myRand.nextInt(findLecture(crn, lecs).labs.size() + 1);

                        // TODO print lecture prefix/name
                        findTA(id, people).labsTaken.add(findLecture(crn, lecs).labs.get(randomLab));
                    }
                    findTA(id, people).lecturesTaken.add(findLecture(crn, lecs));
                }
            }

            System.out.println("Student enrolled!");

        } else {
            String name = stringInput("Enter name:");
            String grad = stringInput("Are you a graduate student?");
            boolean graduate = (grad.equalsIgnoreCase("yes"));

            int numLecs = intInput("Enter how many lectures");
            ArrayList<Lecture> lecturesTaken = new ArrayList<Lecture>();
            ArrayList<Lab> labsTaken = new ArrayList<Lab>();

            int crn;
            for (int i = 0; i < numLecs; i++) {
                crn = intInput("Enter the crn of the " + (i + 1) + "° lecture to enroll student");
                if (lectureExists(crn, lecs)) {
                    if (findLecture(crn, lecs).graduate && !graduate) {
                        System.out.println("This is a graduate level class");
                        continue;
                    }
                    if (findLecture(crn, lecs).lab) {
                        Random myRand = new Random();

                        int randomLab = myRand.nextInt(findLecture(crn, lecs).labs.size() + 1);

                        labsTaken.add(findLecture(crn, lecs).labs.get(randomLab));
                    }
                    // TODO print lecture prefix/name
                    lecturesTaken.add(findLecture(crn, lecs));
                }
            }

            people.add(new Student(name, id, graduate, lecturesTaken, labsTaken));

            System.out.println("New student enrolled!");
        }

    }

    public static void printFaculty(ArrayList<Person> people) {
        int id = intInput("Enter UCF id: ");

        if (facultyExists(id, people)) {
            System.out.println(findFaculty(id, people));
        }

    }

    public static void printStudent(ArrayList<Person> people) {
        int id = intInput("Enter UCF id: ");

        if (studentExists(id, people)) {
            System.out.println(findStudent(id, people));
        }

    }

    public static void printTA(ArrayList<Person> people) {
        int id = intInput("Enter UCF id: ");

        if (taExists(id, people)) {
            System.out.println(findTA(id, people));
        }

    }

    public static void deleteLecture(ArrayList<Lecture> lecs, ArrayList<Person> people) {
        int crn = intInput("Enter crn of the lecture to delete:");
        if (lectureExists(crn, lecs)) {
            lecs.remove(findLecture(crn, lecs));

            for (Person p : people) {
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

            // TODO delete lab
        }
    }

    public static boolean studentExists(int id, ArrayList<Person> people) {
        for (Person p : people) {
            if (p.id == id && p instanceof Student) {
                return true;
            }
        }
        return false;
    }

    public static boolean taExists(int id, ArrayList<Person> people) {
        for (Person p : people) {
            if (p.id == id && (p instanceof TA || p instanceof Student)) {
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
            if (p.id == id && (p instanceof TA || p instanceof Student)) {
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

    public static boolean checkValidId(int id, ArrayList<Person> people) {
        for (Person p : people) {
            if (p.id == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean lectureExists(int crn, ArrayList<Lecture> lecs) {
        for (Lecture l : lecs) {
            if (l.courseNumber == crn) {
                return true;
            }
        }
        return false;
    }

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

    public void addLab(Lab lab) {
        this.labs.add(lab);
    }

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

    public String toString() {
        return "{ Course Number: " + courseNumber + " }";
    }

}

class Lab {
    public int courseNumber;
    public String location;

    public Lab(int courseNumber, String location) {
        this.courseNumber = courseNumber;
        this.location = location;
    }

    public String toString() {
        return "{ Course Number: " + courseNumber + " }";
    }

}

abstract class Person {
    public String name;
    public int id;

    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "----------------------------\nName: " + name + "\nUCF ID: " + id;
    }
}

class Faculty extends Person {
    public String rank;
    public String officeLocation;
    public ArrayList<Lecture> lecturesTaught;

    public Faculty() {
    }

    public Faculty(String name, int id, String rank, String officeLocation, ArrayList<Lecture> lecturesTaught) {
        super(name, id);
        this.rank = rank;
        this.officeLocation = officeLocation;
        this.lecturesTaught = lecturesTaught;
    }

    public String toString() {
        return super.toString() + "\nLectures Taught: " + lecturesTaught + "\n----------------------------";
    }

}

class Student extends Person {
    public boolean graduate;
    public ArrayList<Lecture> lecturesTaken;
    public ArrayList<Lab> labsTaken;

    public Student() {
    }

    public Student(String name, int id, boolean graduate, ArrayList<Lecture> lecturesTaken, ArrayList<Lab> labsTaken) {
        super(name, id);
        this.graduate = graduate;
        this.lecturesTaken = lecturesTaken;
        this.labsTaken = labsTaken;
    }

    public String toString() {
        // TODO print lab too
        return super.toString() + "\nLectures Taken: " + lecturesTaken + "\n----------------------------";
    }

}

class TA extends Student {
    public ArrayList<Lab> labsSupervised;
    public String advisorName;
    public String expectedDegree;

    public void addLabSupervised(Lab l) {
        labsSupervised.add(l);
    }

    public TA() {
    }

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

    public String toString() {
        return "----------------------------\nName: " + super.name + "\nUCF ID: " + super.id + "\nLabs Supervised "
                + labsSupervised + "\n----------------------------";
    }
}