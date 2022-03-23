
/*
Nicole Zolnier and Trae Roy
Project 2
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) throws FileNotFoundException {
        setup();

        // displayMenu();
        String ans = choiceInput();

        ArrayList<Person> ucfPeople = new ArrayList<Person>();

        while (!ans.equals("7")) {
            switch (ans) {
                case "1":
                    System.out.println("add new faculty");
                    break;
                case "2":
                    System.out.println("enroll student");
                    break;
                case "3":
                    System.out.println("print schedule faculty");
                    break;
                case "4":
                    System.out.println("print schedule ta");
                    break;
                case "5":
                    System.out.println("print schedule student");
                    break;
                case "6":
                    System.out.println("delete lecture");
                    break;
                // invalid choice reprint menu and get choice
                default:
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

    public static void setup() throws FileNotFoundException {
        ArrayList<Lecture> lecs = new ArrayList<Lecture>();
        String buffer, prefix, modality, location, description;
        int courseNumber, i=0;
        boolean graduate, lab;
        String[] token;
        Lecture l;

        Scanner s = new Scanner(new File("lec.txt"));

        int labCourse;
        String labLocation;

        // while the file has a next line, i:
        while (s.hasNextLine()) {
            // set the buffer as the line
            i++;
            buffer = s.nextLine();
            token = buffer.split(",");

            // order = 69745,COP5698,Programming Languages,Graduate,F2F,CB2-122,YES

            
            if (token.length == 2) {
                labCourse = Integer.parseInt(token[0].trim());
                labLocation = token[1];
                
                l.addLab(new Lab(labCourse, labLocation));
            } else {
                buffer = s.nextLine();
                token = buffer.split(",");

                courseNumber = Integer.parseInt(token[0]);
                prefix = token[1];
                description = token[2];
                graduate = (token[3].toLowerCase().equals("graduate"));
                modality = token[4];
                if (modality.toLowerCase().equals("f2f")) {
                    location = token[5];
                    lab = (token[6].toLowerCase().equals("yes"));

                } else {
                    location = "";
                    lab = false;
                }

                l = new Lecture(prefix, courseNumber, modality, location, description, graduate, lab);
                System.out.println(l + "\n--------------------");
                lecs.add(l);
                System.out.println(Arrays.toString(token));
            }

        }
        // return lecs;
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

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getCourseNumber() {
        return this.courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getModality() {
        return this.modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGraduate() {
        return this.graduate;
    }

    public boolean getGraduate() {
        return this.graduate;
    }

    public void setGraduate(boolean graduate) {
        this.graduate = graduate;
    }

    public boolean isLab() {
        return this.lab;
    }

    public boolean getLab() {
        return this.lab;
    }

    public void setLab(boolean lab) {
        this.lab = lab;
    }

    public ArrayList<Lab> getLabs() {
        return this.labs;
    }

    public void setLabs(ArrayList<Lab> labs) {
        this.labs = labs;
    }

    public void addLab(Lab lab) {
        this.labs.add(lab);
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
        return "{" +
                " prefix='" + getPrefix() + "'" +
                ", courseNumber='" + getCourseNumber() + "'" +
                ", modality='" + getModality() + "'" +
                ", location='" + getLocation() + "'" +
                ", description='" + getDescription() + "'" +
                ", graduate='" + isGraduate() + "'" +
                ", lab='" + isLab() + "'" +
                ", labs='" + getLabs() + "'" +
                "}";
    }

}

class Lab {
    public int courseNumber;
    public String location;

    public Lab(int courseNumber, String location) {
        this.courseNumber = courseNumber;
        this.location = location;
    }

    public int getCourseNumber() {
        return this.courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "{" +
                " courseNumber='" + getCourseNumber() + "'" +
                ", location='" + getLocation() + "'" +
                "}";
    }

}

abstract class Person {
    public String name;
    public int id;
}

class Faculty extends Person {
    public String rank;
    public String officeLocation;
    public ArrayList<Lecture> lecturesTaught;
}

class Student extends Person {
    public boolean graduate;
    public ArrayList<Lecture> lecturesTaken;
}

class TA extends Student {
    public ArrayList<Lab> labsSupervised;
    public Faculty advisor;
    public String expectedDegree;
}