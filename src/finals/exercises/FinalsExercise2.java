/**
 * Name: Iori Z. Pimentel
 * Date: Nov 7, 2022
 * Activity Name and Number: Finals Exercise 2
 ------------------------------------------------------------
 * Assume that the final grade to be given to a student of Saint Louis University is computed by
 the formula:
 * finalGrade = (prelimGrade + midtermGrade + tentativeFinalGrade) / 3;
 *
 * Suppose the prelims and midterms are finished and that the prelim and the midterm grades are
 * already known. What tentative final grade should a student earn so that the student will get
 * the final grade that he/she desires.
 * When completed, the following program computes the tentative final grade that should be earned
 * after reading a prelim grade, midterm grade and desired final grade.
 */


package finals.exercises;
import java.util.*;
import java.lang.*;

public class FinalsExercise2 {
    /**
     * A method that returns a name read from the keyboard.
     */
    public static String readName(String promptMessage) {
        Scanner keyboard = new Scanner(System.in);
        String name = "";
        System.out.print(promptMessage + ": ");
        name = keyboard.nextLine(); // No. 1
        return name;
    }
    /**
     * A method that returns a whole number read from the keyboard.
     */
    public static int readInt(String promptMessage) {
        Scanner keyboard = new Scanner(System.in);
        int value = 0;
        System.out.print(promptMessage + " : ");
        value = Integer.parseInt(keyboard.nextLine()); // No. 2
        return value;
    }
    /**
     * A method that returns the t that satisfies f = (p + m + t) / 3 when f, p and m are given
     */
    public static int computeRequiredTFG(int p, int m, int f) {
        return 3 * f - (p + m); // No. 3
    }
    /**
     *A method that shows on screen the student name and the student's grades
     */
    public static void showStudent(String n, int p, int m, int t, int f) {
        System.out.printf("%35s%s%n", "Name ................: ", n);
        System.out.printf("%35s%d%n", "Prelim Grade ........: ", p);
        System.out.printf("%35s%d%n", "Midterm Grade .......: ", m);
        System.out.printf("%35s%d%n", "Desired Final Grade : ", f);
        System.out.printf("%35s%d%n", "Required Tentative Final Grade: ", t);
        if (t > 100) { // No. 4 Check if it exceeds 100
            System.out.println(" Sorry! It is impossible to get your desired final grade.");
            System.out.println("The highest grade that you can get if you get perfect scores " +
                    "in all final requirements is " + (p + m + 100) / 3 + ".");
        } else {
            System.out.println(" Good luck! Your goal is not impossible.");
        }
    }
    // The main method of the program
    public static void main(String[] args) { // No. 5 main method header
        Scanner keyboard = new Scanner(System.in);
        String studName = "";
        char wantToCompute = 'y';
        int prelimGrade = 50, midtermGrade = 50, desiredFinalGrade = 50,
                neededTentativeFinalGrade = 50;
        while (wantToCompute == 'y' || wantToCompute == 'Y') {
            studName = readName("Enter the name of the student");
            prelimGrade = readInt("Enter your prelim grade");
            midtermGrade = readInt("Enter your midterm grade");
            desiredFinalGrade = readInt("Enter your desired final grade");
            neededTentativeFinalGrade = computeRequiredTFG(prelimGrade, midtermGrade,
                    desiredFinalGrade);
            showStudent(studName, prelimGrade, midtermGrade, neededTentativeFinalGrade,
                    desiredFinalGrade);
            System.out.print("\nDo you want to compute again <y/n>? ");
            wantToCompute = keyboard.nextLine().charAt(0);
        }
        System.exit(0);
    } // end of main method
} // end of class