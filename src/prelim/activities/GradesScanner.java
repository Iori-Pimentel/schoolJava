/**
 * Name: Iori Z. Pimentel
 * Date: Sep 21, 2022
 * Class Code and Course Number: 9315 - CS 112
 -----------------------------------------------------------------
 Input: The user's three grades using Scanner
 Processes: Find the average of the user's grades.
 ------------------------------------------------------------------
 Algorithm:
 1. avg = (g1 + g2 + g3) / 3
 -------------------------------------------------------------------
 Output: Average Grade
 Display results and a Remark
 */


package prelim.activities;

import java.util.Scanner;

public class GradesScanner {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is your first grade? ");
        double firstGrade = Double.parseDouble(keyboard.nextLine());

        System.out.print("What is your second grade? ");
        double secondGrade = Double.parseDouble(keyboard.nextLine());

        System.out.print("What is your third grade? ");
        double thirdGrade = Double.parseDouble(keyboard.nextLine());

        double avg = (firstGrade + secondGrade + thirdGrade) / 3;

        System.out.printf("\nYour grade average is %f\n", avg);

        if (avg < 75)
            System.out.println(":-(");
        else
            System.out.println("Good Job");
    }
}
