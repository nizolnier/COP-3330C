import java.util.Comparator;

public class Employee implements Comparator<Employee>, Comparable<Employee> {
    private int id;
    private String name;

    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }

    public int compare(Employee e1, Employee e2) {
        if(e1.id == e2.id) return 0;
        if(e1.id > e2.id) return 1;
        return -1;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters and setters
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

}
