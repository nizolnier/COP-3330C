public class practice {
    public static void main(String[] args) {
        A a = new A(), b = new A();
        A c = a;
        a.x = 5;
        A.x = 45;

        A.someMethod(); // Something 1...

        c.someMethod(); // Something 1...

        System.out.println(b.x); // 45

        // --------
        B d = new B();
        d.setY(100);
        System.out.println(d.getY());
    }
}

class A {
    public static int x;   

    public static void someMethod() {
        System.out.println("Something 1...");
        // someMethod2(); not possible
    }

    public void someMethod2() {
        System.out.println("Something 2...");
        someMethod();
    }
}

class B {
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}