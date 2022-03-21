
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
        Project2 sol = new Project2();

        setup();

        //displayMenu();
        String ans = sol.choiceInput();

        ArrayList<Person> ucfPeople = new ArrayList<Person>();

        while (!ans.equals("7")) {
            switch (ans) {
                case "1" -> System.out.println("add new faculty");

                case "2" -> System.out.println("enroll student");

                case "3" -> System.out.println("print schedule faculty");

                case "4" -> System.out.println("print schedule ta");

                case "5" -> System.out.println("print schedule student");

                case "6" -> System.out.println("delete lecture");

                case "7" -> {
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

    private final Scanner input = new Scanner(System.in);

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

    public static void setup() throws FileNotFoundException {
        ArrayList<Lecture> lecs = new ArrayList<Lecture>();
        String buffer, prefix, modality, location, description;
        int courseNumber;
        boolean graduate, lab;
        ArrayList<Lab> labs = new ArrayList<Lab>();
        String[] token;
        Lecture l;

        Scanner s = new Scanner(new File("lec.txt"));

        // while the file has a next line, i:
        while (s.hasNextLine()) {
            // set the buffer as the line
            buffer = s.nextLine();
            token = buffer.split(",");

            // order = 69745,COP5698,Programming Languages,Graduate,F2F,CB2-122,YES
            if(token.length == 2) {
                continue;
            }

            courseNumber = Integer.parseInt(token[0]);
            prefix = token[1];
            description = token[2];

            graduate = (token[3].toLowerCase().equals("Graduate"));
            modality = token[4];
            if(modality.toLowerCase().equals("f2f")) {
                location = token[5];
                System.out.println(token[6]);
                lab = (token[6].toLowerCase().equals("yes"));

                if (lab) {
                buffer = s.nextLine();
                token = buffer.split(",");
                while (token.length == 2) {
                    labs.add(new Lab(Integer.parseInt(token[0]), token[1]));

                    buffer = s.nextLine();
                    token = buffer.split(",");
                }
                }

                System.out.println(labs);
            } else {
                location = "";
                lab = false;
            }
            
            l = new Lecture(prefix, courseNumber, modality, location, description, graduate, lab, labs);
            System.out.println(l);
            lecs.add(l);

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
    public ArrayList<Lab> labs;


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


    public Lecture(String prefix, int courseNumber, String modality, String location, String description,
            boolean graduate, boolean lab, ArrayList<Lab> labs) {
        this.prefix = prefix;
        this.courseNumber = courseNumber;
        this.modality = modality;
        this.location = location;
        this.description = description;
        this.graduate = graduate;
        this.lab = lab;
        this.labs = labs;
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