/* 
Nicole Zolnier - 01/19/22
Homework 1 - Weekly Payroll Program
*/

import java.util.Scanner;

public class weeklyPayroll {
    public static void main(String[] args) {
        // declaring all the variables I'll use
        String fullName, employeeId;
        // those are doubles to allow decimal precision
        double hoursWorked, hourlyRate, grossPay, netPay, tax;
        // the 6% is a constant as it will always be 6% (until someone in the government decides to change it)
        final double taxPercent = 0.06;
        // setting up the scanner
        Scanner sc = new Scanner(System.in);

        // here I ask the user to enter the required data then save the input in the variables with the help of the scanner
        System.out.println("Enter the Employee's full name:");
        fullName = sc.nextLine();
        System.out.println("Enter the Employee's number:");
        employeeId = sc.nextLine();
        System.out.println("Enter the pay rate per hour:");
        hourlyRate = sc.nextDouble();
        System.out.println("Enter the regular hours worked:");
        hoursWorked = sc.nextDouble();

        // once I have everything I do some calculations
        // the gross pay will be the hourly rate multiplied by the hours worked
        grossPay = hourlyRate * hoursWorked;
        // then I calculate the tax by using the constant and multiplying it by the gross pay
        tax = grossPay * taxPercent;
        // the net pay is the gross pay minus the tax
        netPay = grossPay - tax;

        // then I print everything out (i tried to get it to look as close as possible to the example)
        System.out.println("\nThank you!\n\nHere is your paycheck!\n\n\n");
        System.out.println("------------------------------------------");
        System.out.println("\nEmployee's name:\t" + fullName);
        System.out.println("Employee's number:\t" + employeeId);
        // using String.format to format the doubles into 2 decimal places
        System.out.println("Hourly rate of pay:\t" + String.format("%.2f", hourlyRate));
        System.out.println("Hours worked:\t\t" + String.format("%.2f", hoursWorked));
        System.out.println("\nTotal Gross Pay:\t$" + String.format("%.2f", grossPay));
        System.out.println("\nDeductions\nTax (6%):\t\t$" + String.format("%.2f", tax));
        System.out.println("\nNet Pay:\t\t" + String.format("%.2f", netPay) + " Dollars");
        System.out.println("\n------------------------------------------");
        System.out.println("\nBye!");
        // and that's a wrap!
    }
}
