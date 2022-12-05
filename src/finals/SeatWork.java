/**
 /**
 * Name: Iori Z. Pimentel
 * Date: Dec 5, 2022
 * Class Code, Course No. and Schedule: 9215 CS 112 1:00-2:30pm
 ------------------------------------------------------------
 Based on the given descriptions, specify the missing parts in the following program.
 Every blank line corresponds to a missing part. The missing part should be specified
 based on the given description of the missing part.
 Write your ANSWERS ONLY on your answer sheet. */
package finals;
import java.util.Scanner;
public class SeatWork {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
/* Requirement 1: Declare and initialize ages as an array of integers
that stores the elements 18, 17, 19, 23, 20, 24, 21*/
        int[] ages = {18, 17, 19, 23, 20, 24, 21};
/* Requirement 2: Declare and initialize players as an array of String
that stores the names "Romy", "Anton", "Elmer", "Paul", "Sammy", "Benjie", "Ramon"*/
        String[] players = {"Romy", "Anton", "Elmer", "Paul", "Sammy", "Benjie", "Ramon"};
        System.out.print("Press enter to show the elements of the ages contained by array ages");
        keyboard.nextLine();
        /*Requirement 3: Use showArray1 to display on the screen the elements of array ages*/
        showArray1(ages);
        System.out.println("The showArray1 method was used in displaying the above");
        System.out.print("Press enter to continue");
        keyboard.nextLine();
        /*Requirement 4: Use showArray2 to display again on the screen the elements of array ages*/
        showArray2(ages);
        System.out.println("The showArray2 method was used in displaying the above");
        System.out.print("Press enter to continue");
        keyboard.nextLine();

        System.out.print("Press enter to show the names of players that are in array players");
        keyboard.nextLine();
        /*Requirement 5: Use showArray3 to display again on the screen the elements of array players*/
        showArray3(players);
        System.out.println("The showArray3 method was used in displaying the above");
        System.out.print("Press enter to continue");
        keyboard.nextLine();
        System.out.print("Press enter to show the sorted ages");
        keyboard.nextLine();
        int[] modifiedArray =new int[ages.length];
        modifiedArray = balloonSortArray(ages);
        showArray1(modifiedArray);
        System.out.print("Press enter to show the sorted names");
        keyboard.nextLine();
        String[] modifiedStringArray =new String[players.length];
        modifiedStringArray = sortStringArray(players);
        showArray6(modifiedStringArray);
        System.out.print("Press enter to see the elements of 2 parallel arrays");
        /*Display the corresponding elements of the players array and the ages array*/
        showData(players,ages);
        System.exit(0);
    } // end of main method
    /** Shows the elements of an array of int*/
    public static void showArray1(int[] array) {
        System.out.println("Elements of the Array");
        for (int index = 0; index < array.length; index++)
            System.out.println((index + 1) + ": " + array[index]);
    } // end of showArray1 method
    /** Shows the elements of an array of int*/
    public static void showArray2(int[] array) {
        System.out.println("Elements of the array");
        for (int element : array)
/* Requirement 6. What statement should appear below so that
the current value of element is displayed? */
            System.out.println(element);
    } // end of showArray2 method
    /**Shows the elements of an array of String*/

    public static void showArray3(String[] array) {
        System.out.println("Elements of the array");
/*Requirement 7. What expression should be inside the parenthesis so that the
elements of array are displayed one after the other?
*/
        for (String element : array)
            System.out.println(element);
    } // end of showArray3 method
    /**Shows the elements of an array of String*/
    public static void showArray6(String[] array) {
        System.out.println("Elements of the Array");
        for (int index = 0; index < array.length; index++)
            System.out.println((index + 1) + ": " + array[index]);
    } // end of showArray6 method
    /**Returns a copy of a given array of integers*/
    public static int[] copyArray(int[] array1) {
        int[] copied = new int[array1.length];
        for (int index = 0; index < array1.length; index++) {
            copied[index] = array1[index];
        }
        return copied;
    } // end of copyArray method
    /**Returns a copy of a given array of strings*/
    public static String[] copyArray(String[] array1){
        String[] copied = new String[array1.length];
        for (int index=0; index< array1.length; index++){
            copied[index] = array1[index];
        }
        return copied;
    } // end of copyStringArray method
    /**Returns a sorted version of a given array of int following the descending order*/
    public static int[] balloonSortArray(int[] givenArray) {
        int[] sortedArray = copyArray(givenArray); // to be sorted
        for (int x = 0; x < sortedArray.length - 1; x++) {
            for (int y = x + 1; y < sortedArray.length; y++) {
/*Requirement 8: What expression must be inside the parenthesis
so that the elements of givenArray are sorted in descending order
*/
                if (sortedArray[x] < sortedArray[y]) { //TODO
                    int temp = sortedArray[x];
                    sortedArray[x] = sortedArray[y];
                    sortedArray[y] = temp;
                } // end of if

            } // end of second for
        } // end of first for
        return sortedArray;
    } // end of balloonSortArray method
    /**Returns a sorted version of a given array of Strings following
     lexicographic ordering */
    public static String[] sortStringArray(String[] given){
        int minIndex = 0;
        String[] sorted = copyArray(given);
        String temp = "";
/*Requirement 9: What expression must be inside the parenthesis

so that the elements of array given are lexicographically ordered
based on the Selection Sort algorithm. Note that the variable
used in the following statements depends on previous statement.
*/

        for (int x = 0; x < sorted.length - 1; x++) { //TODO
            minIndex = x;
            for (int y = x + 1; y < sorted.length; y++)
                if (sorted[y].compareToIgnoreCase(sorted[minIndex]) < 0)
                    minIndex = y;
            if (minIndex != x) {
                temp = sorted[x];
                sorted[x] = sorted[minIndex];
                sorted[minIndex] = temp;
            } // end of if (minIndex != x)
        }
        return sorted;
    } // end of sortStringArray
    /**Shows the corresponding elements of an array of string and an array of integers*/
/*
Requirement 10. Show the formal parameters of the following method.
Note that the names of variables that are used in the body of the
method depend on the names of the formal parameters.
* */
    public static void showData(String[] players, int[] ages){
        System.out.println();
        System.out.printf("%-30s%-15s%n","Name of Player","Age of Player");
        for (int index=0; index < players.length; index++){
            System.out.printf("%-30s%-15d%n",players[index],ages[index]);
        }
        return;
    } // end of showData methoD
} // end of class