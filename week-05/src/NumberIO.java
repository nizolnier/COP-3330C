import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberIO {
    public static void main(String[] args) throws FileNotFoundException { 
        Scanner s = new Scanner(new File("numbers.txt"));

        while(s.hasNext()) {
            System.out.print(s.nextInt() + " ");
        }
        
    }
}
