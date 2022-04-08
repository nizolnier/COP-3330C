/* Nicole Zolnier - 04/04/2022
Homework 5
*/
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Homework5 {
    public static void main(String[] args) throws Exception {
        // creating 3 employees
        // these are the ones from the original document
        Employee emp1 = new Employee(111, "Jimmy Dean", 48369.95, 0), emp2 = new Employee(598, "Jen Johnson", 47370, 5),
                emp3 = new Employee(920, "Jan Jones", 47834.25, 1);

        System.out.println(emp1.equals(emp3)); // prints false
 
        emp1.setSalary(48359.9); // but if the salary for employee is updated

        System.out.println(emp1.equals(emp3)); // it prints true

        // creating array list and adding the employees
        ArrayList<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        // calling the sort method with the comparator
        Collections.sort(list, new EmpComparator());

        // printing :)
        for (Employee e : list)
            System.out.println(e);

    }
}

class Employee {
    // private attributes
    private int id;
    private String name;
    private double salary;
    private int numberOfDependents;

    // setters and getters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getNumberOfDependents() {
        return this.numberOfDependents;
    }

    public void setNumberOfDependents(int numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    // method to get the net salary
    // this will keep updated if the salary/number of dependents changes
    public double getNetSalary() {
        // using formula provided
        double netSalary = salary * 0.91 + (numberOfDependents * 0.01 * salary); 

        // little trick to make the netSalary be rounded to 2 decimal places
        // i used BigDecimal bc i was having some trouble with string.format
        return new BigDecimal(netSalary).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // overriding the equals method
    // the objects are only equal if they have the same net salary
    public boolean equals(Object obj) {
        return this.getNetSalary() == ((Employee) obj).getNetSalary();
    }

    // overriding the toString method to print in the format
    // [id,name,net salary]
    public String toString() {
        return "[id: " + id + ", name: " + name + ", net salary: " + getNetSalary() + "]";
    }

    // constructor
    public Employee(int id, String name, double salary, int numberOfDependents) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.numberOfDependents = numberOfDependents;
    }

}

// comparator for the sort method
class EmpComparator implements Comparator<Employee> {
    // this overrides the compare method and sorts based on the net salary
    public int compare(Employee e1, Employee e2) {
        if(e1.getNetSalary() == e2.getNetSalary()) return 0;
        if(e1.getNetSalary() > e2.getNetSalary()) return 1;
        return -1;
    }
}