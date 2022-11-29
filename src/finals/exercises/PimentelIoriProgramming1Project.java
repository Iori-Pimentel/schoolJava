//package finals.exercises;
//
//import java.util.Scanner;
//import java.util.Random;
//public class MyProgramming1Project {
//  // main method
//  public static void main(String[] args) {
//    Scanner keyboard = new Scanner(System.in);
//    showIntroduction();
//    keyboard.nextLine();
//
//    while (true) {
//      showMainMenu();
//
//      switch (enterChoice(1, 4)) {
//        case 1:
//          mathSolver();
//          break;
//        case 2:
//          recordKeeping();
//          break;
//        case 3:
//          miscellaneousProcesses();
//          break;
//        case 4:
//          System.out.println("Thank you for using my program.");
//          System.out.println("Enjoy the rest of your day.");
//          System.exit(1);
//        default:
//          System.out.println("Choice not found. Try again.");
//      } //end switch
//  } //end main method
//
//  public static void showIntroduction() {
//    System.out.println("\n\n\n");
//    System.out.println("College of Information and Computing Sciences");
//    System.out.println(" Saint Louis University");
//    System.out.println(" Baguio City ");
//    System.out.println("---------------------------------------------");
//    System.out.println("\n");
//    System.out.println(" Kyle Gem Lene Michael ");
//    System.out.println(" Programmer");
//    System.out.println("\n");
//    System.out.print("Please press a key to see Main Menu...");
//  }
//
//  public static void showMainMenu() {
//    System.out.println("Main Menu ");
//    System.out.println("----------------------------");
//    System.out.println("1. Math Routines");
//    System.out.println("2. Recording Routines");
//    System.out.println("3. Miscellaneous Routines");
//    System.out.println("4. Exit");
//    System.out.println("------------------------------");
//  }
//
//  public static void showMenu1() {
//    System.out.println("Math Routine Submenu ");
//    System.out.println("-----------------------------------------------");
//    System.out.println("1. Determine whether an integer is odd or even");
//    System.out.println("2. Determine sum of a series");
//    System.out.println("3. Determine the factors of a number");
//    System.out.println("4. Determine if a number is prime");
//    System.out.println("5. Determine the area of a circle");
//    System.out.println("6. Determine the area of a square");
//    System.out.println("7. Determine the area of a triangle");
//    System.out.println("8. Determine the area of a rectangle");
//    System.out.println("9. Determine the area of a trapezoid");
//    System.out.println("10. Determine the area of a parallelogram");
//    System.out.println("11. Determine if an integer is a perfect number");
//    System.out.println("12. Generate a multiplication table");
//    System.out.println("13. Determine the roots of a quadratic equation");
//    System.out.println("14. Generate a Fibonacci Sequence");
//    System.out.println("15. Generate a Pascal's Triangle");
//    System.out.println("16. Back to Main Menu");
//    System.out.println("------------------------------------------------");
//  }
//  public static void showMenu2() {
//    System.out.println("Recording Routine Submenu ");
//    System.out.println("-----------------------------------------------");
//    System.out.println("1. Accept and sort list of students");
//    System.out.println("2. Accept and sort list of Salesmen");
//    System.out.println("3. Accept pairs of names and grades and sort list according to name");
//    System.out.println("4. Accept pairs of names and grades and sort list according to grade");
//    System.out.println("5. Back to Main Menu");
//    System.out.println("------------------------------------------------");
//  }
//  public static void showMenu3() {
//    System.out.println("Miscellaneous Routine Submenu ");
//    System.out.println("-----------------------------------------------");
//    System.out.println("1. Number Guessing Game");
//    System.out.println("2. Covid19 Self-Assessment Procedure ");
//    System.out.println("3. Bills distribution of an amount of Money");
//    System.out.println("4. Interest of Money Invested ");
//    System.out.println("5. Income Tax Computation");
//    System.out.println("6. Insect Population Growth Rate");
//    System.out.println("7. Water Bill computaion.");
//    System.out.println("8. Electric Bill computation.");
//    System.out.println("9. Mobile Phone Load Balance Computation.");
//    System.out.println("10. Back to Main Menu");
//    System.out.println("------------------------------------------------");
//  }
//
//  public static int enterChoice(int min, int max) {
//    Scanner keyboard = new Scanner(System.in);
//    int choice = 0;
//
//    while (true) {
//      System.out.print("Input the number corresponding to your choice: ");
//      choice = Integer.parseInt(keyboard.nextLine());
//
//      if (choice < min || choice > max)
//        System.out.println("Invalid choice. Please ensure that you enter a number from " + min + " to " + max + ".");
//      else return choice;
//    }
//  }
//  public static void mathSolver() {
//    Scanner keyboard = new Scanner(System.in);
//
//    while (true) {
//      showMenu1();
//
//      switch (enterChoice(1, 16)) {
//        case 1:
//          int y;
//          System.out.print("Enter an integer :");
//          y = keyboard.nextInt();
//          System.out.println(detOddEven(y));
//          System.out.println();
//          System.out.print("press enter to continue...");
//          keyboard.nextLine();
//          keyboard.nextLine();
//          break;
//        case 2:
//          int z;
//          System.out.print("Enter an integer :");
//          z = keyboard.nextInt();
//          System.out.println("The sum of the series is " + getSumOfSeries(z));
//          System.out.println();
//          System.out.print("press enter to continue...");
//          keyboard.nextLine();
//          keyboard.nextLine();
//          break;
//        case 3:
//        // TO DO
//        break;
//        case 4:
//        // TO DO
//        break;
//        case 5:
//        // TO DO
//        break;
//        case 6:
//        // TO DO
//        break;
//        case 7:
//        // TO DO
//        break;
//        case 8:
//        // TO DO
//        break;
//        case 9:
//        // TO DO
//        break;
//        case 10:
//        // TO DO
//        break;
//        case 11:
//        // TO DO
//        break;
//        case 12:
//        // TO DO
//        break;
//        case 13:
//        // TO DO
//        break;
//        case 14:
//        int t;
//        System.out.print("\nHow many terms do you want? ");
//        t = keyboard.nextInt();
//        generateFibonacciSequence(t);
//        System.out.print("Press enter to continue...");
//        keyboard.nextLine();
//        keyboard.nextLine();
//        break;
//        case 15:
//        // TO DO
//        break;
//        case 16:
//        // TO DO
//      } // end of cases
//    }
//  } // end of mathSolver method
//
//  public static void recordKeeping() {
//    Scanner keyboard = new Scanner(System.in);
//    int choice = 0;
//    do {
//      showMenu2();
//      choice = enterChoice(1, 5);
//      switch (choice) {
//        case 1:
//        acceptAndSortNames();
//        break;
//        case 2:
//        // TO DO
//        break;
//        case 3:
//        // TO DO
//        break;
//        case 4:
//        // TO DO
//        break;
//      } // end of cases
//    } while (choice != 5);
//  } // end of recordKeeping method
//  public static void acceptAndSortNames() {
//    Scanner keyboard = new Scanner(System.in);
//    String[] names;
//    int n = 0;
//    System.out.print("How many names will be sorted? ");
//    n = Integer.parseInt(keyboard.nextLine());
//    names = new String[n];
//    // Populate array names
//    for (int z = 0; z < names.length; z++) {
//      System.out.print("Enter name of student " + (z + 1) + ": ");
//      names[z] = keyboard.nextLine();
//    }
//    // Sort the names array
//    balloonSortArray(names);
//    //Show elements of names array
//    showElements(names);
//  }
//  public static void miscellaneousProcesses() {
//    Scanner keyboard = new Scanner(System.in);
//    int choice = 0;
//    do {
//      showMenu3();
//      choice = enterChoice(1, 10);
//      switch (choice) {
//        case 1:
//        higherOrLower();
//        System.out.println();
//        System.out.print("press enter to continue...");
//        keyboard.nextLine();
//        break;
//        case 2:
//        // TO DO
//        break;
//        case 3:
//        // TO DO
//        break;
//        case 4:
//        // TO DO
//        break;
//        case 5:
//        // TO DO
//        break;
//        case 6:
//        insectPopulationGrowthRate();
//        System.out.println("Press enter to continue...");
//        keyboard.nextLine();
//        break;
//        case 7:
//        // TO DO
//        break;
//        case 8:
//        // TO DO
//        break;
//        case 9:
//        // TO DO
//        break;
//        case 10:
//        // TO DO
//      } // end of cases
//    } while (choice != 10);
//  } // end of miscellaneousProcesses method
//  public static String detOddEven(int number) {
//    if (number % 2 != 0)
//      return (" The number is odd ");
//    else
//      return (" The number is even ");
//  }
//  public static double getSumOfSeries(int n) {
//    double sum = 0;
//    if (n > 1 && n % 2 == 0) {
//      for (int ctr = n; ctr > 1; ctr -= 2)
//      sum += (1.0 / ctr);
//    }
//    return (sum);
//  } // end of method
//
//  public static double calcCircleArea (double n){
//
//  }
//  public static String generateMultiTable (int n, int j) {}
//  public static String getRoots (int a, int b, int c) {
//    double discriminant = b * b - 4 * a * c;
//
//    if (discriminant >= 0){ // Real Roots
//      double sqrtDiscriminant = Math.sqrt(discriminant);
//      root1 = (-b + sqrtDiscriminant) / (2 * a);
//      root2 = (-b - sqrtDiscriminant) / (2 * a);
//      System.out.println("The roots are: " + root1 + " and " + root2 + ".");
//    }else { // Imaginary Roots
//      String root1String =  -b / (2 * a) + " + (square root of (" + (-1) * discriminant + ") * i) / " + (2 * a);
//      String root2String = -b / (2 * a) + " - (square root of (" + (-1) * discriminant + ") * i) / " + (2 * a);
//      System.out.println("The imaginary roots are: " + root1String + " and " + root2String + ".");
//    }
//  }
//  public static void higherOrLower() {
//    Scanner keyboard = new Scanner(System.in);
//    Random rndNoGen = new Random(); // Random class is a facility for
//    // generating random numbers
//    int secretNo = rndNoGen.nextInt(100) + 1; // generate a random number
//    // that is in the range from 1 to 100.
//    System.out.println("I have an integer from 1 to 100.");
//    System.out.println("You have 10 chances to guess it.");
//    int guessNo = 0;
//    int guess;
//    boolean gotIt = false;
//    do {
//      System.out.print("\nGuess #" + (guessNo + 1) + ": ");
//      guess = keyboard.nextInt();
//      if (guess == secretNo) {
//        gotIt = true;
//        break; // terminate the loop immediately
//      } else {
//        if (guessNo == 10) {
//          break; // terminate the loop immediately
//        } else {
//          if (guess > secretNo) {
//            System.out.println("Try something lower.");
//          } else {
//            System.out.println("Try something higher.");
//          }
//          guessNo++;
//        }
//      }
//    } while (guessNo < 10);
//    if (gotIt) {
//      System.out.println("\nCongratulations!!!");
//      System.out.println("Got it in " + guessNo + " trial(s)!");
//    } else {
//      System.out.println("\nSorry. No more guesses left.");
//      System.out.println("The number is " + secretNo + ".");
//      System.out.println("Better luck next time.");
//    }
//    System.out.println("\nThanks for playing!!!");
//    System.out.println("Have a nice day :)!");
//  } // end of higherOrLower method
//  public static void generateFibonacciSequence(int nTerms) {
//    int first = 1, second = 1;
//    int temp;
//    int count = nTerms;
//    System.out.print("Terms: ");
//    if (nTerms == 1)
//    System.out.println(first);
//    if (nTerms == 2)
//    System.out.println(first + " , " + second);
//    if (nTerms > 2) {
//      System.out.print(first + " , " + second);
//      count = count - 2; // remaining terms to print
//      while (count > 0) {
//        temp = first;
//        first = second;
//        second = temp + second;
//        System.out.print(" , " + second);
//        count--;
//      } // end of while
//      System.out.println();
//    } // end of if nTerms > 2
//  } // end of generateFibonacciSequence method
//  public static void insectPopulationGrowthRate() {
//    Scanner keyboard = new Scanner(System.in);
//    int fSize, iSize;
//    double rateOfGrowth;
//    System.out.println("Kindly enter the following:");
//    System.out.print(" Initial population ... ");
//    iSize = keyboard.nextInt();
//    System.out.print(" Current population..... ");
//    fSize = keyboard.nextInt();
//    rateOfGrowth = (fSize - iSize) * 100.0 / iSize;
//    System.out.print("\nThe rate of growth is " + rateOfGrowth + "%");
//    System.out.println(" because (" + fSize + " - " + iSize + ") * 100 / " + iSize + " is " +
//      rateOfGrowth + "%");
//  } // end of insectPopulationGrowthRate method
//  /**
// * Displays the elements of an array
// * **/
//  public static void showElements(String[] array) {
//    for (int x = 0; x < array.length; x++)
//    System.out.println(array[x]);
//  }
//  /*
//Some basic algorithms:
//1. Linear Search(Search an item in a given list)
// Search an item from a list by starting from the first element, then second, then third an so
//on.
// - Check if the first element is the item you are searching.
// If the first element is the same as the item being searched, stop and report that the item
//is found. Otherwise, check if the second element is the item you are searching.
// If the second item is the same as the item being searched, stop and report that the item is
//found. Otherwise, check if the third element is the same as the item being search…
//2. Balloon Sort (Arrange the elements of a list)
//a. Determine which element should be in the first position:
//Swap the first element and the second element if needed.
//Then, swap the current first element and the third element if needed.
//Then, swap the current first element and the fourth element if needed.
//… Repeat the process until the last element is reached.
//By then, the first element of the list is positioned correctly.
//b. Determine which element should be in the second position:
//Swap the second element and the third element if needed.
//Swap the current second element and the fourth element if needed.
//…. Repeat the process until the last element is reach.
//By then, the second element of the list is positioned correctly.
//...and so on
//3. Selection Sort (Arrange the elements of a list)
//select a value and put it in its final place into the list
//repeat for all other values
//In more detail:
//find the smallest value in the list
//switch it with the value in the first position
//find the next smallest value in the list
//switch it with the value in the second position
//repeat until all values are in their proper places
//Swapping is the process of exchanging two values. Swapping may be a subprocess of the sorting
//process.
//Essentially, swapping requires three assignment statements
//temp = first;
//first = second;
//second = temp;
//In some cases, it is important to keep the original array. A problem/issue in programming
//theory, which is called side-effect, is the result of modifying the value of a variable (e.g. an
//array variable). Side-effect is an issue because another module of the program may be using the
//variable(e.g. the array) under the assumption that the value of the variable(e.g. the elements
//of the array) is/are in some original form. When the value of the variable is modified, the
//other module may fail in its purpose.
//If sorting must be done with an array, create a copy of the array and it is the copy that you
//should modify. To facility the process of sorting arrays when there is a need to keep the
//original array, a method for making a copy of an array may help. The following methods are
//examples of methods for copying arrays.
//4. Binary Search (Search an item in a given list)
// Assume that the list is sorted in ascending order, start the search at the middle cell.
// If the middle element is the one you are looking for, stop and declare that the item is found.
// Otherwise, drop half of the list by comparing the item being searched with the middle
//element.
// If the middle element is greater than the item being search, this means the item being
//search could be at the left of the middle element.
// Then, do the search in the first half of the list (forget about the second half)
// If the middle element is less than the item being search, this means the item being search
//could be at the right of the middle element.
// Then, do the search in the second half of the list (forget about the first half)
// Again, start the search at the middle cell of the list that remained after dropping half of the
//list. Do the process repeatedly until the item is found or until there is no more list to be
//halved.
//*/
//  /**
// * Sorts a given array of int following the ascending order
// */
//  public static void balloonSortArray1(int[] given) {
//    for (int x = 0; x < given.length - 1; x++) {
//      for (int y = x + 1; y < given.length; y++) {
//        if (given[x] > given[y]) {
//          int temp = given[x];
//          given[x] = given[y];
//          given[y] = temp;
//        } // end of if
//      } // end of second for
//    } // end of first for
//  } // end of method
//  /**
// * Sorts a given array of String following lexicographic ordering (i.e. alphabetical ordering)
// */
//  public static void balloonSortArray2(String[] given) {
//    for (int x = 0; x < given.length - 1; x++) {
//      for (int y = x + 1; y < given.length; y++) {
//        if (given[x].compareTo(given[y]) > 0) {
//          String temp = given[x];
//          given[x] = given[y];
//          given[y] = temp;
//        } // end of if
//      } // end of second for
//    } // end of first for
//  } // end of method
//  /**
// * Returns true if searchKey is in a given array of int.
// */
//  public static boolean linearSearch1(int[] array, int searchKey) {
//    boolean r = false;
//    for (int index = 0; index < array.length && r == false; index++) {
//      if (array[index] == searchKey)
//      r = true;
//    }
//    return r;
//  }
//  /**
// * Returns true if searchKey is in a given array of int.
// */
//  public static boolean linearSearch2(int[] array, int searchKey) {
//    for (int index = 0; index < array.length; index++) {
//      if (array[index] == searchKey)
//      return true;
//    }
//    return false;
//  }
//  /**
// * Returns true if searchKey is in a given array of String.
// */
//  public static boolean linearSearch3(String[] array, String searchKey) {
//    boolean r = false;
//    for (int index = 0; index < array.length && r == false; index++) {
//      if (array[index].equalsIgnoreCase(searchKey))
//      r = true;
//    }
//    return r;
//  }
//  /**
// * Returns true if searchKey is in a given array of String.
// */
//  public static boolean linearSearch4(String[] array, String searchKey) {
//    for (int index = 0; index < array.length; index++) {
//      if (array[index].equalsIgnoreCase(searchKey))
//      return true;
//    }
//    return false;
//  }
//  /**
// * Returns the index of the first cell of an array containing a searchKey if the searchKey is
//in the array, else returns -1.
// */
//  public static int linearSearch5(int[] array, int searchKey) {
//    for (int index = 0; index < array.length; index++) {
//      if (array[index] == searchKey)
//      return index;
//    }
//    return -1;
//  }
//  public static int[] copyIntegerArray(int[] array1) {
//    int[] copied = new int[array1.length];
//    for (int index = 0; index < array1.length; index++) {
//      copied[index] = array1[index];
//    }
//    return copied;
//  } // end of copyIntegerArray method
//  public static String[] copyStringArray(String[] array1) {
//    String[] copied = new String[array1.length];
//    for (int index = 0; index < array1.length; index++) {
//      copied[index] = new String(array1[index]);
//    }
//    return copied;
//  } // copy of copyStringArray method
//  //The following methods apply the Selection Sort algorithm.
//  /**
// * Returns a sorted version of a given array of int following the ascending order
// */
//  public static int[] sortIntegerArray(int[] given) {
//    int minIndex = 0;
//    int[] sorted = copyIntegerArray(given);
//    int temp = 0;
//    for (int x = 0; x < sorted.length - 1; x++) {
//      minIndex = x;
//      for (int y = x + 1; y < sorted.length; y++)
//      if (sorted[minIndex] > sorted[y])
//      minIndex = y;
//      if (minIndex != x) {
//        temp = sorted[x];
//        sorted[x] = sorted[minIndex];
//        sorted[minIndex] = temp;
//      }
//    }
//    return sorted;
//  } // end of sortIntegerArray
//  /**
// * Returns a sorted version of a given array of Strings following lexicographic ordering
// */
//  public static String[] sortStringArray(String[] given) {
//    int minIndex = 0;
//    String[] sorted = copyStringArray(given);
//    String temp = "";
//    for (int x = 0; x < sorted.length - 1; x++) {
//      minIndex = x;
//      for (int y = x + 1; y < sorted.length; y++)
//      if (sorted[y].compareToIgnoreCase(sorted[minIndex]) < 0)
//      minIndex = y;
//      if (minIndex != x) {
//        temp = sorted[x];
//        sorted[x] = sorted[minIndex];
//        sorted[minIndex] = temp;
//      }
//    }
//    return sorted;
//  } // end of sortStringArray
//  /**
// * This method implements the Binary Search algorithm.
// * Assuming that grades is a sorted array following an increasing order, this methods
// * returns true if key is in the array.
// */
//  public static boolean binarySearch(int[] grades, int key) {
//    boolean r = false;
//    int lowLimit = 0;
//    int upLimit = grades.length - 1;
//    int mid = (lowLimit + upLimit) / 2;
//    while (lowLimit < upLimit && !r) {
//      mid = (lowLimit + upLimit) / 2;
//      if (grades[mid] == key)
//      r = true;
//      else if (grades[mid] < key)
//      lowLimit = mid + 1;
//      else
//      upLimit = mid - 1;
//    }
//    return r;
//  }
//  /**
// Let’s the user answer series of yes/no questions. Try to search for a health declaration form
//that is being used during this pandemic days. A message ‘It is best for you to see a
//doctor’ should be printed if the user gives at one yes answer
//*/
//  public static void selfEvaluation( ) {
//    // appropriate code should follow
//
//  }
//} // end class
