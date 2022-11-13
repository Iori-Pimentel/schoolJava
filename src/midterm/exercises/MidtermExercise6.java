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
    double taxDue;
    System.out.println("Income Tax Computation");
    while (true) {
      System.out.print("Enter the taxable income: ");
      taxableIncome = Double.parseDouble(keyboard.nextLine());

      if (taxableIncome < 0)
      System.out.println("Value cannot be a negative value.");
      else break;
    }

    if (taxableIncome <= 250_000)
    taxDue = 0;
    else if (taxableIncome <= 400_000)
    taxDue = 0.20 * (taxableIncome - 250_000);
    else if (taxableIncome <= 800_000)
    taxDue = 30_000 + 0.25 * (taxableIncome - 400_000);
    else if (taxableIncome <= 2_000_000)
    taxDue = 130_000 + 0.30 * (taxableIncome - 800_000);
    else if (taxableIncome <= 8_000_000)
    taxDue = 490_000 + 0.32 * (taxableIncome - 2_000_000);
    else
    taxDue = 2_410_000 + 0.35 * (taxableIncome - 8_000_000);

    System.out.printf("%s %.2f%n", "Tax Due = ", taxDue);
    System.exit(0);
  } // end of main method
} // end of Taxation class
