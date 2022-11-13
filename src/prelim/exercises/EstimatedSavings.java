/**
* Name: Iori Z. Pimentel
* Date: Sep 14, 2022
* Activity Name and Number: Prelim Exercise Number 11
------------------------------------------------------------
 How much is your estimated tuition fee for one semester? 27200.00
 Approximately, how much does your board and lodging for one-month cost?
 5000.00
 How much is your estimated living allowance for one month? 3000.00
 -----------------------------------------------------------------------------
 Estimated Tuition Fee per Semester
 27200.00
 Estimated Board and Lodging cost per Semester
 25000.00
 Estimated living Allowance per Semester
 15000.00
 -----------------------------------------------------------------------------
 Estimated Amount Needed by a Student for one Semester
 67200.00
 Estimated Amount Needed by a Student for one Short term
 23520.00
 Estimated Amount Needed by a Student to graduate
 608160.00
 Algorithm:
 1. Let tuitionFee represent the estimated tuition fee of a full time student
 for one semester
 2. Let boardAndLodging represent the estimated cost for one month of basic
 board and lodging

 3. Let livingAllowance represent the estimated living allowance needed by a
 full time student for one month
 4. Let semesterExpense represent the estimated amount needed by a full time
 student for one semester
 5. Let summerExpense represent the estimated amount needed by a full time
 student for one short term
 6. Let totalEstimatedExpense represent the amount needed by a full time
 student in order to finish his/her course for 8 semesters and 3 short terms.
 7. Read the value for tuitionFee
 8. Read the value for boardAndLodging
 9. Read the value for livingAllowance
 10. Compute the value for semesterExpense
 11. Compute the value for summerExpense
 12. Compute the value for totalEstimatedExpense
 13. Display the values
 */

package prelim.exercises;

import java.util.Scanner;

public class EstimatedSavings {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("\nHow much is your 6-day allowance? ");
    int allowanceWeek = Integer.parseInt(keyboard.nextLine());

    System.out.print("\nHow much is your daily budget for transportation? ");
    int transportDay = Integer.parseInt(keyboard.nextLine());

    System.out.print("How much is your daily budget for food? ");
    int foodDay = Integer.parseInt(keyboard.nextLine());

    System.out.print("How much is your daily budget for personal hygiene? ");
    int hygieneDay = Integer.parseInt(keyboard.nextLine());

    System.out.print("How much is your daily budget for cell phone load? ");
    int loadDay = Integer.parseInt(keyboard.nextLine());

    int expensesDay =  transportDay + foodDay + hygieneDay + loadDay;
    int expensesWeek = expensesDay * 6;
    int savingsWeek = allowanceWeek - expensesWeek;

    int savingsSem = savingsWeek * 16;
    int savingsEightSem = savingsSem * 8;

    System.out.printf("\nExpected Total Expenses for 6 days: %,d", expensesWeek);
    System.out.printf("\nExpected Savings for 6 days: %,d", savingsWeek);
    System.out.printf("\nExpected Savings for one semester: %,d", savingsSem);
    System.out.printf("\nExpected Savings for eight semesters: %,d", savingsEightSem);
    System.out.println();
  } // end of main
} // end of class

