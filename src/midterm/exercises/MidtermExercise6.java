/**
 * Name: Iori Z. Pimentel
 * Date: Oct 12, 2022
 * Activity Name and Number: Midterm Exercise Program 6
 ------------------------------------------------------------
 Activities
    1. Encode, save, compile, execute and understand the program given below.
    2. Modify the program so that the following specifications are satisfied (Filename:
    MidtermActivity6.java)
    a. Only valid values should allow the computer to continue the process
    b. The tax due should be determined based on the actual tax computation procedure
    for the Philippines. (Please do the necessary data gathering. Search for BIR
    information. Borrow income tax forms.)
    c. Appropriate comments should be included in the source code
    d. Helpful error messages should be shown whenever and wherever appropriate.

    The Problem
    Write a program for the computation of the tax due corresponding to a given taxable income.
    The tax due is determined based on the following table:
    Taxable Income Tax Due
    <= 25,000.00 4,000.00
    > 25,000.00 but <= 125,000.00 4,000.00 + 8% (taxable income - 25,000.00)
    > 125,000.00 but <= 525,000.00 12,000.00 + 10% (taxable income - 125,000.00)
    > 525,000.00 52,000.00 + 12% (taxable income - 525,000.00)
*/

package midterm.exercises;
import java.lang.*;
import java.util.Scanner;

public class MidtermExercise6 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double taxableIncome;
        double taxDue = 0.0;
        byte bracket = 0;
        System.out.println("Income Tax Computation");
        System.out.print("Enter the taxable income: ");
        taxableIncome = keyboard.nextDouble();
        if (taxableIncome <= 25000.00)
            bracket = 1;
        else if (taxableIncome <= 125000.00)
            bracket = 2;
        else if (taxableIncome <= 525000.00)
            bracket = 3;
        else
            bracket = 4;

        switch (bracket) {
            case 1:
                taxDue = 4000.00;
                break;
            case 2:
                taxDue = 4000.00 + (taxableIncome - 25000.00) * 0.08;
                break;
            case 3:
                taxDue = 12000.00 + (taxableIncome - 125000.00) * 0.10;
                break;
            case 4:
                taxDue = 62000.00 + (taxableIncome - 525000.00) * 0.12;
                break;
            default:
                taxDue = 0.00;
        } // end of switch-case
        System.out.printf("%s %.2f%n", "Tax Due = ", taxDue);
        System.exit(0);
    } // end of main method
} // end of Taxation class