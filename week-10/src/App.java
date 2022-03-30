public class App {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");

        String s3 = "abc";
        String s4 = "abc";

        // uncomment short employee class
        // if you do not define your own toString method, then it will print the memory
        // address
        // System.out.println((new Employee()).toString());

        System.out.println(s1 == s2); // false (s1 and s2 are pointing to two different locations)
        System.out.println(s3 == s4); // true (pointing to the same place in memory)
        System.out.println(s1 == s3); // false

        // point to the same object
        Employee e1 = new Employee(111, "john"), e2 = e1;

        // same object characteristics
        Employee e3 = new Employee(111, "john");

        // true
        System.out.println(e1 == e2);

        // false
        System.out.println(e1 == e3);

        // false (before the equals overide)
        System.out.println(e1.equals(e3));

        // true (after the equals overide)
        System.out.println(e1.equals(e3));

    }

}

// class Employee
// {

// }

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    // // @Override
    // public boolean equals(Employee obj)
    // {
    // return this.id == obj.id;
    // }

    @Override
    // cast the object
    public boolean equals(Object obj) {
        return this.id == ((Employee) obj).id;
    }
}