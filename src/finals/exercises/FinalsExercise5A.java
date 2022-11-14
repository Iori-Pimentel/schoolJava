/**
 * Name: Iori Z. Pimentel
 * Date: Nov 14, 2022
 * Activity Name and Number: Finals Exercise 5A
 ------------------------------------------------------------
 * A program that creates a class record. The names, quiz scores, exam scores, quiz grades, exam
 * grades and subject grades are stored by parallel arrays.
 **/
package finals.exercises;
import java.util.Scanner;
import java.lang.*;
public class FinalsExercise5A { 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] quizScore; 
        int[] examScore; 
        String[] names; 
        int perfectQuizScore; 
        int perfectExamScore; 
        double[] quizGrade; 
        double[] examGrade; 
        double[] subjectGrade; 
        int size;

        while (true) { // Number of Students
            System.out.print("Enter the number of students: ");
            size = Integer.parseInt(keyboard.nextLine());
            if (size < 0)
                System.out.println("The number of students must be greater than 0.");
            else break;
        }

        quizScore = new int[size];
        examScore = new int[size];
        names = new String[size];
        quizGrade = new double[size];
        examGrade = new double[size];
        subjectGrade = new double[size];

        while (true) { // Perfect Quiz Score
            System.out.print("Enter the Perfect Quiz Score: ");
            perfectQuizScore = Integer.parseInt(keyboard.nextLine());
            if (perfectQuizScore <= 0)
                System.out.println("Invalid value! The perfect score must be greater than 0.");
            else break;
        }

        while (true) { // Perfect Exam Score
            System.out.print("Enter the Perfect Examination Score : ");
            perfectExamScore = Integer.parseInt(keyboard.nextLine());
            if (perfectExamScore <= 0)
                System.out.println("Invalid value! Value must be greater than 0.");
            else break;
        }

        for (int x = 0; x < size; x++) { // Loo[ for every student
            System.out.print("Enter the name of student " + (x + 1) + ": ");
            names[x] = keyboard.nextLine();

            while (true) {
                System.out.print("Enter the quiz score of " + names[x] + " : ");
                quizScore[x] = Integer.parseInt(keyboard.nextLine());
                if (quizScore[x] > perfectQuizScore)
                    System.out.println("Invalid value! Score must not be greater than perfect score.");
                else break;
            }

            while (true){
                System.out.print("Enter the examination score of " + names[x] + ": ");
                examScore[x] = Integer.parseInt(keyboard.nextLine());
                if (examScore[x] > perfectExamScore)
                    System.out.println("Invalid value! Score must not be greater than perfect score.");
                else break;
            }

            quizGrade[x] = (double) quizScore[x] / perfectQuizScore * 50 + 50;
            examGrade[x] = (double) examScore[x] / perfectExamScore * 50 + 50;
            subjectGrade[x] = (quizGrade[x] + examGrade[x]) / 2;

            if (subjectGrade[x] > 99)
                subjectGrade[x] = 99;
            else if (subjectGrade[x] < 65)
                subjectGrade[x] = 65;
        } 

        System.out.println("\n\nPerfect Quiz Score = " + perfectQuizScore);
        System.out.println("\nPerfect Exam Score = " + perfectExamScore);
        System.out.printf("%10s%10s%10s%10s%10s%10s\n", "", "Quiz", "Exam", "Quiz", "Exam", "");
        System.out.printf("%10s%10s%10s%10s%10s%10s\n", "name", "Score", "Score", "Grade", "Grade", "Grade");
        System.out.printf("%10s%10s%10s%10s%10s%10s\n", "--------", "--------", "--------", "-------", "--------", "--------");
        for (int y = 0; y < subjectGrade.length; y++) {
            System.out.printf("%10s%10d%10d%10.0f%10.0f%10.0f\n", names[y], quizScore[y], examScore[y], quizGrade[y], examGrade[y], subjectGrade[y]);
        }

        System.out.printf("%10s%10s%10s%10s%10s%10s\n", "--------", "--------", "--------", "-------", "--------", "--------");


        double totalGrade = 0; 
        for (int g = 0; g < subjectGrade.length; g++) {
            totalGrade += subjectGrade[g];
        }
        double averageGrade = totalGrade / subjectGrade.length;
        System.out.printf("%n%25s%5.2f%n", "Average Grade =", averageGrade);

        double lowestGrade = subjectGrade[0]; 
        for (int gr = 1; gr < subjectGrade.length; gr++) {
            if (lowestGrade > subjectGrade[gr])
                lowestGrade = subjectGrade[gr];
        }
        System.out.printf("%n%25s%5.2f%n", "Lowest Grade =", lowestGrade);

        double highestGrade = subjectGrade[0]; 
        for (int h = 1; h < subjectGrade.length; h++) {
            if (highestGrade < subjectGrade[h])
                highestGrade = subjectGrade[h];
        }
        System.out.printf("%n%25s%5.2f%n", "Highest Grade =", highestGrade);
        System.exit(0);
    } 
} 