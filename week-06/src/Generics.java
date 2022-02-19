public class Generics {
    public static void main(String[] args) {
        IntegerClass myInt = new IntegerClass();
        DoubleClass myDouble = new DoubleClass();
        EmployeeClass myEmp = new EmployeeClass();

        myInt.printInteger();
        myDouble.printDouble();
        myEmp.printEmployee();

        GenericClass<Integer> myObj = new GenericClass<>(10);

        myObj.printValue();

        printStuff("hey", "there");
    }

    private static <T, R> void printStuff (T value, R anotherValue) {
        System.out.println(value + " " + anotherValue);
    }
}

//-----------------
class GenericClass <T> {
    T value;

    public void printValue() {
        System.out.println(value);
    }

    public GenericClass(T value) {
        this.value = value;
    }
}


class IntegerClass {
    private int value;

    public void printInteger() {
        System.out.println(value);
    }

    public IntegerClass() {
        value = 100;
    }
}

class DoubleClass {
    private double value;

    public void printDouble() {
        System.out.println(value);
    }

    public DoubleClass() {
        value = 2.5;
    }
}

class EmployeeClass {
    private String name;

    public void printEmployee() {
        System.out.println(name);
    }

    public EmployeeClass() {
        name = "Some Name";
    }

}