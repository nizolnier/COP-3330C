import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        /* Employee e1 = new Employee(555, "Jim Halpert"), e2 = new Employee(888, "Pam Beesly");
        // testing out the comparator
        System.out.println(new EmpComparator().compare(e1, e2)); */

        ArrayList <Employee> list = new ArrayList<Employee>();

        list.add(new Employee(111, "Michael Scott"));
        list.add(new Employee(555, "Dwight Schrute"));
        list.add(new Employee(333, "Angela Martin"));

        System.out.println("Before............\n" + list);

        Collections.sort(list);

        System.out.println("\nAfter compareTo............\n" + list);

        Collections.sort(list, new EmpComparator());

        System.out.println("\nAfter compare............\n" + list);


        Collections.sort(list);

        Comparator<Employee> EmpComparator2 = new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.getId() > e2.getId() ? 1 : -1;
            }
        };

        Collections.sort(list, EmpComparator2);

        System.out.println("\nAfter compare 2............\n" + list);
    }
}
