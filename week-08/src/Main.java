import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList <Employee> list = new ArrayList<Employee>();

        list.add(new Employee(111, "Michael Scott"));
        list.add(new Employee(555, "Dwight Schrute"));
        list.add(new Employee(333, "Angela Martin"));

        System.out.println("Before............\n" + list);

        Collections.sort(list);

        System.out.println("\nAfter compareTo............\n" + list);

        Collections.sort(list);

        System.out.println("\nAfter compare............\n" + list);
    }
}
