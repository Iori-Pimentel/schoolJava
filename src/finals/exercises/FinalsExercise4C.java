package finals.exercises;

import java.util.Scanner;

public class FinalsExercise4C {
    public static void main(String[] args) {
        showIntroduction();
        int[] unsortedNums = getNumsList();
        int[] sortedNums = selectionSort(unsortedNums);
        printOutput(unsortedNums, sortedNums);
    }

    public static void showIntroduction() {
        System.out.println("\nProgram that will allow the computer to accept some numbers that are not sorted.");
        System.out.println("The output will be a sorted list of numbers using the Selection Sort.");
    }

    public static int[] getNumsList() {
        Scanner keyboard = new Scanner(System.in);
        int[] unsortedNums = new int[5];
        System.out.println("Numbers to sort:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("[%d]\t: ", i + 1);
            unsortedNums[i] = Integer.parseInt(keyboard.nextLine());
        }
        return unsortedNums;
    }

    public static int[] selectionSort(int[] unsortedNums) {
        int[] sortedNums = new int[5];

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
        System.out.print("Unsorted List: ");
        for (int i = 0; i < sortedNums.length; i++) {
            System.out.print(unsortedNums[i] + "\t");
        }
        System.out.println();

        System.out.print("  Sorted List: ");
        for (int i = 0; i < sortedNums.length; i++) {
            System.out.print(sortedNums[i] + "\t");
        }
    }
}