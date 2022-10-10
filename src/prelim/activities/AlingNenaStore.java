/**
 * Name: Iori Z. Pimentel
 * Date: Sep 21, 2022
 * Class Code and Course Number: 9315 - CS 112
 -----------------------------------------------------------------
 Input: Product, Quantity, Unit Price, Discount, Cash Tendered from Scanner.
 Processes: Find the values for the Output.
 ------------------------------------------------------------------
 Algorithm:
 1. totalPurchased = quantity * unitPrice;
 2. totalDiscount = totalPurchased * (discount / 100.0);
 3. amountToPay = totalPurchased - totalDiscount;
 4. change = cashTendered - amountToPay;
 -------------------------------------------------------------------
 Output: Total Purchase Amount, Total Discount, Amount To Be Paid, Change
 Display results
 */

package prelim.activities;

import java.util.Scanner;

public class AlingNenaStore {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Product: ");
        String product = keyboard.nextLine();

        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(keyboard.nextLine());

        System.out.print("Unit Price: ");
        double unitPrice = Integer.parseInt(keyboard.nextLine());

        System.out.print("Discount: ");
        int discount = Integer.parseInt(keyboard.nextLine());


        System.out.print("Cash Tendered: ");
        double cashTendered = Integer.parseInt(keyboard.nextLine());

        double totalPurchased = quantity * unitPrice;
        double totalDiscount = totalPurchased * (discount / 100.0);
        double amountToPay = totalPurchased - totalDiscount;
        double change = cashTendered - amountToPay;




        System.out.println("\n\n" +
                           "Total Purchased: " + totalPurchased + "\n" +
                           "Total Discount: " + totalDiscount + "\n" +
                           "Amount to Pay: " + amountToPay + "\n" +
                           "Change: " + change
                           );
    }
}

