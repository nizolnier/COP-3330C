/* 
Nicole Zolnier - 01/25/22
Homework 2 - Fun math :)
*/

import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        // welcoming the user to my program :)
        System.out.println("Welcome!");
        // getting the option
        String option = menu();
        // declaring the variable that will hold the user's number
        int x;

        // in the instructions for the hw, if the user enters something different than A/B/Q it prints out "Invalid option" and ends the program
        // to replicate that, i only scan the number if it is option A or B then move to the function that will do the math
        // if not, it will print out a message
        switch(option){
            case "A":
            case "a":
                x = getNumber();
                printDivisors(x);
                break;
            case "B":
            case "b":
                x = getNumber();
                multiplicationTable(x);
                break;
            case "Q":
            case "q":
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }

    }

    static String menu() {
        // declaring the scanner and the option variable that will hold the user's choice
        Scanner s = new Scanner(System.in);
        String option = "";

        // presenting the choices to the user
        System.out.println("Choose from the following options:");
        System.out.println("A or a: To display the divisors of a natural number");
        System.out.println("B or b: To display the multiplication table for a natural number");
        System.out.println("Q or q to Exit");

        // asking them to enter the choice
        System.out.print("\nEnter your choice: ");
     
        // scanning the choice
        option = s.nextLine();

        // returning the choice to be used in the main function
        return option;
    }


    static void printDivisors(int a) {
        // first i check if the number is a prime number
        boolean isPrime = checkIfPrime(a);
        // if it is, i print a special message and end the program
        if(isPrime) {
            System.out.println(a + " is prime (the only divisors of " + a + " are 1 and " + a + ")");
            System.exit(a);
        }

        // if it is not, i need to find the divisors
        System.out.print("The divisors of " + a + " are: ");
        
        // i loop from 1 to a-1 and if for any of the i numbers the rest is 0 when divided by a then i print i bc it's a divisor of a
        for(int i = 1; i < a; i++) {
            if(a%i == 0) System.out.print(i + ", ");
        }

        // and for the last number, as per the instructions, i added this "and" before printing a itself
        System.out.println("and " + a);
        
    }

    static void multiplicationTable(int a) {
        // declaring the scanner and the variable that determines the size of the table
        Scanner s = new Scanner(System.in);
        int b;

        // asking the user to enter the size, scanning that and checking if it's a natural number
        System.out.print("Enter the size of the multiplication table (1,2, etc): ");
        b = s.nextInt();
        checkIfNatural(b);

        // starting at 1 until b, i print the multiplication of i*a
        for(int i = 1; i <= b; i++) {
            System.out.println(i + " x " + a + " = " + (a*i));
        }
    }
    
    // --------------- auxiliary functions --------------
    static int getNumber() {
        // declaring the scanner and the variable to hold the number
        Scanner s = new Scanner(System.in);
        int a;
        // asking for user input and saving that input into the variable
        System.out.print("Enter your number: ");
        a = s.nextInt();
        // checking if the number is natural
        checkIfNatural(a);
        // if it's natural then i return it
        return a;
    }

    static void checkIfNatural(int a) {
        // natural numbers are positive so if it's not positive is not natural and it ends the program
        if(a < 0) {
            System.out.println(a + " is not a natural number");
            System.exit(a);
        }
    }

    static boolean checkIfPrime(int a) {
        // declaring the variable that will hold the answer (if is prime or not)
        boolean isPrime = true;

        // prime numbers are only divisible by 1 and itself so to check that
        // i do a loop starting at 2 instead of 1 and ending at half the number being tested bc it isn't necessary to test all the numbers
        // if for any of the i numbers the rest is 0 when divided by a then it is not a prime number (since it has more divisors)
        for(int i = 2; i <= a/2; i++) {
            if(a%i == 0) isPrime = false;
        }

        // then i return the boolean
        return isPrime;
    }
}
