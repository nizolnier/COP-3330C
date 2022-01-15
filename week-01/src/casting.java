public class casting {
    public static void main(String[] args) {
        int i = 7, j = 2;
        int k = i/j; // 3
        double r = i/j; // 3.0 not casting

        double c = (double) i/j; // 3.5 casting

        System.out.println(k+ "    " + r);
        System.out.println(c);

        int b = 700;
        long l = 1;
        char ch = '$';

        l = b; // 700

        b = (int) l; // 700 gotta cast

        b = ch; // 36


        System.out.println(i + "  " + j);
    }
}
