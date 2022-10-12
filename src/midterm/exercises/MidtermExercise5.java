/**
 * Name: Iori Z. Pimentel
 * Date: Oct 12, 2022
 * Activity Name and Number: Midterm Exercise Program 5
 ------------------------------------------------------------
 Test the program given below with different possible input values. Note that the program requires
 the user to enter 10 pairs of grades and number of units. Note also that the program allows the user
 to enter invalid values. Note further that the computation process involved is repetitive and that
 the computation process can be handled by a loop construct.
 Required:
 Write another version of the program so that the following specifications are satisfied:
 • The number of pairs of grades and units is an input value at run time. Hence, the
 program may be used to compute the average of 5 grades, 8 grades, 10 grades, etc.
 • There are validation processes for the input values. Grades must be integers from 65 to
 99. The number of units must be at least 1 but not more than 12. If an input value is
 invalid, the user should be given a directive to enter another value and that processing
 will continue after the user enters a valid value.

 • The repetitive computation process is handled using an iteration construct. (while, do-
 while or for construct)

 • The computer will display a running average after every pair of grades and units is
 entered. The running average is the average of the grades entered so far.
 */


package midterm.exercises;
import java.lang.*;
import java.util.Scanner;
public class MidtermExercise5 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the amount of grades to compute: ");
        int gradeCount = Integer.parseInt(keyboard.nextLine());

        int totalGrade = 0,totalUnits = 0, grade, units;
        String postfix;

        for (int i = 1; i <= gradeCount; i++) {
            postfix = switch (i % 10) {
                case 1 -> "st";
                case 2 -> "nd";
                case 3 -> "rd";
                default -> "th";
            };

            System.out.printf("\nEnter the grade of the student for the %d%s subject: ", i, postfix);

            while (true) {
                grade = Integer.parseInt(keyboard.nextLine());
                if (grade < 65 || grade > 99) {
                    System.out.println(ANSI_RED + "Invalid Value\nTry Again..." + ANSI_RESET);
                    System.out.printf("\nEnter again for the %d%s subject[65 < grade < 99]: ", i, postfix);
                } else break;
            }

            System.out.printf("\nEnter the number of units for the %d%s subject: ", i, postfix);

            while (true) {
                units = Integer.parseInt(keyboard.nextLine());
                if (units < 1 || units > 12) {
                    System.out.println(ANSI_RED + "Invalid Value\nTry Again..." + ANSI_RESET);
                    System.out.printf("\nEnter again for the %d%s subject[1 < unit < 12]: ", i, postfix);
                } else break;
            }

            totalGrade += grade * units;
            totalUnits += units;
        }

        double average = (double) totalGrade / totalUnits;
        System.out.printf("%s%.2f%n", "Average Grade = ", average);
        System.exit(0);
    }
    public static final String ANSI_RESET = "\u001B[0m"; // reset text color
    public static final String ANSI_RED = "\u001B[31m"; // red color

}