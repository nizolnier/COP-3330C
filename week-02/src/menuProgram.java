import java.util.Scanner;

public class menuProgram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x, y;

        System.out.println("Hey bestie, please enter 2 numbers");
        x = s.nextInt();
        y = s.nextInt();

        String case2 = y == 0 ? "Bestie I cannot divide" : (x + " / " + y + " = " + divide(x,y));
        
        String option = menu();

        switch (option) {
            case "1":
                System.out.println(x+ " + " + y + " = " + add(x, y));
                break;
            case "2":
                System.out.println(case2);
                break;
            case "3":
                printDivisors(x);
                break;
            case "0": 
                System.out.println("Bye, bestie!");
            default:
                System.out.println("Invalid option :(");
                break;
        }
    
    }

    static String menu () {
        Scanner s = new Scanner(System.in);
        String option = "";
        System.out.println("Ok, what do you wanna do with them?");
        System.out.println("1 - add the numbers");
        System.out.println("2- divide the first by the second");
        System.out.println("3- print the divisors of the first number");
        System.out.println("0 - exit program");
        
        option = s.nextLine();

        return option;
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int divide(int a, int b) {
        return a/b;
    }

    static void printDivisors(int a) {
        System.out.print("The divisors of " + a + " are: ");
        for(int i = 1; i <= a; i++) {
            if(a%i == 0) System.out.print(i + " ");
        }
    }
}
