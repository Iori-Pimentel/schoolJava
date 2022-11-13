/**
 * Name: Iori Z. Pimentel
 * Date: Sep 21, 2022
 * Class Code and Course Number: 9315 - CS 112
 -----------------------------------------------------------------
 Input: A number between 1-10
 Processes: Convert number into word using switch
 ------------------------------------------------------------------
 Output: Word from Number
 Display results
 */


package prelim.activities;

import java.util.Scanner;

public class NumberInWordsSwitch {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("Give me a number: ");
    int number = Integer.parseInt(keyboard.nextLine());

    if (number < 1 || number > 10) {
      System.out.println("Invalid Number");
      System.exit(418);
    }

    String wordedNum = switch (number) {
      case 1 -> "One";
      case 2 -> "Two";
      case 3 -> "Three";
      case 4 -> "Four";
      case 5 -> "Five";
      case 6 -> "Six";
      case 7 -> "Seven";
      case 8 -> "Eight";
      case 9 -> "Nine";
      case 10 -> "Ten";
      default -> "Invalid";
    };

    System.out.printf("The number %d can be written as \"%s\".", number, wordedNum);
  }
}
