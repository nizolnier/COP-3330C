public class App {
    public static void main(String[] args) throws Exception {
        Employee e = new Employee("Jim");
        System.out.println(e);

        Salaried s = new Salaried("Erika", 2.3);

        System.out.println(s);
        s.printCheck();

        Employee ee = new Salaried("Eri", 2.3);
        System.out.println(((Salaried) ee).getSalary());
    }
}


class HourlyPaid {
    private int hoursWorked;

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

}
//________________________________________
// child/sub class
class Salaried extends Employee {
    private double salary;

    public Salaried() {
        super();
        salary = 0.0;
    }

    public Salaried(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public Salaried(String name) {
        super(name);
    }

    public double getSalary() {
        return this.salary;
    }

    public String toString() {
        return super.toString() + " " + salary;
    }

    public void printCheck() {
        System.out.println("_____\n" + toString());
    }
}

//_________________________________________
// super class
// abstract class Employee - cannot create object, only reference
class Employee {
    private String name;

    public Employee() {
        this.name = "";
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}