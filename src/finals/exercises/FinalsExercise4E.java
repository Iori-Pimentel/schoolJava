/**
 * Name: Iori Z. Pimentel
 * Date: Nov 14, 2022
 * Activity Name and Number: Finals Exercise 4E
 ------------------------------------------------------------
Input:
  Length of Array to sort
  Memebers of Array as Strings
Algorithm:
  Create a copy of the array to sort
  Sorting the array using Bubble Sort
Output:
  Print the unsorted array
  Print the array in lexicographical order
*/
package finals.exercises;

import java.util.Scanner;

public class FinalsExercise4E {
  public static void main(String[] args) {
    showIntroduction();
    int arrayLen = getArrayLen();
    int[] unsortedNames = getNamesList(arrayLen);
    String[] sortedNames = bubbleSort(unsortedNames);
    printOutput(unsortedNames, sortedNames);
  }

  public static void showIntroduction() {
    System.out.println("\nProgram that will allow the computer to accept some names that are not sorted.");
    System.out.println("The output will be a sorted list of names using the Bubble Sort.");
  }

  public static int getArrayLen() {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Input the count for the array: ");

    int arrayLen = Integer.parseInt(keyboard.nextLine());
    return arrayLen;
  }

  public static String[] getNamesList(int arrayLen) {
    Scanner keyboard = new Scanner(System.in);
    String[] unsortedNames = new String[arrayLen];
    System.out.println("Numbers to sort:");
    for (int i = 0; i < arrayLen; i++) {
      System.out.printf("[%d]\t: ", i + 1);
      unsortedNames[i] = keyboard.nextLine();
    }
    return unsortedNames;
  }

  public static String[] bubbleSort(String[] unsortedNames) {
    String[] sortedNames = new String[unsortedNames.length];

    for (int i = 0; i < unsortedNames.length; i++) {
      sortedNames[i] = unsortedNames[i]; // Copy unsorted array to new array
    }

    for (int i = 0; i < sortedNames.length - 1; i++) { // Bubble Sort of Strings
      for (int j = 0; j < sortedNames.length - i - 1; j++) {
        if (sortedNames[j].compareToIgnoreCase(sortedNames[j + 1]) > 0) {
          String temp = sortedNames[j];
          sortedNames[j] = sortedNames[j + 1];
          sortedNames[j + 1] = temp;
        }
      }
    }
    return sortedNames;
  }

  public static void printOutput(String[] unsortedNames, String[] sortedNames) {
    System.out.println(); // Print unsorted Strings
    System.out.print("Unsorted Names: ");
    for (int i = 0; i < sortedNames.length; i++) {
      System.out.print(unsortedNames[i] + "\t");
    }

    System.out.println(); // Print Strings in lexicographical order
    System.out.print("  Sorted Names: ");
    for (int i = 0; i < sortedNames.length; i++) {
      System.out.print(sortedNames[i] + "\t");
    }
  }
}
