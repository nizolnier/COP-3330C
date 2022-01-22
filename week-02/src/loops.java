public class loops {
    public static void whileLoop(String[] args) {
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }
    }
    
    public static void doWhileLoop(String[] args) {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        }
        while (i < 5);
    }

    public static void forLoop(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public static void forEachLoop(String[] args) {
        int [] array = { 12, 56, -1 };

        for(int i : array ) {
            System.out.println(i);
        }
    }
}
