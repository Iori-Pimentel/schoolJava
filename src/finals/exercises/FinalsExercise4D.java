package finals.exercises;

import java.util.Scanner;

public class FinalsExercise4D {
  public static void main(String[] args) {
    showIntroduction();
    int arrayLen = getArrayLen();
    int[] unsortedNames = getNamesList(arrayLen);
    String[] sortedNames = balloonSort(unsortedNames);
    printOutput(unsortedNames, sortedNames);
  }

  public static void showIntroduction() {
    System.out.println("\nProgram that will allow the computer to accept some names that are not sorted.");
    System.out.println("The output will be a sorted list of names using the Balloon Sort.");
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

  public static String[] balloonSort(String[] unsortedNames) {
    String[] sortedNames = new String[unsortedNames.length];

    for (int i = 0; i < unsortedNames.length; i++) {
      sortedNames[i] = unsortedNames[i]; // Copy unsorted array to new array
    }

    for (int i = 0; i < sortedNames.length; i++) { // Balloon Sort of Strings
      for (int j = i + 1; j < sortedNames.length; j++) {
        if (sortedNames[i].compareToIgnoreCase(sortedNames[j]) > 0) {
          String temp = sortedNames[i];
          sortedNames[i] = sortedNames[j];
          sortedNames[j] = temp;
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


