public class Day3 {
    public static void main(String[] args) {
        int i = 2, j = 3;

        Integer sum = 0, product = 0;
        someMethod(i);

        calculation(i, j, sum, product);
        System.out.println(sum + "  " + product);
    }

    static void calculation(int a, int b, Integer sum, Integer product) {
        sum = a + b;
        product = a*b;
    }

    private static void someMethod(int i) {
        i = 12;
    }
}
