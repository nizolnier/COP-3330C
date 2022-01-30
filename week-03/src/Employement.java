public class Employement {
    public static void main(String[] args) {
        Employee.setEmployerId("UCF123");

        Employee e1 = new Employee("Anna Edwards", "XYZ");
        System.out.println(e1.getEmployerId()); // XYZ

        Employee e2 = new Employee(), e3 = new Employee();

        e2.setEmployerId("USF456");

        System.out.println(e2.getEmployerId()); // USF456
        System.out.println(e3.getEmployerId()); // USF456
    }
}

class Employee {
    private String name;
    private static String employerId;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getEmployerId() {
        return employerId;
    }

    public static void setEmployerId(String employerId) {
        Employee.employerId = employerId;
    }

    public String toString() {
        return "Employee [name: " + name + "] [employer ID: " + employerId + "]";
    }

    // constructors
    public Employee(String name, String employerId) {
        this.name = name;
        this.employerId = employerId;
    }

    public Employee() {

    }

}