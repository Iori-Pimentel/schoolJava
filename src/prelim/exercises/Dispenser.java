/**
 * Name: Iori Z. Pimentel
 * Date: Sep 7, 2022
 * Activity Name and Number: Prelim Exercise Number 7

 -----------------------------------------------------------------
 Input: Length and Width
 Processes: Find the Perimeter and Area of Rectangle
 Display results
 Output: Perimeter, Area
 ------------------------------------------------------------------
 Algorithm:
 1. Assign the length and width of the rectangle
 2. Compute the perimeter : perimeter = 2 * (length + width)
 3. Compute the area: area = length * width
 4. Show the length and width of the rectangle
 5. Show the perimeter of the rectangle
 6. Show the area of the rectangle

 -------------------------------------------------------------------
 */


package prelim.exercises;

import java.util.Scanner;

public class Dispenser {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("How much to withdraw: ");
        int totalAmount = Integer.parseInt(keyboard.nextLine());
        int toWithdraw = totalAmount;

        int thousandWithdrawn = toWithdraw / 1000;
        toWithdraw %= 1000;

        int fiveHundredWithdrawn = toWithdraw / 500;
        toWithdraw %= 500;

        int oneHundredWithdrawn = toWithdraw / 100;

        int thousandValue = thousandWithdrawn * 1000;
        int fiveHundredValue = fiveHundredWithdrawn * 500;
        int oneHundredValue = oneHundredWithdrawn * 100;

        System.out.println();
        System.out.println("$1000 given: " + thousandWithdrawn);
        System.out.println("$500 given: " + fiveHundredWithdrawn);
        System.out.println("$100 given: " + oneHundredWithdrawn);

        String amountWithdrawn = "$" + thousandValue + " + $" + fiveHundredValue + " + $" + oneHundredValue;
//        String reg = "\(^ [+] )|\";
        amountWithdrawn = amountWithdrawn.replace(" + $0", "").replace("$0", "");

        System.out.println();
        System.out.println("Money given: " + amountWithdrawn);
        System.out.println("Withdraw amount asked: $" + totalAmount);
        System.out.println("Withdraw amount given: $" + (thousandValue + fiveHundredValue + oneHundredValue));

        System.out.println("\n\n");
    }
}