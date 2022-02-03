/*
Nicole Zolnier and Trae Roy
Project 1 - 02/02/2022
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {

        // initalize setup
        setup();

        // class variable
        Project1 sol = new Project1();

        // declare variables
        int crn, id, numLectures, numLabs, ans;
        String name, location;

        // assign class variables
        Student student = new Student();
        Faculty faculty = new Faculty();
        TAs tas = new TAs();

        // display menu and scan choice
        displayMenu();
        ans = sol.choiceInputMethod();

        // while loop
        while(ans != 3) {
            switch(ans) {
                // case 1, choice 1
                case 1:
                    //function
                    break;
                // case 2, choice 2
                case 2:
                    // function
                    break;
                // invalid choice reprint menu and get choice
                default:
                    displayMenu();
                    ans = sol.choiceInputMethod();
            }
        }
        displayGoodbye();

    }

    // functions
    private final Scanner input = new Scanner(System.in);

    public static void setup() {
        // COT6578
        Course a = new Course();
        a.setPrefix("COT6578");
        a.setCourseNumber(89745);
        a.setModality("F2F");
        a.setLab(false);
        a.setDescription("Advanced Computer theory, Graduate");

        // testing it out
        System.out.println(a.getPrefix());

        // COP5698
        Course b = new Course();
        b.setPrefix("COP5698");
        b.setCourseNumber(69745);
        b.setModality("F2F");
        b.setLab(true);
        b.setLabs(19745, 1234567);
        b.setLabs(36598, 2589631);
        b.setLabs(20315, 7845129);
        // b.setLabs();
        b.setDescription("Programming Languages, Graduate");

        System.out.println(b.getPrefix());

        // COP 3330
        Course c = new Course();
        c.setPrefix("COP 3330");
        c.setCourseNumber(80000);
        c.setModality("F2F");
        c.setLab(false);
        c.setDescription("Introduction Object Oriented Programming, Undergraduate");

        System.out.println(c.getPrefix());
    }

    public static void displayMenu() {
        System.out.println("___________Choose one of the options____________________");
        System.out.println("1.  Enter the information of the faculty, the TA or the student");
        System.out.println("2.  Print schedule");
        System.out.println("3.  Exit Program");
    }

    public int choiceInputMethod() {
        System.out.println("\tEnter your selection: ");
        return input.nextInt();
    }

    public int inputMethod1(String prompt) {
        System.out.println(prompt);
        return input.nextInt();
    }

    public String inputMethod2(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    public static void displayGoodbye() {
        System.out.println("Goodbye! ");
    }

}

// ------ classes ------
class Course {
    private String prefix;
    private int courseNumber;
    private String modality;
    private boolean lab;
    private ArrayList<Integer> labs;
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

    public ArrayList<Integer> getLabs() {
        return labs;
    }

    public void setLabs(int labNum, int ta) {
        this.labs.add(labNum, ta);
        this.labs = labs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

class Student {
    protected String name;
    protected int id;
    protected boolean graduate;
    protected ArrayList<Course> lecturesTaken;


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

class Faculty {
    private String name;
    private int id;
    private String rank;
    private String officeLocation;
    private ArrayList<Course> lecturesTaught;


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

class TAs extends Student {
    ArrayList<Integer> labsSupervised;
    private Faculty advisor;
    private String expectedDegree;


    public ArrayList<Integer> getLabsSupervised() {
        return labsSupervised;
    }

    public void setLabsSupervised(ArrayList<Integer> labsSupervised) {
        this.labsSupervised = labsSupervised;
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

    public void addlab(int lab, int ta) {
        this.labsSupervised.add(lab, ta);
    }

}