/**
 /**
 * Name: Iori Z. Pimentel
 * Date: Nov 9, 2022
 * Activity Name and Number: Finals Exercise 3
 ------------------------------------------------------------
 If the sum of the factors that are less than n of the integer n is equal to n, n is a perfect
 number. For example, 6 is a perfect number because the factors of 6 that are less than 6 are 1,2
 and 3 and the sum of these factors (1+2+3) is equal to 6. Also, because the factors of 28 that are
 less than 28 are 1,2,4,7 and 14 and that 1+2+4+7+14 is 28, 28 is a perfect number.
 When completed, the following program allows the user to enter a positive integer in the range 1
 to 32000. The computer will then state whether the number is perfect number or not.

 When completed, the following program computes the tax amount corresponding to a given taxable
 income. The tax due is determined based on the following table:
 If taxable income is then tax due is
 <= 25,000.00 4,000.00
 > 25,000.00 but <= 125,000.00 4,000.00 + 8% (taxable income - 25,000.00)
 > 125,000.00 but <= 525,000.00 12,000.00 + 10% (taxable income - 125,000.00)
 > 525,000.00 52,000.00 + 12% (taxable income - 525,000.00)
 */


package finals.exercises;
import java.util.*;

public class FinalsExercise3 {
  public static void main(String[] args) {
    double taxableIncome;
    double taxDue;
    // Introduce the program by invoking the showIntroduction method
    showIntroduction();
    // Read the taxable income from the keyboard by invoking the readTaxableIncome method
    taxableIncome = readTaxableIncome();
    // Compute the tax due by invoking the computeTaxDue method
    taxDue = computeTaxDue(determineBracket(taxableIncome), taxableIncome );
    // Show the taxable income by invoking the showResults method
    showResults(taxableIncome, taxDue);
    System.exit(0);
  } // end of main method
  /**
     *shows statements that introduce the application on the output screen
     */
  public static void showIntroduction() { // ITEM 1
    System.out.println("Hypothetical Tax Computation Program");
    System.out.println("------------------------------------");
    System.out.println("This program is for the computation of the tax due from a taxpayer " +
      "with a known taxable income.");
    System.out.println();
  } // end of showIntroduction method
  /**
     * returns a taxable income amount read from the keyboard]
     */
  public static double readTaxableIncome() { // ITEM 2
    Scanner input=new Scanner(System.in);
    double income=0.0;

    do {
      System.out.print("Enter the taxable income: ");
      income = Double.parseDouble(input.nextLine());
    } while (income < 0);
    return income; // ITEM 3
  } // end of readTaxableIncome method
  /**
     returns the bracket corresponding to a given taxable income based on the following rule
     If taxable income is then bracket is
     <= 25,000.00 1
     > 25,000.00 but <= 125,000.00 2
     > 125,000.00 but <= 525,000.00 3
     > 525,000.00 4
     */
  public static int determineBracket(double taxableIncome){ // ITEM 4
    int bracket = 0;
    if (taxableIncome <= 25000.00)
    bracket = 1;
    else
    if (taxableIncome <= 125000.00)
    bracket = 2;
    else
    if (taxableIncome <= 525000.00)
    bracket = 3;
    else
    bracket = 4;
    return bracket;
  } // end of determineBracket method
  /**
     * returns the tax amount due corresponding to a given pair of bracket and taxable income
     based on the following rule
     If bracket of income is then tax due is
     1 4,000.00
     2 4,000.00 + 8% (taxable income - 25,000.00)
     3 12,000.00 + 10% (taxable income - 125,000.00)
     4 52,000.00 + 12% (taxable income - 525,000.00)
     */
  public static double computeTaxDue(int bracket, double taxableIncome) { // ITEM 5
    double taxDue=0.0;
    switch (bracket) {
      case 1: taxDue = 4000.00;
      break;
      case 2: taxDue = 4000.00 + (taxableIncome - 25000.00) * 0.08;
      break;
      case 3: taxDue = 12000.00 + (taxableIncome - 125000.00) * 0.10;
      break;
      case 4: taxDue = 52000.00 + (taxableIncome - 525000.00) * 0.12;
      break;
      default: taxDue = 0.00;
    }
    return taxDue; // ITEM 6
  } // end of computeTaxDue method
  /**
* displays a given taxable income and the corresponding tax amount on the output screen
     */
  public static void showResults(double taxableIncome, double taxDue) { // ITEM 7
    System.out.println();

    System.out.printf("%-20s%15.2f%n","Taxable Income: ",taxableIncome);
    System.out.printf("%-20s%15.2f%n", "Tax Due = ", taxDue);
  } // end of showResults method
} // end of ModularizedTaxationProgram class
