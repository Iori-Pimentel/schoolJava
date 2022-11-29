/**
* Name: Iori Z. Pimentel
* Date: Nov 28, 2022
* Activity Name and Number: Finals Exercise 6
------------------------------------------------------------
Required:
Write an improved version of the program below such that there are validation processes for the input values
and that appropriate methods are used. The improved version should be named <FinalExercise6.java>. The
improved program should have other methods aside from the main method. The following should be imposed:
✓ The product name should be the same as one of the product names contained in a given array of strings.
(Hint: Store the names of the valid products in an array and apply the linear search algorithm to check if
an input product is in the array)
✓ The quantity cannot be a negative number.
✓ The unit price must be greater than zero
✓ The discount rate cannot be negative and it cannot be more than 100 percent.
✓ The amount tendered cannot be lower than the amount to be paid.
If an input value is invalid, the user should be given an appropriate error message and a directive to enter
another value. The user may repeatedly supply an invalid value. The processing should continue only if the user
enters a valid value.
*/
package finals.exercises;

import java.util.Scanner;
import java.lang.*;

public class FinalsExercise6 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    String pName;
    double uPrice, totalCost, discount, discountedCost, amountTendered, change;
    int qty, dRate;
    String[] validProducts = { "pen", "pencil", "paper", "notebook", "eraser" };
    boolean valid = false;

    while (true) {
      System.out.print("Product[pen|pencil|paper|notebook|eraser]: ");
      pName = keyboard.nextLine();

      for (String product : validProducts) {
        if (pName.equalsIgnoreCase(product))
          valid = true;
      }

      if (!valid)
        System.out.println(ANSI_RED + "Invalid Value\nName does not match available products..." + ANSI_RESET);
      else
        break;
    }

    while (true) {
      System.out.print("Quantity: ");
      qty = Integer.parseInt(keyboard.nextLine());

      if (qty < 0)
        System.out.println(ANSI_RED + "Invalid Value\nQuantity cannot be negative..." + ANSI_RESET);
      else
        break;
    }

    while (true) {
      System.out.print("Unit Price: ");
      uPrice = Double.parseDouble(keyboard.nextLine());

      if (uPrice < 0)
        System.out.println(ANSI_RED + "Invalid Value\nUnit Price cannot be negative..." + ANSI_RESET);
      else
        break;
    }

    while (true) {
      System.out.print("Discount Rate: ");
      dRate = Integer.parseInt(keyboard.nextLine());

      if (dRate < 0 || dRate > 100)
        System.out.println(ANSI_RED + "Invalid Value\nDiscount Rate should be between 0 and 100..." + ANSI_RESET);
      else
        break;
    }

    totalCost = uPrice * qty;
    discount = totalCost * (dRate / 100.0);
    discountedCost = totalCost - discount;

    while (true) {
      System.out.print("Cash Tendered: ");
      amountTendered = Double.parseDouble(keyboard.nextLine());

      if (amountTendered < discountedCost)
        System.out.println(ANSI_RED + "Invalid Value\nCash Tendered is not enough..." + ANSI_RESET);
      else
        break;
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
