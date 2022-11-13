/**
 * Name: Iori Z. Pimentel
 * Date: Sep 21, 2022
 * Class Code and Course Number: 9315 - CS 112
 -----------------------------------------------------------------
 Input: A number between 1-10
 Processes: Convert number into word using if-else
 ------------------------------------------------------------------
 Output: Word from Number
 Display results
 */

package prelim.activities;

import java.util.Scanner;

public class NumberInWordsIfElse {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("Give me a number: ");
    int number = Integer.parseInt(keyboard.nextLine());

    if (number == 1)
    System.out.printf("The number %d can be written as \"One\".", number);
    else if (number == 2)
    System.out.printf("The number %d can be written as \"Two\".", number);
    else if (number == 3)
    System.out.printf("The number %d can be written as \"Three\".", number);
    else if (number == 4)
    System.out.printf("The number %d can be written as \"Four\".", number);
    else if (number == 5)
    System.out.printf("The number %d can be written as \"Five\".", number);
    else if (number == 6)
    System.out.printf("The number %d can be written as \"Six\".", number);
    else if (number == 7)
    System.out.printf("The number %d can be written as \"Seven\".", number);
    else if (number == 8)
    System.out.printf("The number %d can be written as \"Eight\".", number);
    else if (number == 9)
    System.out.printf("The number %d can be written as \"Nine\".", number);
    else if (number == 10)
    System.out.printf("The number %d can be written as \"Ten\".", number);
    else
    System.out.println("Invalid Number");
    System.out.println();
  }
}
