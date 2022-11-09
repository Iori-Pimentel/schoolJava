package finals.exercises;

import java.util.Scanner;

public class FinalsExercise4F {
    public static void main(String[] args) {
        showIntroduction();
        String[] unsortedNames = getNamesList();
        String[] sortedNames = selectionSort(unsortedNames);
        printOutput(unsortedNames, sortedNames);
    }

    public static void showIntroduction() {
        System.out.println("\nProgram that will allow the computer to accept some names that are not sorted.");
        System.out.println("The output will be a sorted list of names using the Selection Sort.");
    }

    public static String[] getNamesList() {
        Scanner keyboard = new Scanner(System.in);
        String[] unsortedNames = new String[5];
        System.out.println("Numbers to sort:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("[%d]\t: ", i + 1);
            unsortedNames[i] = keyboard.nextLine();
        }
        return unsortedNames;
    }

    public static String[] selectionSort(String[] unsortedNames) {
        String[] sortedNames = new String[5];

        for (int i = 0; i < unsortedNames.length; i++) {
            sortedNames[i] = unsortedNames[i]; // Copy unsorted array to new array
        }

        for (int i = 0; i < sortedNames.length - 1; i++) { // Selection Sort of Strings
            int minIndex = i;
            for (int j = i + 1; j < sortedNames.length; j++) {
                if (sortedNames[i].compareToIgnoreCase(sortedNames[j]) > 0) {
                    minIndex = j;
                }
                String temp = sortedNames[i];
                sortedNames[i] = sortedNames[minIndex];
                sortedNames[minIndex] = temp;
            }
        }
        return sortedNames;
    }

    public static void printOutput(String[] unsortedNames, String[] sortedNames) {
        System.out.print("Unsorted List: ");
        for (int i = 0; i < sortedNames.length; i++) {
            System.out.print(unsortedNames[i] + "\t");
        }
        System.out.println();

        System.out.print("  Sorted List: ");
        for (int i = 0; i < sortedNames.length; i++) {
            System.out.print(sortedNames[i] + "\t");
        }
    }
}