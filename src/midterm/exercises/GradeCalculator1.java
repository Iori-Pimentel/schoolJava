
/**
* Name: Iori Z. Pimentel
* Date: Sep 14, 2022
* Activity Name and Number: Midterm Demo Program 1
------------------------------------------------------------
 OBJECTIVE:
 Create a program that has a method that is invoked by the main method


 Create a program that computes and displays the grade that is corresponding
 to a given score based on the following specifications:

 The grade is the integer value of (rawScore/perfectScore * 50 +50 )

 The perfectScore is an input by the program user at runtime.
 The perfectScore should be validated such that a perfectScore that is
     0 or negative should let the program user re-enter a valid perfectScore.

 The rawScore is an input by the program user at runtime.
 The rawScore should be validated such that a rawScore that is greater than the
   perfectScore should let the program user re-enter a valid rawScore.
   In addition, a rawScore that is less than 0 should let the program user
   re-enter a valid rawScore.

 The program execution will stop only if the user answers no to the question
    Do you want to compute another grade<Yes/No> ?

 Sample Run:


 Enter the perfect score: 0
 The perfect score should be greater than 0. Please enter a valid perfect score

 Enter the perfect score: 100

 Enter a raw score:   101

 The raw score cannot be higher than the perfect score.
    Please enter a valid raw score.

 Enter a raw score: -5

 The raw score cannot be lower than 0.
 Please enter a valid raw score.

 The raw score cannot be higher than the perfect score.
 Please enter a valid raw score. 90

 Grade = 95

 Do you want to compute another grade<Yes/No>: Yes

 Enter the perfect score: 10
 Enter a raw score:   5

 Grade = 95

 Do you want to compute another grade<Yes/No>: No
 */

package midterm.exercises;

import java.util.Scanner;

public class GradeCalculator1 {
    /**
     1. Construct keyboard as an object of the Scanner class
     2. Declare and initialize rawScore and perfectScofre
     3. Declare and initialize grade
     4. Declare and initialize computeAgain to true.
     5. while computeAgain = true;

        5.1 do {
               Print a prompt message for the user to enter a perfect score
               Read the value of perfectScore
               if (perfectScore <= 0 )
                  Print a message informing the user that an invalid perfect score has been entered
           } while (perfectScore <= 0)

        5.2  do {
             Print a prompt message for the user to enter a raw score
             Read the value of rawScore
             if (rawScore < 0)
                print a message informing the user that the raw score must not be lower than 0
             if (rawScore > perfectScore)
                print a message informing the user that the raw score must not be greater than the perfect score
         } while (rawScore <0 or rawScore > perfectScore)

        5.3 Compute the grade by using the computeGrade method
        5.4. Print the computed grade
        5.5. Print a prompt message "Do you want to compute again<Yes/No>?"
        5.6. Read the response to the prompt message "Do you want to compute again<Yes/No>?" and assign to computeAgain
        5.7. Repeat from  step 5
     6. Close the program
     * */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("This program will let you compute a grade corresponding to a raw score ");
        System.out.println("  based on the formula grade = rawScore/perfectScore*50 + 50. ");
        System.out.println("  You will be asked to enter the perfect score and the raw score.");
        int rawScore=0;
        int perfectScore=0;
        int grade=50;
        boolean computeAgain = true;
        while (computeAgain){
            do {
                System.out.print("Enter the perfect score: ");
                perfectScore = Integer.parseInt(keyboard.nextLine());
                if (perfectScore <= 0){
                    System.out.println("The perfect score should be greater than 0");
                }
            } while (perfectScore <= 0);
            do {
              System.out.print("Enter the raw score: ");
              rawScore = Integer.parseInt(keyboard.nextLine());
              if (rawScore < 0)
                System.out.println("The raw score should be greater than 0");
              if (rawScore > perfectScore)
                System.out.println("The raw score should be less than the perfect score");
            } while (rawScore < 0 || rawScore > perfectScore);

            grade = (int) ((double) rawScore/ (double) perfectScore*50 +50);

            System.out.println("The calculated grade is " + grade);

            System.out.println("\nDo you want to compute again<Yes/No>?");
            String answer = keyboard.nextLine();
            if (answer.charAt(0)== 'Y' || answer.charAt(0) == 'y'){
                computeAgain = true;
            } else {
                computeAgain = false;
            }
        } // end of while

    }  // end of main method


}  // end of class
