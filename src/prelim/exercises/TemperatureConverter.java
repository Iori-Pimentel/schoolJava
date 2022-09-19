/**
 * Name: Iori Z. Pimentel
 * Date: Sep 19, 2022
 * Activity Name and Number: Prelim Exercise Number 13
 ------------------------------------------------------------
Problem:
Write a program that will make the computer read a temperature in Degrees Fahrenheit
or Degrees Celsius. Then, the computer prints the equivalent temperature in Degrees
Celsius or Degrees Fahrenheit.
*Analysis
Input: Temperature in Fahrenheit or Celsius
Processes:
Input temperature
Convert the temperature entered
Display temperatures
Output: Temperature in Celsius or Fahrenheit
*Algorithm:
1. Declare needed variables
2. Print introductory messages
3. Show choices
Menu:
a. Convert from Fahrenheit to Celsius
b. Convert from Celsius to Fahrenheit
c. Quit
4. Read choice
5. If choice is a,
Read temperature in Fahrenheit (fahrenheit)
Convert the temperature: celsius = 5.0 / 9 * (fahrenheit - 32)
Show temperatures
6. If choice is b,
Read temperature in Celsius (celsius)
Convert the temperature: fahrenheit = 9.0 / 5 * celsius + 32
Show temperatures
7. If choice is cTemperatureConverter
Print parting message
8. If choice is not a, not b and not c
Show an error message
9. Exit
*/
package prelim.exercises;
import java.util.Scanner;
import java.lang.*;
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        double celsius; // to hold temperature in degrees celsius
        double fahrenheit; // to hold temperature in degrees fahrenheit
        char choice;
        double convertedValue;

        System.out.println("\nThis program helps you convert temperature measures.");
        System.out.println("----------------Menu----------------------");
        System.out.println("a: Convert from Fahrenheit to Celsius");
        System.out.println("b: Convert from celsius to Fahrenheit");
        System.out.println("c: Quit");

        System.out.println("----------------Menu----------------------\n");
        System.out.print("Enter your choice <a/b/c>: ");
        choice = keyboard.nextLine().charAt(0);

        if (choice == 'a') {
            System.out.print("Enter the temperature in Fahrenheit: ");
            fahrenheit = Float.parseFloat(keyboard.nextLine());
            celsius = 5.0/9.0*(fahrenheit-32);
            System.out.println(fahrenheit + " degrees Fahrenheit equals " +
                celsius + " degrees Celsius ");
        } else if (choice == 'b') {
            System.out.print("Enter the temperature in celsius: ");
            celsius = Float.parseFloat(keyboard.nextLine());
            fahrenheit = 9.0/5.0*celsius+32;
            System.out.println(celsius + " degrees celsius equals " +
                fahrenheit + " degrees farenheit.");
        } else if (choice == 'c') {
            System.out.println("Quitting the program...");
        } else {
            System.out.println("Your choice is not valid.");
        }

        System.out.println("Thank you.");
        System.exit(0);
    } // End of main
} // End of class



