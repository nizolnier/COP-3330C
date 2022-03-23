
/*
Nicole Zolnier and Trae Roy
Project 2
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Person> ucfPeople = new ArrayList<Person>();
        ArrayList<Lecture> ucfLectures = setup();

        // testing out constructors and toString
        Faculty f = new Faculty("John", 5555, "Professor", "CB2", ucfLectures);
        Student s = new Student("Sam", 2222, true, ucfLectures);
        TA t = new TA("Anna", 3333, false, ucfLectures, ucfLectures.get(3).labs, f, "phd");
        System.out.println(f);
        System.out.println(s);
        System.out.println(t);

        displayMenu();
        String ans = choiceInput();

        while (!ans.equals("7")) {
            if (ans.equals("1")) {
                System.out.println("add new faculty");
                break;
            } else if (ans.equals("2")) {
                System.out.println("enroll student");
                break;
            } else if (ans.equals("3")) {
                System.out.println("print schedule faculty");
                break;
            } else if (ans.equals("4")) {
                System.out.println("print schedule ta");
                break;
            } else if (ans.equals("5")) {
                System.out.println("print schedule student");
                break;
            } else if (ans.equals("6")) {
                deleteLecture(ucfLectures);
                break;
            } else {
                displayMenu();
                ans = choiceInput();
                break;
            }
        }

        displayGoodbye();
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

    public static void displayGoodbye() {
        System.out.println("Goodbye! ");
    }

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
                graduate = (token[3].toLowerCase().equals("graduate"));
                modality = token[4];
                // if the modality is online, it ends on token[4]
                if (modality.toLowerCase().equals("f2f")) {
                    location = token[5];
                    lab = (token[6].toLowerCase().equals("yes"));
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

    public static void deleteLecture(ArrayList<Lecture> lecs) {
        int crn = intInput("Enter crn of the lecture to delete:");
        boolean inLecs = false;
        Lecture lec = new Lecture();

        for (Lecture l : lecs) {
            if (l.courseNumber == crn) {
                inLecs = true;
                lec = l;
                break;
            }
        }

        if (inLecs) {
            int index = lecs.indexOf(lec);
            lecs.remove(index);
            System.out.println("Ok, " + crn + " has been deleted.");

        } else {
            System.out.println("Sorry, lecture not found");
        }
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

    public Student(String name, int id, boolean graduate, ArrayList<Lecture> lecturesTaken) {
        super(name, id);
        this.graduate = graduate;
        this.lecturesTaken = lecturesTaken;
    }

    public String toString() {
        return super.toString() + "\nLectures Taken: " + lecturesTaken + "\n----------------------------";
    }

}

class TA extends Student {
    public ArrayList<Lab> labsSupervised;
    public Faculty advisor;
    public String expectedDegree;

    public TA(String name, int id, boolean graduate, ArrayList<Lecture> lecturesTaken, ArrayList<Lab> labsSupervised,
            Faculty advisor, String expectedDegree) {
        super(name, id, graduate, lecturesTaken);
        this.labsSupervised = labsSupervised;
        this.advisor = advisor;
        this.expectedDegree = expectedDegree;
    }

    public String toString() {
        return "----------------------------\nName: " + super.name + "\nUCF ID: " + super.id + "\nLabs Supervised "
                + labsSupervised + "\n----------------------------";
    }
}