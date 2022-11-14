/**
 * Name: Iori Z. Pimentel
 * Date: Nov 14, 2022
 * Activity Name and Number: Finals Exercise 5B
 ------------------------------------------------------------
 * A program that creates a class record. The names, quiz scores, exam scores,
 * quiz grades, exam grades and subject grades are stored by parallel arrays.
 **/
package finals.exercises;

import java.util.Scanner;
public class FinalsExercise5B {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        int[] quizScore; 
        int[] examScore; 
        String[] names; 
        int perfectQuizScore; 
        int perfectExamScore; 
        double[] quizGrade; 
        double[] examGrade; 
        double[] subjectGrade; 
        int size;

        size = readInteger(0, 100, "Enter number of students");

        quizScore = new int[size];
        examScore = new int[size];
        names = new String[size];
        quizGrade = new double[size];
        examGrade = new double[size];
        subjectGrade = new double[size];

        perfectQuizScore = readInteger(0, 1000, "Enter the perfect quiz score");
        perfectExamScore = readInteger(0, 1000, "Enter the perfect exam score");

        for (int x = 0; x < size; x++) {
            names[x] = readString("Enter the name of student " + (x + 1));
            quizScore[x] = readInteger(0, perfectQuizScore, "Enter the quiz score of " + names[x]);
            examScore[x] = readInteger(0, perfectExamScore, "Enter the examination score of " + names[x]);
            quizGrade[x] = computeGrade(quizScore[x], perfectQuizScore);
            examGrade[x] = computeGrade(examScore[x], perfectExamScore);
            subjectGrade[x] = (quizGrade[x] + examGrade[x]) / 2;
        } 

        System.out.println("\n\nPerfect Quiz Score = " + perfectQuizScore);
        System.out.println("\nPerfect Exam Score = " + perfectExamScore);
        showData(names, quizScore, examScore, quizGrade, examGrade, subjectGrade);

        double averageGrade = computeAverage(subjectGrade);
        System.out.printf("%n%25s%5.2f%n", "Average Grade =", averageGrade);

        double lowestGrade = findLowest(subjectGrade);
        System.out.printf("%n%25s%5.2f%n", "Lowest Grade =", lowestGrade);

        double highestGrade = findHighest(subjectGrade);
        System.out.printf("%n%25s%5.2f%n", "Highest Grade =", highestGrade);

        System.out.println();
        System.out.println("Sorted Record");
        parallelSortD(names, quizScore, examScore, quizGrade, examGrade, subjectGrade);
        showData(names, quizScore, examScore, quizGrade, examGrade, subjectGrade);

        System.exit(0);
    } 
    /**
     Reads and returns an integer from input device after seeing a prompt message. The value
     should be in the range lowLimit to upLimit.
     */
    public static int readInteger(int lowLimit, int upLimit, String prompt) {
        int value = 0;
        do {
            System.out.print(prompt + ": ");
            value = Integer.parseInt(keyboard.nextLine());
            if (value < lowLimit || value > upLimit) {
                System.out.println("You must enter an integer in the range " + lowLimit + " to " +
                        upLimit + ".");
            }
        } while (value < lowLimit || value > upLimit);
        return value;
    }
    /**
     Reads and returns a floating point number from input device after seeing a prompt message.
     The value should be in the range lowLimit to upLimit.
     */
    public static double readDouble(double lowLimit, double upLimit, String prompt) {
        double value = 0;
        do {
            System.out.print(prompt + ": ");
            value = Double.parseDouble(keyboard.nextLine());
            if (value < lowLimit || value > upLimit) {
                System.out.println("You must enter a floating point number in the range " +
                        lowLimit + " to " + upLimit + ".");
            }
        } while (value < lowLimit || value > upLimit);
        return value;
    }
    /**
     Reads and returns a string from input device after seeing
     a prompt message. The String must not be a null string.
     */
    public static String readString(String prompt) {
        String value = "";
        do {
            System.out.print(prompt + " : ");
            value = keyboard.nextLine();
            if (value.compareTo("") == 1) {
                System.out.println("You must type a string that is not null.");
            }
        } while (value.compareTo("") == 0);
        return value;
    }
    /**
     Finds and returns the lowest value from an array of floating point numbers
     */
    public static double findLowest(double[] values) {
        double result = values[0]; 
        for (int x = 1; x < values.length; x++) 
            if (values[x] < result) 

                result = values[x]; 
        return result;
    }
    /**
     Finds and returns the highest value from an array of floating point numbers
     */
    public static double findHighest(double[] values) {
        double result = values[0]; 
        for (int x = 1; x < values.length; x++) 
            if (values[x] > result) 
                result = values[x]; 
        return result;
    }
    /**
     Computes and returns the average of the elements an array of floating point numbers
     */
    public static double computeAverage(double[] values) {
        double total = 0; 
        double average = 0; 
        for (int x = 0; x < values.length; x++) 
            total = total + values[x];

        average = total / values.length; 
        return average;
    }
    /**
     Computes and returns a grade corresponding to a score. The grade equals
     score / perfectScore * 50 + 50. If computation yields more than 99, the grade is set to 99.
     If computation yields less than 65, the grade is set to 65.
     */
    public static double computeGrade(int score, int perfect) {
        double result = 65;
        result = (double) score / perfect * 50 + 50;
        if (result > 99)
            result = 99.0;
        if (result < 65)
            result = 65.0;
        return result;
    }
    /**
     The ff. method sorts the 2 arrays in parallel following the balloon sort algorithm.
     */
    public static void parallelSort(String[] c, double[] a) {
        for (int x = 0; x < c.length - 1; x++) {
            for (int y = x + 1; y < c.length; y++) {
                if (c[x].compareToIgnoreCase(c[y]) > 0) {
                    String temp = c[x];
                    c[x] = c[y];
                    c[y] = temp;
                    double dummy = a[x];
                    a[x] = a[y];
                    a[y] = dummy;
                }
            }
        }
    }

    /**
     The ff. method sorts the 6 arrays in parallel following the balloon sort algorithm. Sorting
     is based on the string array c.
     */
    public static void parallelSort(String[] c, int[] q, int[] e, double[] p, double[] a, double[] i) {
        for (int x = 0; x < c.length - 1; x++) {
            for (int y = x + 1; y < c.length; y++) {
                if (c[x].compareToIgnoreCase(c[y]) > 0) {
                    String temp = c[x];
                    c[x] = c[y];
                    c[y] = temp;
                    int t = q[x];
                    q[x] = q[y];
                    q[y] = t;
                    t = e[x];
                    e[x] = e[y];
                    e[y] = t;
                    double dummy = p[x];
                    p[x] = p[y];
                    p[y] = dummy;
                    dummy = a[x];
                    a[x] = a[y];
                    a[y] = dummy;
                    dummy = i[x];
                    i[x] = i[y];
                    i[y] = dummy;
                }
            }
        }
    }
    /**
     The ff. method sorts the 6 arrays in parallel following the balloon sort algorithm. Sorting
     is based on the double array i.
     */
    public static void parallelSortD(String[] c, int[] q, int[] e, double[] p, double[] a, double[] i) {
        for (int x = 0; x < c.length - 1; x++) {
            for (int y = x + 1; y < c.length; y++) {
                if (i[x] < (i[y])) {
                    String temp = c[x];
                    c[x] = c[y];
                    c[y] = temp;
                    int t = q[x];
                    q[x] = q[y];
                    q[y] = t;
                    t = e[x];
                    e[x] = e[y];
                    e[y] = t;
                    double dummy = p[x];
                    p[x] = p[y];

                    p[y] = dummy;
                    dummy = a[x];
                    a[x] = a[y];
                    a[y] = dummy;
                    dummy = i[x];
                    i[x] = i[y];
                    i[y] = dummy;
                }
            }
        }
    }
    /**
     Display the scores and grades of students. Displays elements of parallel arrays
     */
    public static void showData(String[] names, int[] quizScore, int[] examScore, double[] quizGrade, double[] examGrade, double[] subjectGrade) {
        System.out.printf("%10s%10s%10s%10s%10s%10s\n", "", "Quiz", "Exam", "Quiz", "Exam", "");
        System.out.printf("%10s%10s%10s%10s%10s%10s\n", "name", "Score", "Score", "Grade", "Grade", "Grade");
        System.out.printf("%10s%10s%10s%10s%10s%10s\n", "--------", "--------", "--------", "-------", "--------", "--------");
        for (int y = 0; y < subjectGrade.length; y++) {
            System.out.printf("%10s%10d%10d%10.0f%10.0f%10.0f\n", names[y], quizScore[y], examScore[y], quizGrade[y], examGrade[y], subjectGrade[y]);
        }
        System.out.printf("%10s%10s%10s%10s%10s%10s\n", "--------", "--------", "--------", "-------", "--------", "--------");
    }
} 