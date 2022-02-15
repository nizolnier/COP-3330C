import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        // String data = "1 2 John Smith";
        // Scanner s = new Scanner(data);

        File inFile = new File("data.txt");

        PrintStream out = new PrintStream(new File("results.txt"));

        Scanner s = new Scanner(inFile);

        int n1, n2;
        String name;
        n1 = s.nextInt();
        n2 = s.nextInt();
        name = s.next();

        System.out.println(n1 + " " + n2 + " " + name);
        out.println("Testing.....");

    }
}
