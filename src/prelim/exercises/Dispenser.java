/**
 * Name: Iori Z. Pimentel
 * Date: Sep 12, 2022
 * Activity Name and Number: Prelim Exercise Number 7

 -----------------------------------------------------------------
 Input: Amount to Withdraw using Scanner
 Processes: Calculate the amounts of bills for each denomination of 1000, 500, 100 
 Display results
 Output: Amount and total for each bill. Total for all values.
 ------------------------------------------------------------------
 Algorithm:
1. nThousand = toWithdraw / 1000;
    toWithdraw %= 1000;
2. nFiveHundred = toWithdraw / 500;
    toWithdraw %= 500;
3. nOneHundred = toWithdraw / 100;

4. thousandValue = nThousand * 1000;
5. fiveHundredValue = nFiveHundred * 500;
6. oneHundredValue = nOneHundred * 100;
 -------------------------------------------------------------------
 */


package prelim.exercises;

import java.util.Scanner;

public class Dispenser {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int inputAmount = 0;
    boolean isValid = false;

    while (!isValid) {
      System.out.print("How much to withdraw: ");
      inputAmount = Integer.parseInt(keyboard.nextLine());

      if (inputAmount < 0) {
        System.out.println("The amount should be positive.");
        continue;
      }
      isValid = true;
    }    

    int toWithdraw = inputAmount;

    int nThousand = toWithdraw / 1000;
    toWithdraw %= 1000;

    int nFiveHundred = toWithdraw / 500;
    toWithdraw %= 500;

    int nOneHundred = toWithdraw / 100;

    int thousandValue = nThousand * 1000;
    int fiveHundredValue = nFiveHundred * 500;
    int oneHundredValue = nOneHundred * 100;

    System.out.println();
    System.out.println("$1000 given: " + nThousand);
    System.out.println("$500 given: " + nFiveHundred);
    System.out.println("$100 given: " + nOneHundred);

    System.out.println();
    System.out.println("$1000 total value: $" + thousandValue);
    System.out.println("$500 total value: $" + fiveHundredValue);
    System.out.println("$100 total value: $" + oneHundredValue);

    System.out.println();
    System.out.println("Withdraw amount asked: $" + inputAmount);
    System.out.println("Withdraw amount given: $" + (thousandValue + fiveHundredValue + oneHundredValue));

    System.out.println();
  }
}
