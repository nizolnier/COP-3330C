public class App {
    public static void main(String[] args) {
        /* Teenager g = new Teenager();
        g.drive();

        Car c = new Car();
        c.drive(); */

        /* Drivable d;

        d = new Truck();
        d.drive();

        d = new Teenager();
        d.drive(); */

        Drivable[] array = new Drivable[10];

        array[0] = new Car();
        array[1] = new Truck();

        for(Drivable d: array) {
            if(d instanceof Car) {
                d.drive();
            }
        }
    }
}

abstract interface Drivable {
    // String color = "blue"; - gonna be final and static (all vehicles will be blue)
    public void drive();
}

class SomeClass {

}

class Car implements Drivable {
    public void drive() {
        System.out.println("I am driving a car");
    }
}

class Truck extends SomeClass implements Drivable, MyInterface {
    public void drive() {
        System.out.println("I am driving a truck");
    }
    
    public int returnNumber() {
        return 100;
    }
}

class Teenager implements Drivable {
    public void drive() {
        System.out.println("I am driving my parents crazy");
    }
}
