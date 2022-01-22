import java.util.Scanner;

public class conditions {
    public static void ifStatements(String[] args) {
        int score = 0;
        char letterGrade = 'F';
        System.out.println("Enter the score: ");
        score = (new Scanner(System.in)).nextInt();

        if( score > 100 || score < 0 ) letterGrade = 'X';
        else {
            if( score >= 90 && score <= 100 ) letterGrade = 'A';
            else if( score >= 80 && score <= 89 ) letterGrade = 'B';
            else if( score >= 70 && score <= 79 ) letterGrade = 'C';
            else if( score >= 60 && score <= 69 ) letterGrade = 'D';
            else if( score >= 0 && score <= 59 ) letterGrade = 'F';  
        }

        if( letterGrade == 'X' ) System.out.println("Invalid score :(");
        else System.out.println("The letter grade is " + letterGrade + " :)");

    }

    public static void switchCase(String[] args) {
        int score = 0;
        char letterGrade = 'F';
        System.out.println("Enter the score: ");
        score = (new Scanner(System.in)).nextInt();
        if( score > 100 || score < 0 ) letterGrade = 'X';

        switch (score / 10) {
            case 10:
                letterGrade = 'A';
                break;
            case 9:
                letterGrade = 'A';
                break;
            case 8:
                letterGrade = 'B';
                break;
            case 7:
                letterGrade = 'C';
                break;
            case 6:
                letterGrade = 'D';
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                letterGrade = 'F';
                break;
            default:
                letterGrade = 'X';
                break;
        }

        if( letterGrade == 'X' ) System.out.println("Invalid score :(");
        else System.out.println("The letter grade is " + letterGrade + " :)");
    }

    public static void ternary(String[] args) {
        int score = 0;
        char letterGrade = 'F';
        System.out.println("Enter the score: ");
        score = (new Scanner(System.in)).nextInt();

        letterGrade = (score >= 90 && score <= 10) ? 'A' : (score >= 80 && score <= 89) ? 'B' : (score >= 70 && score <= 79) ? 'C' : (score >= 60 && score <= 69) ? 'D' : (score >= 0 && score <= 59) ? 'F' : 'X';


        String print = (letterGrade == 'X') ? "Invalid score :(" : ("The letter grade is " + letterGrade + " :)");
        System.out.println(print);
    }

}
