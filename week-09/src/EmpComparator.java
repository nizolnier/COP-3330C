import java.util.Comparator;

public class EmpComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        if(e1.getId() == e2.getId()) return 0;
        if(e1.getId() > e2.getId()) return 1;
        return -1;
    }
}
