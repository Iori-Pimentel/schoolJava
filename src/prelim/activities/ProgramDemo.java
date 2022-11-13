/**
 * Name: Iori Z. Pimentel
 * Date: Sep 21, 2022
 * Class Code and Course Number: 9315 - CS 112
 ------------------------------------------------------------
 Input: Three Numbers from Scanner
 Processes: Do a bunch of operations on the given numbers
 ------------------------------------------------------------------
 Algorithm:
 1. n1 * n2 * n3
 2. (n1 + n2) / n3
 3. (n1 + n2) / (double) n3
 4. (n1 + n2 + n3) / 3
 5. n1^2, n2^2, n3^2
 -------------------------------------------------------------------
 Display results
 */

package prelim.activities;


import java.util.Scanner;

public class ProgramDemo {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("First Number: ");
    int n1 = Integer.parseInt(keyboard.nextLine());
    System.out.print("Second Number: ");
    int n2 = Integer.parseInt(keyboard.nextLine());
    System.out.print("Third Number: ");
    int n3 = Integer.parseInt(keyboard.nextLine());

    System.out.println("\nYou entered the numbers " + n1 + ", " + n2 + " and " + n3 + ".\n");
    System.out.println("The sum of the three numbers is: " + (n1 + n2 + n3));

    int q1 = n1 / n2;
    System.out.println("The expression used computed the integer quotient: " + q1);
    double q2 = (double) n1 / n2;
    System.out.println("The expression used computed the actual quotient: " + q2);

    /* #1. Compute the product of the three numbers, store it in another integer
        variable and display this value. INSERT THE CODES BELOW... */

    int product = n1 * n2 * n3;
    System.out.println("\n\nThe product of the three numbers is: " + product);

    /* #2. Get the sum of the first two numbers and divide it by the third number,
        compute only for the integer quotient and display the value.
        INSERT THE CODES BELOW... */

    int sumOfTwo = n1 + n2;
    int integerQuotientResult = sumOfTwo / n3;
    System.out.println("The result with integer quotient is: " + integerQuotientResult);

    /* #3. Get the sum of the first two numbers and divide it by the third number,
        compute for the exact quotient and display the value.
        INSERT THE CODES BELOW... */

    //sumOfTwo already exist so I dont have to create it again
    double exactQuotientResult = (double) sumOfTwo / n3;
    System.out.println("The result with exact quotient is: " + exactQuotientResult);


    /* #4. Compute the average of the three numbers and display the result with 2
        decimal values shown. INSERT CODE BELOW... */

    int sum = n1 + n2 + n3;
    double avg = (double) sum / 3;
    System.out.printf("The average of the three numbers is: %.2f\n", avg);



    /* #5. Compute the square of each number and display the results.
        INSERT CODE BELOW... */

    int n1Squared = n1 * n1;
    int n2Squared = n2 * n2;
    int n3Squared = n3 * n3;

    System.out.println("The square of the three numbers is: " + n1Squared + ", " + n2Squared + ", " + n3Squared);

  }
}
