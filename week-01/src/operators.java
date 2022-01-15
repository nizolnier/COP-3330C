import java.util.Scanner;

public class operators {
    public static void main(String[] args) {
        int x, y;
        x = y = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your two integers: ");
        x = sc.nextInt();
        y = sc.nextInt();

        System.out.println("integer division " + x/y);
        System.out.println("double division " + (double) x/y);
        System.out.println("modulus " + x%y);
    }
}
