/**
 * Name: Iori Z. Pimentel
 * Date: Dec 5, 2022
 * Activity Name and Number: Midterm Exam Part 2
 ------------------------------------------------------------
 */
package finals.exam;

import java.util.Scanner;

public class PimentelIoriMidtermExamPart2 {
    public static void main(String[] args) {
        System.out.println("\n\nThis program helps you determine if a year is a leap year.\n");
        char choice = 'y';
        while (choice == 'y') {
            int year = readYear();
            if (isLeapYear(year)) {
                System.out.printf("%d is a Leap year.\n" , year);
            } else {
                System.out.printf("%d is not a Leap Year.\n", year);
            }

            choice = repeatProcess("\nCheck for Leap Year Again? ");
        }

        System.out.println("\nClosing the Program...");
        System.exit(0);
    }

/**
 * Input: Prompt to show user
 * Algorithm: While Loop until user inputs valid choice.
 * Output: char 'y' or 'n'
 * */
    private static char repeatProcess(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print(prompt);
            input = keyboard.nextLine();

            if (input.equalsIgnoreCase("y")) {
                return 'y';
            } else if (input.equalsIgnoreCase("n")) {
                return 'n';
            } else {
                System.out.println("Choice can only be [Yy] or [Nn]");
            }
        }
    }

    /**
     * Input: Year given by user
     * Algorithm: Returns if the integer representing the year is divisible by 4 but is not divisible by 100 or the year is divisible by 400
     * Output: boolean true or false
     * */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Input: void
     * Algorithm: While loop until user inputs a valid Gregorian year that is at least 1582
     * Output: int year
     * */
    public static int readYear() {
        Scanner keyboard = new Scanner(System.in);

        int year;
        while (true){
            try {
                System.out.print("Enter an integer that represents a year in the Gregorian Calendar system: ");
                year = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) { // Catches invalid int input
                System.out.println("Try Again");
                continue;
            }

            if (year < 1582) {
                System.out.println("Year must be greater than or equal to [1582]");
            } else break;
        }

        return year;
    }
}
