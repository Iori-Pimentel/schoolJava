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

        System.out.print("\nHow much is your daily budget for transportation? ");
        int transportDay = Integer.parseInt(keyboard.nextLine());

        System.out.print("How much is your daily budget for food? ");
        int foodDay = Integer.parseInt(keyboard.nextLine());

        System.out.print("How much is your daily budget for personal hygiene? ");
        int hygieneDay = Integer.parseInt(keyboard.nextLine());

        System.out.print("How much is your daily budget for cell phone load? ");
        int loadDay = Integer.parseInt(keyboard.nextLine());

        int temp = 0;

        System.out.printf("\nEstimated Tuition Fee per Semester: %,d", temp);
        System.out.printf("\nEstimated Board and Lodging cost per Semester: %,d", temp);
        System.out.printf("\nEstimated living Allowance per Semester: %,d", temp);

        System.out.printf("\n\nEstimated Amount Needed by a Student for one Semester: %,d", temp);
        System.out.printf("\nEstimated Amount Needed by a Student for one Short Term: %,.2f", temp);
        System.out.printf("\nEstimated Amount Needed by a Student to graduate: %,.2f", temp);

    } // end of main
} // end of class

