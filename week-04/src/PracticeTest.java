public class PracticeTest {
    public static void main(String[] args) {
        // question1(); // d
        // question2(); // a
        // question3(); // a
        // question4(); // d
        // question5(); // b
        // question6(); // c
        // question7(); // b
        // question8(); // d
        // question9(); // d
        // question10(); // d
        // question11(); // b
        // question12(); // a
        // question13(); // b
        // question14(); // d
        // question15(); // d
        // question16(); // d
        // question17(); // d
        // question18(); // a
        // question19(); // c
        // question20(); // a
        // question21(); // d
        // question22(); // b
        // question23(); // c
        // question24(); // d
        // question25(); // d
    }

    public static void question1() {
        int score = 65;
        switch ( score / 10 ) {
        case 5 : System.out.print("CECS " );
        case 6 : System.out.print ("CECS " );
        default : System.out.print("CECS " );
        }
        
        if (score == 6)
            System.out.print("CECS ");
        
    }

    public static void question2() {
        int x = 1 , y = 2 ;
        System.out.println( ++x + ++y );
    }

    public static void question3() {
        int score = 65 ;
        switch ( score / 10 ) {
            case 5 : System.out.print("JAVA " );
            break ;
            case 6 : System.out.print("JAVA " );
            default : System.out.print("JAVA " );
        }

        if ( score == 6) System.out.print ("JAVA " );
    }

    public static void question4() {
        Test4 t = new Test4(1,2);
        System.out.println(t.x);
    
    }
    
    public static void question5() {
        Test5 t = new Test5(2,1);
        System.out.println(t.x + " " + t.y);
    }

    public static void question6() {
        Test6 t1 = new Test6(1);
        Test6 t2 = t1;

        System.out.println(t1.x + " " + t2.y);
    }

    public static void question7() {
        for(int counter =1; counter <= 3; counter++) {
            if(counter <= 1) {
                System.out.print("UCF");
                // break;
            }
        }
        System.out.print("UCF");
    }

    public static void question8() {
        Test8 t1 = new Test8(5, 7);
        t1.print();
    }

    public static void question9() {
        for(int counter = 1; counter < 3; counter++) {
            if(counter <= 1) {
                System.out.println("UCF");
                counter--;
            }
        }
        System.out.println("UCF");
    }
    
    public static void question10() {
        int n = 3, x = 10;
        while(n > -1 || x < 5) {
            n = n + 1;
            if(n > 7) {
                System.out.println(n);
            }
        }
        System.out.println("DONE");
    }

    public static void question11() {
        for(int counter = 3; counter > 0; counter--) {
            if(counter <= 1) {
                System.out.print("UCF");
                counter--;
            }
        }
        System.out.print("UCF");
    }

    public static void question12() {
        Test12 t1 = new Test12(5, 7);
        Test12 t2 = new Test12(1, 2);
        Test12 t3;
        t3 = t2;
        t2 = t1;
        t1 = t3;
        t2.print();
    }

    public static void question13() {
        Test13 t = new Test13();
        t.i = 200;
        System.out.println(Test13.i+" "+ t.i);
    }

    public static void question14() {
        Test14 t1 = new Test14(5,7);
        System.out.println(t1.y.x - t1.x);
    }

    public static void question15() {
        int[] array = {1,2,3};
        for(int a : array) {
            a = -1;
            ++a;
        }

        for(int a : array) {
            System.out.print("  " + a);
        }
    }

    public static void question16() {
        Test16 t1 = new Test16(5,7);
        System.out.println(t1.y.x - t1.x);
    }

    public static void question17() {
        Test17 t = new Test17();
        t1.i = 200;
        System.out.println(Test17.i+" "+ t.i);
    }

    public static void question18() {
        int n = 3, x = 10;
        do {
            n = n + 1;
            if( n > 7)
                System.out.println(n);
        } while(n > -1 && x < 5);

        System.out.println("DONE");
    }

    public static void question19() {
        int x = 3, y = 10;
        x = y; 
        y = x;
        System.out.println(x + " " + y);
    }

    public static void question20() {
        Test20 t1 = new Test20();
        Test20 t2 = new Test20(5);
        Test20 t3 = new Test20(5, 7);

        System.out.println(t1.x + t2.y + t3.x);
    }

    public static void question21() {
        int five = 5;
        String name = "hi+5";
        System.out.println(name + five);
    }

    public static void question22() {
        int x = 2, y = 7;
        System.out.println(x+y/x+x);
    }

    public static void question23() {
        int x = 2;
        System.out.println(++x + x);
        // System.out.println("-"+x);
    }
    public static void question24() {
        System.out.println(2%5);
    }
    public static void question25() {
        Test25 t;
        System.out.println(t.x + " " + t.y);
    }
}

class Test4 {
    public int x , y;
    public Test4() {
        x = 1;
        y = 2;
    }
}

class Test5 {
    public int x , y;
    public Test5(int x, int y) {
        this.x = 1;
        this.y = 2;
    }
}

class Test6 {
    public int x , y;
    public Test6(int x, int y) {
        this.x = 1;
        this.y = 2;
    }

    public Test6(int x){
        this.x = x;
        this.y = x;
    }
}

class Test8 {
    public int x , y;

    public void setAll(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Test8(int x, int y) {
        setAll(x, y);
    }

    private void print() {
        System.out.println(x + y);
    }
}

class Test12 {
    private int x , y;

    public void setAll(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Test12(int x, int y) {
        setAll(x, y);
    }

    public void print() {
        System.out.println(x + y);
    }
}

class Test13 {
    public static int i;

    public Test13() {
        i = 100;
    }

}

class Test14 {
    public int x;
    public AnotherTest14 y;

    public void setAll(int x, int y) {
        this.x = x;
        this.y = new AnotherTest14(y);
    }
    public Test14(int x, int y) {
        setAll(x, y);
    }
}

class AnotherTest14 {
    public int x;
    public AnotherTest14(int x) {
        this.x = x;
    }
}

class Test16 {
    public int x;
    public AnotherTest16 y;

    public void setAll(int x, int y) {
        this.x = x;
        this.y = new AnotherTest16(y);
    }
    public Test16(int x, int y) {
        setAll(x, y);
    }
}

class AnotherTest16 {
    private int x;
    public AnotherTest16(int x) {
        this.x = x;
    }
}

class Test17 {
    private static int i;

    public Test17() {
        i = 100;
    }

}

class Test20 {
    public int x , y;

    public void setAll(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Test20() {
        setAll(1,2);
    }

    public Test20(int x, int y) {
        setAll(x, y);
    }

    public Test20(int x) {
        setAll(x, x);
    }
    
}

class Test25 {
    public int x , y;


    public Test25() {
        x = 1;
        y = 2;
    }
    
}