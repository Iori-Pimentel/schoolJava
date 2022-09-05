package prelim.exercises;

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
//        1. Sample Input:
//
//        Product: eggs
//        Quantity: 12
//        Unit Price: 5.00
//        Discount: 10
//        Cash Tendered: 100.00
//
//        Sample Output:
//
//        Total Purchase Amount: 60.00
//        Total Discount: 6.00
//        Amount To Be Paid: 54.00
//        Change: 46.00
    }
}

