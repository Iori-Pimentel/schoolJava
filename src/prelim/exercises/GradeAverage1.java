/**
* Name: Iori Z. Pimentel
* Date: Sep 14, 2022
* Activity Name and Number: Prelim Exercise Number 9
------------------------------------------------------------
Analysis:
Input: 10 pairs of grades and units
Processes:
Read the grades and units
Compute the sum of the products of grades and units
Compute the total of the units
Compute the average : (sum of products of grades and units)/total_units
Show the average
Give an appropriate message
Output: Average, Message
Algorithm:
1. Let grade represent a grade for a subject
2. Let units represent number of units for a subject
3. Let totalGrade = 0 where totalGrade represents the sum of the products of grades and
corresponding units
4. Let totalUnits = 0 where totalUnits represents the total number of units
5. Let average represent the average grade of the student
6. Read the first grade
7. Read the number of units for the first grade
8. Add the product of first grade and the corresponding units to totalGrade
9. Add the units for the first grade to totalUnits
10. Repeat steps 6, 7, 8 and 9 for the 2nd to the 10th grade
11. Compute the average where average = totalGrades/totalUnits
12. Display the average
13. If (average >= 85) print “Congratulations! You belong to the dean's list."
14. If (average < 85) print “Sorry! You did not make it to the dean's list. Do better
next term."
*/
package prelim.exercises;
import java.lang.*;
import java.util.Scanner;

public class GradeAverage1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int grade;
        int units;
        int totalGrade = 0;
        int totalUnits = 0;
        double avg;
        String postfix;

        for (int i = 1; i < 11; i++) {
            postfix = switch (i) {
                case 1 -> "st";
                case 2 -> "nd";
                case 3 -> "rd";
                default -> "th";
            };

            System.out.printf("\nEnter the grade of the student for the %d%s subject: ", i, postfix);
            grade = Integer.parseInt(keyboard.nextLine());

            System.out.printf("Enter the number of units for the %d%s subject: ", i, postfix);
            units = Integer.parseInt(keyboard.nextLine());

            totalGrade += grade * units;
            totalUnits += units;
        }
        
        avg = (double) totalGrade / totalUnits;
        System.out.println("\nYour average is: " + avg);

        if (avg < 85) {
            System.out.println("Sorry! You did not make it to the dean's list. Do better next term.");
        } else {
            System.out.println("Congratulations! You belong to the dean's list.");
        }
    } // end of main
} // end of class
