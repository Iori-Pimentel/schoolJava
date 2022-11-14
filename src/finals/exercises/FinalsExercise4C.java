/**
 * Name: Iori Z. Pimentel
 * Date: Nov 14, 2022
 * Activity Name and Number: Finals Exercise 4C
 ------------------------------------------------------------
Input:
  Length of Array to sort
  Memebers of Array as Integers
Algorithm:
  Create a copy of the array to sort
  Sorting the array using Selection Sort
Output:
  Print the unsorted array
  Print the array in ascending order
  Print the array in descending order
*/
package finals.exercises;

import java.util.Scanner;

public class FinalsExercise4C {
  public static void main(String[] args) {
    showIntroduction();
    int arrayLen = getArrayLen();
    int[] unsortedNums = getNumsList(arrayLen);
    int[] sortedNums = selectionSort(unsortedNums);
    printOutput(unsortedNums, sortedNums);
  }

  public static void showIntroduction() {
    System.out.println("\nProgram that will allow the computer to accept some numbers that are not sorted.");
    System.out.println("The output will be a sorted list of numbers using the Selection Sort.");
  }

  public static int getArrayLen() {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Input the count for the array: ");

    int arrayLen = Integer.parseInt(keyboard.nextLine());
    return arrayLen;
  }

  public static int[] getNumsList(int arrayLen) {
    Scanner keyboard = new Scanner(System.in);
    int[] unsortedNums = new int[arrayLen];
    System.out.println("Numbers to sort:");
    for (int i = 0; i < arrayLen; i++) {
      System.out.printf("[%d]\t: ", i + 1);
      unsortedNums[i] = Integer.parseInt(keyboard.nextLine());
    }
    return unsortedNums;
  }

  public static int[] selectionSort(int[] unsortedNums) {
    int[] sortedNums = new int[unsortedNums.length];

    for (int i = 0; i < unsortedNums.length; i++) {
      sortedNums[i] = unsortedNums[i]; // Copy unsorted array to new array
    }

    for (int i = 0; i < sortedNums.length - 1; i++) { // Selection Sort of Integers
      int minIndex = i;
      for (int j = i + 1; j < sortedNums.length; j++) {
        if (sortedNums[i] > sortedNums[j]) {
          minIndex = j;
        }
      }
      int temp = sortedNums[i];
      sortedNums[i] = sortedNums[minIndex];
      sortedNums[minIndex] = temp;
    }
    return sortedNums;
  }

  public static void printOutput(int[] unsortedNums, int[] sortedNums) {
    System.out.println(); // Print unsorted integers
    System.out.print(" Unsorted Integers: ");
    for (int i = 0; i < sortedNums.length; i++) {
      System.out.print(unsortedNums[i] + "\t");
    }

    System.out.println(); // Print integers in ascending order
    System.out.print("[A]Sorted Integers: ");
    for (int i = 0; i < sortedNums.length; i++) {
      System.out.print(sortedNums[i] + "\t");
    }

    System.out.println(); // Print integers in descending order
    System.out.print("[D]Sorted Integers: ");
    for (int i = sortedNums.length - 1; i >= 0; i--) {
      System.out.print(sortedNums[i] + "\t");
    }
  }
}
