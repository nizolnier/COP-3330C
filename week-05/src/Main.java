import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("data"));

        String[] tokens;
        String buffer;
        String name = "";
        int limit = 0;
        int max = 0;
        int currentNumber;

        while(s.hasNextLine()) {
            limit++;
            buffer = s.nextLine();
            tokens = buffer.split("\t");
            System.out.println("[" + tokens[0] + "] [" + tokens[1] + "]");
            currentNumber = Integer.parseInt(tokens[1]);
            System.out.println(currentNumber);

            if(max < currentNumber) {
                max = currentNumber;
                name = tokens[0];
            }
            
            // System.out.println(buffer);
            
        }

        System.out.println(name + max);
        System.out.println("There are " + limit + " lines in the file");
    }
}
