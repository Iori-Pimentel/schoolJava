/**
 * Name: Iori Z. Pimentel
 * Date: Sep 21, 2022
 * Class Code and Course Number: 9315 - CS 112
 -----------------------------------------------------------------
 Input: Base and Exponent
 Processes: Compute the power of a number.
 ------------------------------------------------------------------
 Output: Base^exponent
 Display results
 */

package prelim.activities;

import java.util.Scanner;

public class PowersDoWhile {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("What is the base? ");
    int base = Integer.parseInt(keyboard.nextLine());

    System.out.print("What is the exponent? ");
    int exponent = Integer.parseInt(keyboard.nextLine());

    if (exponent == 0) {
      System.out.printf("\nThe value of %d^%d is 1.\n", base, exponent);
      System.exit(0);
    }

    int result = 1;
    int loopCount = exponent;

    do {
      result *= base;
      loopCount--;
    } while  (loopCount > 0);

    System.out.printf("\nThe value of %d^%d is %d.\n", base, exponent, result);

  }
}
