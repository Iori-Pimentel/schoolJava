import java.util.*;
import java.util.Random;
import java.lang.*;
import java.math.*;

public class Test {

  public static String title;
  public static String description;
  public static String[] questions;
  public static String[] calculatedAnswer;
  public static Scanner keyboard = new Scanner(System.in);
  public static Random rand = new Random();
  public static int leftTextCount;
  public static int rightTextCount;
  public static int menuWidth;
  public static int menuHeight;
  public static int lPad;
  public static int tPad;
  public static boolean doWrapBool = true;
  public static String yellowFG = "\033[33m";
  public static String redFG = "\033[31m";
  public static String blueFG = "\033[34m";
  public static String blackBG = "\033[40m";
  public static String greenFG = "\033[32m";
  public static String defaultFG = "\033[39m";
  public static String defaultBG = "\033[49m";
  public static String saveCursor = "\033[s";
  public static String updateCursor = "\033[u";

  public static void main(String[] args) {
    showIntroduction();

    while (true) {
      showMainMenu();
    }
  }

  public static void showIntroduction() {
    menuWidth = 60;

    System.out.print("\033[H\033[2J"); // Clear Screen

    String[] startText = {
        "Saint Louis University University University University University University",
        "Baguio City ",
        "---------------------------------------------",
        "",
        "Iori Z. Pimentel",
        "Programmer"
    };

    menuHeight = getLineCount(startText) + 1;
    createMenu(menuWidth, menuHeight, 5, 5);
    print("College of Information and Computing Sciences", 't');
    print(startText, 'd');
    System.out.println("\033[2F");
    waitEnter();
  }

  public static void showMainMenu() {
    menuWidth = 50;
    String[] options = {
        "Math Routines",
        "Recording Routines",
        "Miscellaneous Routines",
        "Exit"
    };

    int choice = getChoice(options, "Main Menu");

    switch (choice) {
      case 1:
        showMathMenu();
        break;
      case 2:
        showRecordMenu();
        break;
      case 3:
        showMiscMenu();
        break;
      case 4:
        closeProgram();
        break;
    }
  }

  public static void closeProgram() {
    System.out.print("\033[H\033[2J"); // Clear Screen
    System.exit(0);

  }

  public static int getChoice(String[] options, String title) {
    menuHeight = options.length + 4;
    createMenu(menuWidth, menuHeight, 5, 5);

    print(title, 't');

    for (int i = 0; i < options.length; i++) {
      options[i] = String.format("[%d] ", i + 1) + options[i];

      if (i < 9 && options.length > 9)
        options[i] = " " + options[i];
    }

    print(options, 'd');
    print("", 'd');
    print("Choice: ", 'i');

    while (true) {
      try {
        int choice = Integer.parseInt(keyboard.nextLine());

        if (choice < 1 || choice > options.length) {
          print("Invalid Choice", 'e');
        }
        else {
          System.out.print("\033[H\033[2J"); // Clear Screen
          return choice;
        }
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
      }
    }
  }

  public static void showMathMenu() {
    menuWidth = 60;

    String[] options = {
        "Determine whether an integer is odd or even",
        "Determine sum of a series",
        "Determine the factors of a number",
        "Determine if a number is prime",
        "Determine the area of a circle",
        "Determine the area of a square",
        "Determine the area of a triangle",
        "Determine the area of a rectangle",
        "Determine the area of a trapezoid",
        "Determine the area of a parallelogram",
        "Determine if an integer is a perfect number",
        "Generate a multiplication table",
        "Determine the roots of a quadratic equation",
        "Generate a Fibonacci Sequence",
        "Generate a Pascal's Triangle",
        "Back to Main Menu"
    };

    int choice = getChoice(options, "Math Routines [Sub Menu]");

    switch (choice) {
      case 1:
        mathRoutine1();
        calculatedAnswer = mathIsEven(integerInputMenu());
        title = "Odd or Even";
        break;
      case 2:
        mathRoutine2();
        calculatedAnswer = mathSumOfSeries(integerInputMenu());
        title = "Sum of Series";
        break;
      case 3:
        mathRoutine3();
        calculatedAnswer = mathFactors(integerInputMenu());
        title = "Factors of a Number";
        break;
      case 4:
        mathRoutine4();
        calculatedAnswer = mathIsPrime(integerInputMenu());
        title = "Prime or Not";
        break;
      case 5:
        mathRoutine5();
        calculatedAnswer = mathCircleArea(doubleInputMenu());
        title = "Area of Circle";
        break;
      case 6:
        mathRoutine6();
        calculatedAnswer = mathSquareArea(doubleInputMenu());
        title = "Area of Square";
        break;
      case 7:
        mathRoutine7();
        calculatedAnswer = mathTriangleArea(doubleInputMenu());
        title = "Area of Triangle";
        break;
      case 8:
        mathRoutine8();
        calculatedAnswer = mathRectangleArea(doubleInputMenu());
        title = "Area of Rectangle";
        break;
      case 9:
        mathRoutine9();
        calculatedAnswer = mathTrapezoidArea(doubleInputMenu());
        title = "Area of Trapezoid";
        break;
      case 10:
        mathRoutine10();
        calculatedAnswer = mathParallelogramArea(doubleInputMenu());
        title = "Area of Parallelogram";
        break;
      case 11:
        mathRoutine11();
        calculatedAnswer = mathPerfectNumber(integerInputMenu());
        title = "Perfect Number";
        break;
      case 12:
        mathRoutine12();
        calculatedAnswer = mathMultiTable(integerInputMenu());
        title = "Multiplication Table";
        break;
      case 13:
        mathRoutine13();
        calculatedAnswer = mathRoots(doubleInputMenu());
        title = "Roots of Quadratic Equation";
        break;
      case 14:
        mathRoutine14();
        calculatedAnswer = mathFibonacci(integerInputMenu());
        title = "Fibonacci Sequence";
        break;
      case 15:
        mathRoutine15();
        calculatedAnswer = mathPascalTriangle(integerInputMenu());
        title = "Pascal Triangle";
        break;
      case 16:
        System.out.print("\033[H\033[2J"); // Clear Screen
        return;
    }

    showAnswer();
  }

  public static void showRecordMenu() {
    menuWidth = 60;
    String[] options = {
        "Sort list of students",
        "Sort list of Salesmen",
        "Sort names and grades according to name",
        "Sort names and grades according to grade",
        "Back to Main Menu"
    };

    int choice = getChoice(options, "Recording Routines [Sub Menu]");

    String[] names;
    int[] grades;
    doWrapBool = false;
    menuWidth = 80;
    questions = new String[] {
        "Amount to Sort: | Write the Intended Value"
    };

    switch (choice) {
      case 1:
        recordingRoutine1();
        names = stringInputMenu();
        selectionSort(names);
        calculatedAnswer = names;
        title = "Sort Student Names in Alphabetical Order";
        break;
      case 2:
        recordingRoutine2();
        names = stringInputMenu();
        selectionSort(names);
        calculatedAnswer = names;
        title = "Sort Salesmen Names in Alphabetical Order";
        break;
      case 3:
        recordingRoutine3();
        names = stringInputMenu();
        grades = gradeinputMenu(names);
        selectionSort(names, grades);
        formatNamesGrades(names, grades);
        title = "`Alphabetical Order";
        break;
      case 4:
        recordingRoutine4();
        names = stringInputMenu();
        grades = gradeinputMenu(names);
        selectionSort(grades, names);
        formatNamesGrades(names, grades);
        title = "Ranked by Grades";
        break;
      case 5:
        System.out.print("\033[H\033[2J"); // Clear Screen
        return;
    }
    showAnswer();
  }

  public static void formatNamesGrades(String[] names, int[] grades) {
    calculatedAnswer = new String[names.length + 2];
    int namesLength = getLongestRow(names);

    int leftPad = namesLength + 5;
    int rightPad = 9;
    calculatedAnswer[0] = center("  [Names]", leftPad);
    calculatedAnswer[1] = "└" + calculatedAnswer[0].replaceAll(".", "─");
    calculatedAnswer[0] += "  [Grades]";
    calculatedAnswer[1] += "┼────────┘";
    for (int i = 0; i < names.length; i++) {
      calculatedAnswer[i + 2] = " " + center(names[i], leftPad);
      calculatedAnswer[i + 2] += "│" + center(grades[i], rightPad);
    }
  }

  public static int[] gradeinputMenu(String[] names) {
    int count = names.length;

    questions = new String[count];

    for (int i = 0; i < count; i++) {
      questions[i] = String.format("[%s] Grade: ", names[i]);
      questions[i] += "| 0 < Grade < 100";
    }

    for (int i = 0; i < count; i++) {
      System.out.print("\033[1A");
      System.out.print("\033[s");
      clearComment("√", ".");
      System.out.print("\033[u");
    }

    return inputRangeInt(0, 100);
  }

  public static void selectionSort(String[] sortedNames) {

    for (int i = 0; i < sortedNames.length - 1; i++) { // Selection Sort of Strings
      int minIndex = i;
      for (int j = i + 1; j < sortedNames.length; j++) {
        if (sortedNames[j].compareToIgnoreCase(sortedNames[minIndex]) < 0) {
          minIndex = j;
        }
      }
      String temp = sortedNames[i];
      sortedNames[i] = sortedNames[minIndex];
      sortedNames[minIndex] = temp;
    }
  }

  public static void selectionSort(String[] sortedNames, int[] text) {
    for (int i = 0; i < sortedNames.length - 1; i++) { // Selection Sort of Strings
      int minIndex = i;
      for (int j = i + 1; j < sortedNames.length; j++) {
        if (sortedNames[j].compareToIgnoreCase(sortedNames[minIndex]) < 0) {
          minIndex = j;
        }
      }
      String temp = sortedNames[i];
      sortedNames[i] = sortedNames[minIndex];
      sortedNames[minIndex] = temp;

      int temp2 = text[i];
      text[i] = text[minIndex];
      text[minIndex] = temp2;

    }
  }

  public static void selectionSort(int[] text, String[] sortedNames) {
    for (int i = 0; i < text.length - 1; i++) { // Selection Sort of Strings
      int minIndex = i;
      for (int j = i + 1; j < text.length; j++) {
        if (text[j] > text[minIndex]) {
          minIndex = j;
        }
      }
      String temp = sortedNames[i];
      sortedNames[i] = sortedNames[minIndex];
      sortedNames[minIndex] = temp;

      int temp2 = text[i];
      text[i] = text[minIndex];
      text[minIndex] = temp2;

    }
  }

  public static void recordingRoutine1() {
    title = "Recording Routines [Record Routine 1]";
    description = "Routine to sort list of names of Students";
  }

  public static void recordingRoutine2() {
    title = "Recording Routines [Record Routine 2]";
    description = "Routine to sort list of names of Salesmen";
  }

  public static void recordingRoutine3() {
    title = "Recording Routines [Record Routine 3]";
    description = "Routine to sort list of [names] and grades";
  }

  public static void recordingRoutine4() {
    title = "Recording Routines [Record Routine 4]";
    description = "Routine to sort list of names and [grades]";
  }

  public static void showMiscMenu() {
    String[] options = {
        "Number Guessing Game",
        "Covid19 Self-Assessment Procedure ",
        "Bills distribution of an amount of Money",
        "Interest of Money Invested ",
        "Income Tax Computation",
        "Insect Population Growth Rate",
        "Water Bill computaion.",
        "Electric Bill computation.",
        "Mobile Phone Load Balance Computation.",
        "Back to Main Menu"
    };

    int choice = getChoice(options, "Miscellaneous Routines [Sub Menu]");

    menuWidth = 80;
    switch (choice) {
      case 1:
        miscRoutine1();
        int randomInt = rand.nextInt(100);
        inputCorrectGuess(randomInt);
        break;
      // case 2:
      // miscRoutine2(); break;
      // case 3:
      // miscRoutine3(); break;
      // case 4:
      // miscRoutine4(); break;
      // case 5:
      // miscRoutine5(); break;
      // case 6:
      // miscRoutine6(); break;
      case 7:
        miscRoutine7();
        waterBill();
        break;
      // case 8:
      // miscRoutine8(); break;
      // case 9:
      // miscRoutine9(); break;
      // case 10:
      // miscRoutine10(); break;
    }
  }

  public static void miscRoutine1() {
    title = "Miscellaneous Routines [Miscellaneous Routine 1]";
    description = "Routine to play a Number Guessing Game";
  }

  public static void miscRoutine7() {
    title = "Miscellaneous Routines [Miscellaneous Routine 7]";
    description = "Routine to Calculate Water Bill";
  }

  public static void waterBill() {
    title = "Water Bill";
    description = "Give";

    createMenu(menuWidth, 10, 5, 1);
    print(title, 't');
    print(description, 'd');

    String consumer; // to hold name of consumer
    char cType; // to hold type of consumer

    int nCMUsed; // to hold number of cubic meters of water used
    int minCMResidential = 12; // to hold cut-off for minimum Bill for residential consumers
    double minBillResidential = 180.00; // minimum bill for <= 12 Cubic Meters used
    float rateResidential = 30.00F; // cost of 1 Cubic Meter above the min. consumption
    int minCMCommercial = 30; /* to hold cut-off for minimum Bill for commercial consumers */
    double minBillCommercial = 600.00; // minimum bill for <= 20Cubic Meters used
    float rateCommercial = 50.00F; /* cost of 1 Cubic Meter above the min. consumption for commercial consumers */
    double amountDue = 0.0; // to hold the amount due

    print("Enter the consumer's name: ", 'i');
    consumer = inputValidName();

    int previousReading = inputRangeInt("Enter the meter reading last month: | Must be positive", 0);
    int presentReading = inputRangeInt("Enter the meter reading this month: | Must be grater than last month", previousReading);

    nCMUsed = presentReading - previousReading;

    printLeftRight( "Enter the classification as a consumer: | [C]ommercial or [R]esidential");

    while (true) {
      cType = keyboard.nextLine().toLowerCase().charAt(0);

      if (!(cType == 'r' || cType == 'c')) {
        print("[C]ommercial and [R]esidential", 'e');
      }
      else break;
    }

    switch (cType) {
      case 'r':
      amountDue = minBillResidential;
      if (nCMUsed > minCMResidential) {
        amountDue += (nCMUsed - minCMResidential) * rateResidential;
      }
      break;
      case 'c':
      amountDue = minBillCommercial;
      if (nCMUsed > minCMCommercial) {
        amountDue += (nCMUsed - minCMCommercial) * rateCommercial;
      }
      break;
    }

    createMenu(menuWidth, 7, 5, 1);
    print("Water Bill Receipt", 't');
    calculatedAnswer = new String[] {
      String.format("Consumer Name: [%s]", consumer),
      String.format("Last Month's Reading: [%d]", previousReading),
      String.format("Current Month's Reading: [%d]", presentReading),
      String.format("Consumption this Month: [%d]", nCMUsed),
      String.format("Amount Due: [%.2f]", amountDue)
    };
    print(calculatedAnswer, 'a');
} // end of main

  public static void showDescription() {
    menuHeight = getLineCount(description) + questions.length + 2;
    createMenu(menuWidth, menuHeight, 5, 1);

    print(title, 't');
    print(description, 'd');
  }

  public static int[] integerInputMenu() {
    showDescription();
    System.out.print("\033[1B");
    int[] userInputs = inputPositiveInt(questions);
    return userInputs;
  }

  public static double[] doubleInputMenu() {
    showDescription();
    System.out.print("\033[1B");
    double[] userInputs = inputPositiveDouble(questions);
    return userInputs;
  }

  public static String[] stringInputMenu() {
    showDescription();
    System.out.print("\033[1B");
    int count = inputRangeInt(questions[0], 1);
    String[] userInputs = new String[count];

    menuHeight = count + 1;
    createMenu(menuWidth, menuHeight, 5, 2);
    print(title, 't');
    for (int i = 0; i < count; i++) {
      printLeftRight("Name: | Accepts only valid names");
      userInputs[i] = inputValidName();
    }

    return userInputs;
  }

  public static String inputValidName() {
    while (true) {
      String name = keyboard.nextLine();
      clearComment(name, "√");

      if (name.matches("[ ]*")) {
        print("No Empty Names", 'e');
        continue;
      }

      String startErrorMsg = "Invalid Characters: ";
      String errorMsg = startErrorMsg;
      String removedLeading = name.stripLeading();
      String removedTrailing = name.stripTrailing();

      if (!removedLeading.equals(name)) {
        errorMsg += "[Leading Space]";
      }

      if (!removedTrailing.equals(name)) {
        errorMsg += "[Trailing Space]";
      }

      String removedValid = name.replaceAll("[a-zA-Z. ]", "");
      if (!removedValid.isEmpty()) {
        errorMsg += String.format("[%s]", removedValid);
      }

      if (!errorMsg.equals(startErrorMsg)) {
        print(errorMsg, 'e');
      } else {
        return name;
      }

    }
  }

  public static void clearComment(int toRemove, String toAdd) {
    clearComment(String.valueOf(toRemove), toAdd);
  }

  public static void clearComment(double toRemove, String toAdd) {
    clearComment(String.valueOf(toRemove), toAdd);
  }

  public static void clearComment(String toRemove, String toAdd) {
    int inputLength = toRemove.length();
    int padCount = menuWidth - (leftTextCount + inputLength + 3);

    print(String.format("%" + (padCount) + "s", toAdd), 'c');
    System.out.print("\033[u\033[1B");
  }

  public static void showAnswer() {
    menuWidth = 50;

    if (doWrapBool) {
      int lineCount = getLineCount(calculatedAnswer);
      menuHeight = lineCount + 2;
    } else {
      menuHeight = calculatedAnswer.length + 2;
      int colCount = getLongestRow(calculatedAnswer) + 4;
      menuWidth = Math.max(menuWidth, colCount);

      doWrapBool = !doWrapBool;
    }

    createMenu(menuWidth, menuHeight, 5, 1);
    print(title, 't');
    print(calculatedAnswer, 'a');
    waitEnter();
  }

  public static void mathRoutine1() {
    menuWidth = 40;

    title = "Math Routines [Math Routine 1]";
    description = "Routine to determine if a given number is even or odd.";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine2() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 2]";
    description = "Routine to determine the sum of a series";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine3() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 3]";
    description = "Routine to determine the factors of an integer";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine4() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 4]";
    description = "Routine to determine if a number is prime";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine5() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 5]";
    description = "Routine to calculate the area of a " +
        "circle given a radius";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine6() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 6]";
    description = "Routine to calculate the area of a " +
        "sqaure given the side length";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine7() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 7]";
    description = "Routine to calculate the area of a " +
        "triangle given the base length and height";

    questions = new String[] {
        "give: | integer output",
        "give: | integer output"
    };
  }

  public static void mathRoutine8() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 8]";
    description = "Routine to calculate the area of a " +
        "rectangle given the width and height";

    questions = new String[] {
        "give: | integer output",
        "give: | integer output"
    };
  }

  public static void mathRoutine9() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 9]";
    description = "Routine to calculate the area of a " +
        "trapezoid given two of the bases and the height";

    questions = new String[] {
        "give: | integer output",
        "give: | integer output",
        "give: | integer output"
    };
  }

  public static void mathRoutine10() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 10]";
    description = "Routine to calculate the area of a " +
        "parallelogram given the base and height";

    questions = new String[] {
        "give: | integer output",
        "give: | integer output"
    };
  }

  public static void mathRoutine11() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 11]";
    description = "Routine to determine if a number is a perfect number";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine12() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 12]";
    description = "Routine to create a Multiplication Table of a given size";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine13() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 13]";
    description = "Routine to determine the roots given the three values";

    questions = new String[] {
        "Give: | Integer Output",
        "Give: | Integer Output",
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine14() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 14]";
    description = "Create a Fibonacci Sequence given " +
        "the amount to create";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static void mathRoutine15() {
    menuWidth = 40;
    title = "Math Routines [Math Routine 15]";
    description = "Create a Pascal Triangle given the size";

    questions = new String[] {
        "Give: | Integer Output"
    };
  }

  public static String[] mathIsEven(int[] inputs) {
    int number = inputs[0];
    String parity = (number % 2 == 1) ? "Odd" : "Even";

    String[] textArr = {
        String.format("%d is %s", number, parity)
    };
    return textArr;
  }

  public static String[] mathSumOfSeries(int[] inputs) {
    int number = inputs[0];

    int sum = number * (number - 1) / 2;

    String[] textArr = {
        String.format("The sum of the series [%d] is %d", number, sum)
    };
    return textArr;
  }

  public static String[] mathFactors(int[] inputs) {
    int number = inputs[0];
    String factors = "1";

    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        factors += ", " + i;
      }
    }

    if (number != 1)
      factors += " and " + number;

    String[] textArr = {
        String.format("The factors of [%d] are:", number),
        factors
    };

    // String[] textArr = wrapLine(factors);
    return textArr;
  }

  public static String[] mathIsPrime(int[] inputs) {
    int number = inputs[0];

    boolean isPrimeBool = true;
    for (int i = 2; i <= number / 2; ++i) {
      if (number % i == 0) { // Not Prime
        isPrimeBool = false;
        break;
      }
    }

    String isPrimeText = isPrimeBool ? "a prime number" : "not a prime number";
    String[] textArr = {
        String.format("%d is %s", number, isPrimeText)
    };
    return textArr;
  }

  public static String[] mathCircleArea(double[] inputs) {
    double radius = inputs[0];
    double areaCircle = Math.PI * radius * radius;

    String[] textArr = {
        String.format("The Area of a circle with [%.2f] radius is %.2f", radius, areaCircle)
    };

    return textArr;
  }

  public static String[] mathSquareArea(double[] inputs) {
    double sideLength = inputs[0];
    double areaSquare = sideLength * sideLength;

    String[] textArr = {
        String.format("The Area of a square with [%.2f] side length is %.2f", sideLength, areaSquare)
    };

    return textArr;
  }

  public static String[] mathTriangleArea(double[] inputs) {
    double base = inputs[0], height = inputs[1];
    double areaTriangle = (base * height) / 2;

    String[] textArr = {
        String.format("The Area of a triangle with [%.2f] base and [%.2f] height is %.2f", base, height, areaTriangle)
    };

    return textArr;
  }

  public static String[] mathRectangleArea(double[] inputs) {
    double width = inputs[0], height = inputs[1];
    double areaRectangle = width * height;

    String[] textArr = {
        String.format("The Area of a rectangle with [%.2f] width and [%.2f] height is %.2f", width, height,
            areaRectangle)
    };

    return textArr;
  }

  public static String[] mathTrapezoidArea(double[] inputs) {
    double baseA = inputs[0], baseB = inputs[1], height = inputs[2];
    double areaTrapezoid = 0.5 * (baseA + baseB) * height;

    String[] textArr = {
        String.format("The Area of a trapezoid with [%.2f] base A, [%.2f] base B and [%.2f] height is %.2f", baseA,
            baseB, height, areaTrapezoid)
    };

    return textArr;
  }

  public static String[] mathParallelogramArea(double[] inputs) {
    double base = inputs[0], height = inputs[1];
    double areaParallelogram = base * height;

    String[] textArr = {
        String.format("The Area of a rectangle with [%.2f] width and [%.2f] height is %.2f", base, height,
            areaParallelogram)
    };

    return textArr;
  }

  public static String[] mathPerfectNumber(int[] inputs) {
    int number = inputs[0];

    int sum = 0;
    for (int i = 1; i <= number / 2; i++) {
      if (number % i == 0) {
        sum += i;
      }
    }

    String isPerfectText;
    if (sum == number) {
      isPerfectText = " a perfect number";
    } else {
      isPerfectText = "not a perfect number";
    }

    String[] textArr = {
        String.format("%d is %s", number, isPerfectText)
    };

    return textArr;
  }

  public static String[] mathMultiTable(int[] inputs) {
    int size = inputs[0];
    doWrapBool = false;

    String[] table = new String[size];
    Arrays.fill(table, "");

    int length = String.valueOf(size * size).length();
    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        table[i - 1] += String.format("%" + (length + 2) + "d", i * j);
      }
    }

    return table;
  }

  public static String[] mathRoots(double[] inputs) {
    double a = inputs[0], b = inputs[1], c = inputs[2];
    double discriminant = b * b - 4 * a * c;

    if (discriminant >= 0) { // Real Roots
      double sqrtDiscriminant = Math.sqrt(discriminant);

      double root1 = (-b + sqrtDiscriminant) / (2 * a);
      double root2 = (-b - sqrtDiscriminant) / (2 * a);

      String[] textArr = {
          String.format("[%.2f]a, [%.2f]b and [%.2f]c have reals roots:", a, b, c),
          String.format(">\t%.2f", root1),
          String.format(">\t%.2f", root2)
      };
      return textArr;
    } else { // Imaginary Roots
      String root1Top = -b + " + sqrt(" + Math.abs(discriminant) + ") * i";
      String root2Top = -b + " - sqrt(" + Math.abs(discriminant) + ") * i";
      String divider = String.format("%" + root1Top.length() + "s", "").replace(" ", "─");
      String rootBottom = String.format("%.2f", 2 * a);
      rootBottom = String.format("%" + ((root1Top.length() + rootBottom.length()) / 2) + "s", rootBottom);

      String[] textArr = {
          String.format("[%.2f]a, [%.2f]b and [%.2f]c have Imaginary roots:", a, b, c),
          "",
          root1Top, divider, rootBottom,
          "", " and", "",
          root2Top, divider, rootBottom
      };
      return textArr;
    }

  }

  public static String[] mathFibonacci(int[] inputs) {
    int number = inputs[0];
    BigInteger firstTerm = BigInteger.ONE;
    BigInteger secondTerm = BigInteger.ONE;
    BigInteger nextTerm = BigInteger.ONE;

    String sequence = "1";
    for (int i = 1; i < number - 1; ++i) {
      sequence += ", " + secondTerm;

      nextTerm = firstTerm.add(secondTerm);
      firstTerm = secondTerm;
      secondTerm = nextTerm;
    }

    if (number != 1)
      sequence += " and " + nextTerm;

    String[] textArr = {
        String.format("The Fibonacci sequence with [%d] units are:", number),
        sequence
    };

    return textArr;
  }

  public static String[] mathPascalTriangle(int[] inputs) {
    int size = inputs[0];
    doWrapBool = false;

    String[] table = new String[size];
    Arrays.fill(table, "");

    for (int i = 0; i < size; i++) {
      int num = 1;

      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          table[i] = String.format("%" + ((size - i) * 3) + "s", "");
        }
        table[i] += String.format("%-6d", num);
        num = num * (i - j) / (j + 1);
      }
    }

    return table;
  }

  public static void waitEnter() {
    String enter = "Press Enter to Continue...";
    int start = lPad + (menuWidth - enter.length()) - 5;

    String text =
        String.format("\033[%dC", start) +
        blackBG +
        enter +
        defaultBG;

    System.out.print(text);
    keyboard.nextLine();
    System.out.print("\033[H\033[2J"); // Clear Screen
  }

  public static void createMenu(int widLen, int heiLen, int topPad, int leftPad) {
    menuWidth = widLen;
    menuHeight = heiLen;
    lPad = leftPad;
    tPad = topPad;
    String space = String.format("%" + widLen + "s", "");
    String pad = String.format("%" + leftPad + "s", "");
    String row = space.replace(" ", "─");
    String menuBorder = "";

    for (int i = 0; i < topPad; i++) {
      menuBorder += "\n";
    }
    menuBorder += "\033[1G" + // Cursor to Column 1
        String.format("\033[%dC", leftPad) +
        String.format("┌%s┐\n", row);

    for (int i = 0; i < heiLen; i++) {
      menuBorder += String.format("%s│%s│", pad, space);
      menuBorder += "\n";
    }

    menuBorder += String.format("%s└%s┘", pad, row);
    menuBorder += String.format("\033[%dD", widLen + 2);
    menuBorder += String.format("\033[%dA", heiLen + 1);

    System.out.print(menuBorder);
  }

  public static int[] inputPositiveInt(String[] questions) {
    int[] answers = new int[questions.length];
    int answerCount = 0;

    for (int i = 0; i < answers.length; i++) {
      answers[i] = inputRangeInt(questions[0], 0);
    }

    return answers;
  }

  public static int inputRangeInt(String question, int min) {
    printLeftRight(question);

    while (true) {
      try {
        int num = Integer.parseInt(keyboard.nextLine());
        clearComment(num, "√");
        if (num <= min) {
          print("Value must be greater than " + "[" + min + "]", 'e');
        } else {
          return num;
        }
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
      }
    }
  }

  public static int inputRangeInt(String question, int min, int max) {
    printLeftRight(question);

    while (true) {
      try {
        int num = Integer.parseInt(keyboard.nextLine());
        clearComment(num, "√");
        if (num <= min) {
          print("Value must be greater than " + "[" + min + "]", 'e');
        } else if (num >= max){
          print("Value must be less than " + "[" + max + "]", 'e');
        } else {
          return num;
        }
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
      }
    }
  }

  public static int[] inputRangeInt(int min, int max) {
    int[] answers = new int[questions.length];
    int answerCount = 0;

    for (int i = 0; i < answers.length; i++) {
      answers[i] = inputRangeInt(questions[i], min, max);
    }

    return answers;
  }

  public static String inputCorrectGuess(int randomInt) {
    createMenu(menuWidth, menuHeight, 5, 1);
    print("Number Guessing Game", 't');
    String answers = "";
    printLeftRight("Guess: | Start the answer");

    while (true) {
      try {
        int num = Integer.parseInt(keyboard.nextLine());
        clearComment(num, "√");

        answers += num + " ";
        if (num < randomInt) {
          print("Answer must be bigger than [" + num + "]", 'e');
        } else if (num > randomInt){
          print("Answer must be smaller than [" + num + "]", 'e');
        } else {
          break;
        }
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
      }
    }

    return answers;
  }


  public static double[] inputPositiveDouble(String[] questions) {
    double[] answers = new double[questions.length];
    int answerCount = 0;

    for (String question : questions) {
      printLeftRight(question);

      while (true) {
        try {
          double num = Double.parseDouble(keyboard.nextLine());
          clearComment(num, "√");
          if (num < 0) {
            print("Value must be greater than 0", 'e');
          } else {
            answers[answerCount] = num;
            answerCount++;
            break;
          }
        } catch (NumberFormatException e) {
          print("Try Again", 'e');
        }
      }
    }

    return answers;
  }

  public static void printLeftRight(String question) {
    String[] content = question.split("[|] ", 2);
    String leftSide = content[0];
    String rightSide = content[1];

    print(leftSide, 'i');
    print(rightSide, 'c');
  }

  public static void print(String[] textArr, char type) {
    for (String text : textArr) {
      print(text, type);
    }
    System.out.print("\033[1B");
  }

  public static void print(String text, char type) {
    String[] textArr = wrapLine(text);
    for (String text2 : textArr) {
      printUtil(text2, type);
    }
    // printUtil(text, type); // Text must be wrapped already
  }

  public static void printUtil(String text, char type) {
    String printValue = "";
    int padCount;
    String color = "";

    switch (type) {
      case 't':
        printValue += "\033[2C";
        printValue += saveCursor;
        break;
      case 'i':
      case 'd':
      case 'a':
        leftTextCount = text.length();
        printValue += saveCursor;
        break;

      case 'c':
        rightTextCount = text.length();
        padCount = menuWidth - rightTextCount - leftTextCount - 2;
        printValue += updateCursor;
        printValue += "\033[" + (leftTextCount + padCount)+ "C";
        break;
      case 'e':
        rightTextCount = text.length();
        padCount = menuWidth - rightTextCount - leftTextCount - 2;
        printValue += updateCursor;
        printValue += "\033[" + leftTextCount + "C";
        printValue += String.format("%" + padCount + "s", "");
        break;
    }


    switch (type) {
      case 't':
        printValue += "\033[2C";
        color = yellowFG;
        break;
      case 'i':
        color = blueFG;
        break;
      case 'a':
        color = greenFG;
        break;
      case 'c':
        color = greenFG;
        break;
      case 'e':
        color = redFG;
        break;
    }


    if (text.indexOf("[") != -1) {
      String regex = "(\\[)(.+?)(\\])";
      text = text.replaceAll(regex, "[" + defaultFG + "$2" + color + "]");
    }

    printValue += color;
    printValue += text;

    switch (type) {
      case 't':
        printValue += "\033[u";
        break;
      case 'a':
      case 'd':
      case 'c':
      case 'e':
        printValue += "\033[u";
        break;
    }

    switch (type) {
      case 't':
        printValue += "\033[2B";
        break;
      case 'a':
      case 'd':
        printValue += "\033[1B";
        break;

      case 'c':
      case 'e':
        printValue += String.format("\033[%dC", leftTextCount);
        break;
    }

    System.out.print(printValue + defaultFG);
  }

  public static String[] wrapLine(String line) {
    String[] words = line.split(" ");
    int approximateCount = Math.max((line.length() / 30), 8);
    String[] textArr = new String[approximateCount];

    Arrays.fill(textArr, "");
    int rowIndex = 0;
    for (String word : words) {
      if (textArr[rowIndex].length() + word.length() + 2 > menuWidth) {
        rowIndex++;
      }

      textArr[rowIndex] += word + " ";
    }
    int lineCount = rowIndex + 1;
    String[] result = new String[lineCount];
    for (int i = 0; i < lineCount; i++) {
      result[i] = textArr[i];
    }

    return result;
  }

  public static int getLineCount(String[] lines) {
    int result = 0;
    for (String line : lines) {
      result += getLineCount(line);
    }
    return result;
  }

  public static int getLineCount(String line) {
    int result = 0;
    result += wrapLine(line).length;

    return result;
  }

  public static int getLongestRow(String[] lines) {
    int result = 0;
    for (String line : lines) {
      result = Math.max(result, line.length());
    }

    return result;
  }

  
  public static String center(String s, int size) {
    return center(s, size, ' ');
  }

  public static String center(int d, int size) {
    return center(String.valueOf(d), size, ' ');
  }

  public static String center(String s, int size, char pad) {
    if (s == null || size <= s.length())
    return s;

    StringBuilder sb = new StringBuilder(size);
    for (int i = 0; i < (size - s.length()) / 2; i++) {
      sb.append(pad);
    }
    sb.append(s);
    while (sb.length() < size) {
      sb.append(pad);
    }
    return sb.toString();
  }
}
