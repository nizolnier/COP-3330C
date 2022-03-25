import java.util.Scanner;
import java.util.function.Function;

public class Day2 {
    public static void main(String[] args) {
        int i = 4, j = 0, r;
        int[] array = {1,2,10};
        String name = null;

        try {
            System.out.println(array[3]);
            System.out.println(i/j);
            System.out.println(name.length());

        }
        catch(NullPointerException e) {
            System.out.println("this is a null pointer issue");
        }
        catch(ArithmeticException e) {
            System.out.println("this is a division by zero issue");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("this is an array bound issue");
        } finally {
            System.out.println("this is done all the time");
        }

        System.out.println("done");
    }

}
