/* Nicole Zolnier - 04/03/2022
Homework 5
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Homework5 {
    public static void main(String[] args) throws Exception {
        Employee emp1 = new Employee(111, "Jimmy Dean", 48369.95, 0), emp2 = new Employee(598, "Jen Johnson", 47370, 5),
                emp3 = new Employee(920, "Jan Jones", 47834.25, 1);

        System.out.println(emp1.equals(emp3));

        ArrayList<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        Collections.sort(list, new EmpComparator());

        for (Employee e : list)
            System.out.println(e);

    }
}

class Employee {
    private int id;
    private String name;
    private double salary;
    private int numberOfDependents;
    private double netSalary;

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

    public double getNetSalary() {
        return this.netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public boolean equals(Object obj) {
        return this.netSalary == ((Employee) obj).netSalary;
    }

    public String toString() {
        return "[id: " + id + ", name: " + name + ", net salary: " + String.format("%.2f", netSalary) + "]";
    }

    public Employee(int id, String name, double salary, int numberOfDependents) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.numberOfDependents = numberOfDependents;
        this.netSalary = salary * 0.91 + (numberOfDependents * 0.01 * salary);
    }

}

class EmpComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        if(e1.getNetSalary() == e2.getNetSalary()) return 0;
        if(e1.getNetSalary() > e2.getNetSalary()) return 1;
        return -1;
    }
}