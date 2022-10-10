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

public class PowersWhile {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is the base? ");
        int base = Integer.parseInt(keyboard.nextLine());

        System.out.print("What is the exponent? ");
        int exponent = Integer.parseInt(keyboard.nextLine());

        int result = 1;
        int loopCount = exponent;

        while (loopCount > 0) {
            result *= base;
            loopCount--;
        }

        System.out.printf("\nThe value of %d^%d is %d.\n", base, exponent, result);

    }
}
