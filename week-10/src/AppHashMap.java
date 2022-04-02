import java.util.HashMap;

public class AppHashMap {
    public static void main(String[] args) {
        Employee2 e1 = new Employee2(777, "John");
        Employee2 e2 = new Employee2(777, "John");

        System.out.println(e1.hashCode());

        // Integer is a wrapper class
        HashMap<Integer, Employee2> myMap = new HashMap<Integer, Employee2>();

        myMap.put(e1.hashCode(), e1);
        System.out.println(myMap);
    }
}

class Employee2 {
    int id;
    String name;

    public Employee2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }
}