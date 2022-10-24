/**
* Name: Iori Z. Pimentel
* Date: Oct 12, 2022
* Activity Name and Number: Midterm Exercise Program 4
------------------------------------------------------------
Test the program given below with different possible input values. Note that the program allows
the user to enter invalid values (0 or negative number for the quantity, 0 or negative number for
the unit price, etc.). In addition, the program allows the user to enter a cash tendered amount that
is lesser that the amount to be paid.
Required:
Write an improved version of the program that will provide validation processes for the input
values. The following should be imposed: (Filename: MidtermExercise4.java)
✓ The valid product names should be limited to only 5 product names ( e.g. “pen”, “pencil”, “short bond paper”, “long bond paper”, “pad paper”)
✓ The quantity cannot be a negative number.
✓ The unit price must be greater than zero
✓ The discount rate cannot be negative, and it cannot be more than 100 percent.
✓ The amount tendered cannot be lower than the amount to be paid.
If an input value is invalid, the user should be given an appropriate error message and a directive
to enter another value. The user may repeatedly supply an invalid value. The processing should
continue only after the user enters a valid value.
*/

package midterm.exercises;
import java.util.Scanner;
import java.lang.*;
public class MidtermExercise4 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String pName;
        double uPrice, totalCost, discount, discountedCost, amountTendered, change;
        int qty, dRate;

        while (true) {
            System.out.print("Product[pen|pencil|paper|notebook|eraser]: ");
            pName = keyboard.nextLine();

            if (!pName.matches("(?i)pen|pencil|paper|notebook|eraser")) // regex case-insensitive search
                System.out.println(ANSI_RED + "Invalid Value\nName does not match available products..." + ANSI_RESET);
            else break;
        }

        while (true) {
            System.out.print("Quantity: ");
            qty = Integer.parseInt(keyboard.nextLine());

            if (qty < 0)
                System.out.println(ANSI_RED + "Invalid Value\nQuantity cannot be negative..." + ANSI_RESET);
            else break;
        }

        while (true) {
            System.out.print("Unit Price: ");
            uPrice = Double.parseDouble(keyboard.nextLine());

            if (uPrice < 0)
                System.out.println(ANSI_RED + "Invalid Value\nUnit Price cannot be negative..." + ANSI_RESET);
            else break;
        }

        while (true) {
            System.out.print("Discount Rate: ");
            dRate = Integer.parseInt(keyboard.nextLine());

            if (dRate < 0 || dRate > 100)
                System.out.println(ANSI_RED + "Invalid Value\nDiscount Rate should be between 0 and 100..." + ANSI_RESET);
            else break;
        }

        totalCost = uPrice * qty;
        discount = totalCost * (dRate / 100.0);
        discountedCost = totalCost - discount;

        while (true) {
            System.out.print("Cash Tendered: ");
            amountTendered = Double.parseDouble(keyboard.nextLine());

            if (amountTendered < discountedCost)
                System.out.println(ANSI_RED + "Invalid Value\nCash Tendered is not enough..." + ANSI_RESET);
            else break;
        }

        change = amountTendered - discountedCost;

        System.out.printf("%-25s%12s%n", "----------------------", "--------------");
        System.out.printf("%-25s%12.2f%n", "Total Purchase Amount: ", totalCost);
        System.out.printf("%-25s%12.2f%n", "Total Discount: ", discount);
        System.out.printf("%-25s%12.2f%n", "Amount to be Paid: ", discountedCost);
        System.out.printf("%-25s%12.2f%n", "Change: ", change);
        System.exit(0);
    } // end of main method

    public static final String ANSI_RESET = "\u001B[0m"; // reset text color
    public static final String ANSI_RED = "\u001B[31m"; // red color
} // end of class
