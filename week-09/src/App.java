public class App {
    public static void main(String[] args) {
        SomeInterface[] object = new SomeClass[100];

        object[1] = new SomeClass();
        ((SomeClass)object[1]).anotherAbstractMethod();
    }
}

interface SomeInterface {
    public void someMethod();
}

abstract class SomeAbstractClass implements SomeInterface {
    abstract public void anotherAbstractMethod();

    private int someData;
    public void aMethod() {

    }
}

class SomeClass extends SomeAbstractClass {
    public void anotherAbstractMethod() {
        System.out.println("this is the code of anotherAbstractMethod()");
    }

    public void someMethod() {
        System.out.println("this is the code of someMethod()");
    }
}