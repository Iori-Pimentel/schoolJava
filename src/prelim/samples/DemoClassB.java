/*
 * Name: Iori Z. Pimentel
 * Date: Sep 12, 2022
 *
 *Problem:
 *   Create a program that lets the computer accept an amount that is a multiple of 100.
 *   The computer should then, display the number of five hundreds in the entered amount
 *   and the number of one hundreds corresponding to the remaining amount after 5oo hundreds
 *   are given.
 *
 * Algorithm:
 *   1. Let validAmount be false
 *   2. Let the stringToDisplay be the empty string
 *   3. Let amount, nFiveHundreds be and nOneHundreds be 0.
 *   4. While validAmount is false
 *        4.1. Accept the amount
 *                if the amount is a mutliple of 100, let validAmount=true and go to step 5
 *                else
 *                     Let validAmount=false
 *                     Display an error message and repeat step 4
 *   5. Concatenate "Amount to be given = ", the value of amount, and the newline character
 *            to stringTodisplay
 *   6. Compute number of nFiveHundreds
 *   7. Concatenate "Number of Five Hundreds = ", the value of nFiveHundreds and the newline character
 *             to stringToDisplay
 *   8. Let amount = amount modulo 500
 *   9. Compute number of nOneHundreds in current value of amount
 *   10. Concatenate "Number of One Hundreds = ", the value of nOneHundreds and the newline charactrer
 *             to StringToDisplay
 *   11. Display stringToDisplay
 *   12. Close the program
 *
 *
 * */

package demo;

import javax.swing.*;
import java.util.StringTokenizer;

public class DemoClassB {
  public static void main(String[] args) {
    boolean validAmount = false;
    String stringToDisplay = "", inputString = "";
    int amount = 0, nFiveHundreds = 0, nOneHundreds = 0;

    JOptionPane.showMessageDialog(null, "Demo Test for Multiples of 100s.");

    while (!validAmount){
      try {
        inputString = JOptionPane.showInputDialog("Enter an amount: ");
        amount = Integer.parseInt(inputString);

        if (amount < 0){
          JOptionPane.showMessageDialog(null, "The amount should be positive.");
          continue;
        }
        if (amount % 100 != 0) {
          JOptionPane.showMessageDialog(null, "The amount is not a multiple of 100. ");
          continue;
        }
        validAmount = true;
      } catch (Exception exception){
        JOptionPane.showMessageDialog(null, "The amount is invalid.");
      }
    } // end of while

    stringToDisplay = stringToDisplay + "Results\n\n";
    stringToDisplay = stringToDisplay + "Amount to be given = " + amount + "\n";
    nFiveHundreds = amount / 500;
    stringToDisplay = stringToDisplay + "No. of Five Hundreds = " + nFiveHundreds + "\n";
    amount %= 500;
    nOneHundreds = amount / 100;
    stringToDisplay = stringToDisplay + "No. of One Hundreds = " + nOneHundreds + "\n";

    JOptionPane.showMessageDialog(null, stringToDisplay);

    stringToDisplay = "Done..\n\n Exiting...";
    JOptionPane.showMessageDialog(null, stringToDisplay);

    System.exit(0);

  }

}
