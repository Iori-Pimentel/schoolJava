/**
* Name: Iori Z. Pimentel
* Date: Nov 28, 2022
* Activity Name and Number: Finals Exercise 6
------------------------------------------------------------
*/
package finals.exercises;
import java.io.IOException;
import java.util.*;
import java.util.Random;
import java.lang.*;
import java.math.*;

public class Search {

/*
* Global Variables
*/
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
    handleClose();
    showIntroduction();

    while (true) {
      showMainMenu();
    }
  }

  public static void handleClose() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        try {
          Thread.sleep(200);
          System.out.println("Shutting down ...");
          clearScreen();
          System.out.println("Program Closed...");
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          e.printStackTrace();
        }
      }
    });
  }

  public static void showIntroduction() {
    menuWidth = 60;

    System.out.println("If you can see this, then the Terminal GUI will not work");
    clearScreen();

    String[] startText = {
      "Project made while in Saint Louis University as Finals Exercise 7",
      "",
      "Use a Terminal/Console that supports ANSI Escape Codes like VSCode",
      "",
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

    String choice = getChoice(options, "Main Menu", "q");

    switch (choice) {
      case "1":
      showMathMenu(); break;
      case "2":
      showRecordMenu(); break;
      case "3":
      showMiscMenu(); break;
      case "q":
      closeProgram(); break;
    }
  }



  public static void closeProgram() {
    clearScreen();
    System.exit(0);

  }

  public static String getChoice(String[] options, String title, String... endOptions) {
    menuHeight = options.length + 4;
    createMenu(menuWidth, menuHeight, 5, 5);

    print(title, 't');

    int numberedOptions = options.length - endOptions.length;
    for (int i = 0; i < numberedOptions; i++) {
      options[i] = String.format("[%d] ", i + 1) + options[i];

      if (i < 9 && options.length > 9) {
        options[i] = " " + options[i];
      }
    }

    for (int i = numberedOptions; i < options.length; i++) {
      options[i] = String.format("[%s] ", endOptions[i - numberedOptions]) + options[i];

      if (options.length > 9) {
        options[i] = " " + options[i];
      }
    }

    print(options, 'd');
    print("", 'd');
    print("Choice: ", 'i');

    while (true) {
      String input = "";
      int choice;
      try {
        input = keyboard.nextLine();
        choice = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        for (String charOpt : endOptions) {
          if (input.equals(charOpt)) {
            return input;
          }
        }
        print("Try Again", 'e');
        continue;
      }

      if (choice < 1 || choice > options.length) {
        print("Invalid Choice", 'e');
      } else {
        clearScreen();
        return String.valueOf(choice);
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

    String choice = getChoice(options, "Math Routines [Sub Menu]", "b");

    menuWidth = 50;
    title = String.format("Zetta Utils [Math Routine %s]", choice);
    switch (choice) {
      case "1":
      mathRoutine1(); break;
      case "2":
      mathRoutine2(); break;
      case "3":
      mathRoutine3(); break;
      case "4":
      mathRoutine4(); break;
      case "5":
      mathRoutine5(); break;
      case "6":
      mathRoutine6(); break;
      case "7":
      mathRoutine7(); break;
      case "8":
      mathRoutine8(); break;
      case "9":
      mathRoutine9(); break;
      case "10":
      mathRoutine10(); break;
      case "11":
      mathRoutine11(); break;
      case "12":
      mathRoutine12(); break;
      case "13":
      mathRoutine13(); break;
      case "14":
      mathRoutine14(); break;
      case "15":
      mathRoutine15(); break;
      case "b":
      clearScreen();
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

    String choice = getChoice(options, "Recording Routines [Sub Menu]", "b");

    doWrapBool = false;
    menuWidth = 60;
    questions = new String[] {
      "Amount to Sort: | Write the Intended Value"
    };

    title = String.format("Zetta Utils [Recording Routine %s]", choice);
    switch (choice) {
      case "1":
      recordingRoutine1(); break;
      case "2":
      recordingRoutine2(); break;
      case "3":
      recordingRoutine3(); break;
      case "4":
      recordingRoutine4(); break;
      case "b":
      clearScreen();
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

  public static int[] gradeInputMenu(String[] names) {
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

  public static void selectionSort(String[] textArr) {

    for (int i = 0; i < textArr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < textArr.length; j++) {
        if (textArr[j].compareToIgnoreCase(textArr[minIndex]) < 0) {
          minIndex = j;
        }
      }
      String tempString = textArr[i];
      textArr[i] = textArr[minIndex];
      textArr[minIndex] = tempString;
    }
  }

  public static void selectionSort(String[] textArr, int[] numberArr) {
    for (int i = 0; i < textArr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < textArr.length; j++) {
        if (textArr[j].compareToIgnoreCase(textArr[minIndex]) < 0) {
          minIndex = j;
        }
      }
      String tempString = textArr[i];
      textArr[i] = textArr[minIndex];
      textArr[minIndex] = tempString;

      int tempInt = numberArr[i];
      numberArr[i] = numberArr[minIndex];
      numberArr[minIndex] = tempInt;

    }
  }

  public static void selectionSort(int[] numberArr, String[] textArr) {
    for (int i = 0; i < numberArr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < numberArr.length; j++) {
        if (numberArr[j] > numberArr[minIndex]) {
          minIndex = j;
        }
      }
      String tempString = textArr[i];
      textArr[i] = textArr[minIndex];
      textArr[minIndex] = tempString;

      int tempInt = numberArr[i];
      numberArr[i] = numberArr[minIndex];
      numberArr[minIndex] = tempInt;

    }
  }

  public static void recordingRoutine1() {
    String[] names;
    description = "Routine to sort list of names of Students";

    names = stringInputMenu();
    selectionSort(names);
    calculatedAnswer = names;
    title = "Sort Student Names in Alphabetical Order";
  }

  public static void recordingRoutine2() {
    String[] names;
    description = "Routine to sort list of names of Salesmen";

    names = stringInputMenu();
    selectionSort(names);
    calculatedAnswer = names;
    title = "Sort Salesmen Names in Alphabetical Order";
  }

  public static void recordingRoutine3() {
    String[] names;
    int[] grades;
    description = "Routine to sort list of [names] and grades";

    names = stringInputMenu();
    grades = gradeInputMenu(names);
    selectionSort(names, grades);
    formatNamesGrades(names, grades);
    title = "`Alphabetical Order";
  }

  public static void recordingRoutine4() {
    String[] names;
    int[] grades;
    description = "Routine to sort list of names and [grades]";

    names = stringInputMenu();
    grades = gradeInputMenu(names);
    selectionSort(grades, names);
    formatNamesGrades(names, grades);
    title = "Ranked by Grades";
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

    String choice = getChoice(options, "Miscellaneous Routines [Sub Menu]", "b");

    title = String.format("Zetta Utils [Miscellaneous Routine %s]", choice);
    menuWidth = 80;
    switch (choice) {
      case "1":
      miscRoutine1(); break;
      case "2":
      miscRoutine2(); break;
      case "3":
      miscRoutine3(); break;
      case "4":
      miscRoutine4(); break;
      case "5":
      miscRoutine5(); break;
      case "6":
      miscRoutine6(); break;
      case "7":
      miscRoutine7(); break;
      case "8":
      miscRoutine8(); break;
      case "9":
      miscRoutine9(); break;
      case "b":
      clearScreen();
      return;
    }
    showAnswer();
    clearScreen();
  }

  public static void miscRoutine1() {
    description = "Routine to play a Number Guessing Game";

    int randomInt = rand.nextInt(100);
    inputCorrectGuess(randomInt);

    title = "You Guessed it";
    calculatedAnswer = new String[] {
      "Congratulations"
    };
  }

  public static void miscRoutine2() {
    description = "Routine to do a Covid Self Assessment";

    selfAssess();
  }

  public static void miscRoutine3() {
    description = "Routine to calculate bills distribution";

    billsDistribution();
  }

  public static void miscRoutine4() {
    description = "Routine to play a Number Guessing Game";

    interestMoney();
  }

  public static void miscRoutine5() {
    description = "Routine for Income Tax Computation";

    taxComputation();
  }

  public static void miscRoutine6() {
    description = "Routine to Calculate Insect Population Growth";

    insectPopulation();
  }

  public static void miscRoutine7() {
    description = "Routine to Calculate Water Bill";

    waterBill();
  }

  public static void miscRoutine8() {
    description = "Routine to Calculate Electric Bill";

    electricBill();
  }

  public static void miscRoutine9() {
    description = "Routine to calculate Load Balance";

    mobileLoadBalance();
  }

  public static void insectPopulation() {

    title = "Water Bill";
    description = "Give";

    createMenu(menuWidth, 5, 5, 1);
    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");

    int initialSize = inputRangeInt("Enter the initial size: | Insect Colony Size", 0);
    int finalSize = inputRangeInt("Enter the final size: | Insect Colony Size", initialSize);

    int rateOfGrowth = (finalSize - initialSize) * 100 / initialSize;
    calculatedAnswer = new String[] {
      String.format("Rate of Growth: [%d]", rateOfGrowth)
    };
  }

  public static void taxComputation() {
    createMenu(menuWidth, 4, 5, 1);
    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");

    double taxDue;
    double taxableIncome = inputRangeDouble("Taxable Income: | How much?", 0);

    if (taxableIncome <= 250_000)
      taxDue = 0;
    else if (taxableIncome <= 400_000)
      taxDue = 0.20 * (taxableIncome - 250_000);
    else if (taxableIncome <= 800_000)
      taxDue = 30_000 + 0.25 * (taxableIncome - 400_000);
    else if (taxableIncome <= 2_000_000)
      taxDue = 130_000 + 0.30 * (taxableIncome - 800_000);
    else if (taxableIncome <= 8_000_000)
      taxDue = 490_000 + 0.32 * (taxableIncome - 2_000_000);
    else
      taxDue = 2_410_000 + 0.35 * (taxableIncome - 8_000_000);
    
    calculatedAnswer = new String[] {
      String.format("Taxable Income: [%.2f]", taxableIncome),
      String.format("Tax Due: [%.2f]", taxDue)
    };
  }

  public static void billsDistribution() {
    createMenu(menuWidth, 4, 5, 1);
    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");
    int bill = inputRangeInt("Bills to Distribute: | How much?", 0);
    int change = bill;

    int thousandsBill = change / 1000;
    change = change % 1000;
    int fiveHundredsBill = change / 500;
    change = change % 500;
    int hundredsBill = change / 100;
    change = change % 100;
    int fiftiesBill = change / 50;
    change = change % 50;
    int twentiesBill = change / 20;
    change = change % 20;
    int tensBill = change / 10;
    change = change % 10;
    int fivesBill = change / 5;
    change = change % 5;


    calculatedAnswer = new String[] {
      String.format("1000s: [%d]", thousandsBill),
      String.format("500s: [%d]", fiveHundredsBill),
      String.format("100s: [%d]", hundredsBill),
      String.format("50s: [%d]", fiftiesBill),
      String.format("20s: [%d]", twentiesBill),
      String.format("10s: [%d]", tensBill),
      String.format("5s: [%d]", fivesBill),
      String.format("1s: [%d]", change)
    };
  }

  public static void selfAssess() {
    createMenu(menuWidth, 7, 5, 1);
    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");

    String[] questions = {
      "Are you experiencing coughing?  | [Yes] [No]",
      "Are you experiencing sickness?  | [Yes] [No]",
      "Are you experiencing difficulty breathing?  | [Yes] [No]"
    };

    for (String question : questions) {
      boolean valid = false;
      printLeftRight(question);
      while (!valid) {
        String answer = keyboard.nextLine();
        clearComment(answer, "√");

        if ("Yes".equalsIgnoreCase(answer)) {
          calculatedAnswer = new String[] {
            "You should check out a doctor"
          };
          return;
        } else if ("No".equalsIgnoreCase(answer)) {
          valid = true;
        } else {
          print("[Yes] or [No]", 'e');
        }
      }
    }
    calculatedAnswer = new String[] {
      "You should be fine"
    };

  }

  public static void interestMoney() {

    float annualRate;
    float quarterlyRate;
    double initialPrincipal = 0;
    double interest = 0;
    double currentPrincipal;
    byte quarter;
    int year;
    char opt;

    annualRate = 0.05F; 

    title = "Interest Bank";
    description = "Give";

    createMenu(menuWidth, 5, 5, 1);
    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");

    year = inputRangeInt("Enter the year: | 1900-2100", 1900, 2100);
    initialPrincipal = inputRangeInt("Enter the intial principal: | Rich", 0);

    quarterlyRate = annualRate / 4; 
    currentPrincipal = initialPrincipal;


    for (quarter = 1; quarter <= 4; quarter++) {
      title = String.format("Quarter [%d]", quarter);
      createMenu(menuWidth, 8, 5, 1);
      print(title, 't');
      print("Choice: ", 'i');

      print("[D]eposit | [W]ithdraw | [C]ontinue | [Q]uit", 'c');
      while (true) {
        String input = keyboard.nextLine();
        opt = input.toLowerCase().charAt(0);
        clearComment(input, "√");

        if (!(opt == 'd' || opt == 'w' || opt == 'c' || opt == 'q')) {
          print("[D]eposit | [W]ithdraw | [C]ontinue | [Q]uit", 'e');
        } else break;
      }

      switch (opt) {
        case 'd':
        currentPrincipal += inputRangeDouble("Deposit Amount: | Valid", 0);
        break;
        case 'w':
        currentPrincipal -= inputRangeDouble("Withdraw Amount: | Valid", 0, currentPrincipal);
        break;
      }

      if (opt != 'q') {
        interest = currentPrincipal * quarterlyRate; 
        currentPrincipal = currentPrincipal + interest;
      }

      System.out.print("\033[1B");
      print(String.format("%8s%16s%16s%n", "Quarter", "Interest", "Amount") ,'a');
      print(String.format("%8d%16.2f%16.2f%n", quarter, interest, currentPrincipal), 'a');

      if (opt == 'q') {
        break;
      }
    }

    title = "Final Principal";
    calculatedAnswer = new String[] {
      String.format("Final Principal: [%.2f]", currentPrincipal)
    };
  } 

  public static void mobileLoadBalance() {
    createMenu(menuWidth, 8, 5, 1);
    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");

    questions = new String[] {
      "Prepaid Load Amount: | Amount",
      "Minutes of Calls Used: | Amount",
      "Numbers of Text Used: | Amount",
      "Rate per Calls: | Amount",
      "Rate per Text: | Amount"
    };

    int[] answers = inputRangeInt(0);

    int answer = answers[0] - ((answers[1] * answers[3]) + (answers[2] * answers[4]));
    calculatedAnswer = new String[] {
      String.format("Remaining Amount of Prepaid Load: [%d]", answer),
    };
  }

  public static void waterBill() {

    createMenu(menuWidth, 7, 5, 1);
    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");

    String consumer;
    char cType;

    int nCMUsed;
    int minCMResidential = 12;
    double minBillResidential = 180.00;
    float rateResidential = 30.00F;
    int minCMCommercial = 30;
    double minBillCommercial = 600.00;
    float rateCommercial = 50.00F;
    double amountDue = 0.0;

    print("Enter the consumer's name: ", 'i');
    consumer = inputValidName();

    int previousReading = inputRangeInt("Enter the meter reading last month: | Must be positive", 0);
    int presentReading = inputRangeInt("Enter the meter reading this month: | Must be grater than last month", previousReading);

    nCMUsed = presentReading - previousReading;

    printLeftRight("Enter the classification as a consumer: | [C]ommercial or [R]esidential");

    while (true) {
      cType = keyboard.nextLine().toLowerCase().charAt(0);

      if (!(cType == 'r' || cType == 'c')) {
        print("[C]ommercial and [R]esidential", 'e');
      } else
      break;
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
  }

  public static void electricBill() {

    createMenu(menuWidth, 7, 5, 1);
    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");

    String consumer;
    char cType;

    int nUsed; 
    int minResidential = 12;
    double minBillResidential = 180.00; 
    float rateResidential = 30.00F; 
    int minCommercial = 30;
    double minBillCommercial = 600.00; 
    float rateCommercial = 50.00F;
    double amountDue = 0.0; 

    print("Enter the consumer's name: ", 'i');
    consumer = inputValidName();

    int previousReading = inputRangeInt("Enter the meter reading last month: | Must be positive", 0);
    int presentReading = inputRangeInt("Enter the meter reading this month: | Must be grater than last month", previousReading);

    nUsed = presentReading - previousReading;

    printLeftRight("Enter the classification as a consumer: | [C]ommercial or [R]esidential");

    while (true) {
      cType = keyboard.nextLine().toLowerCase().charAt(0);

      if (!(cType == 'r' || cType == 'c')) {
        print("[C]ommercial and [R]esidential", 'e');
      } else
      break;
    }

    switch (cType) {
      case 'r':
      amountDue = minBillResidential;
      if (nUsed > minResidential) {
        amountDue += (nUsed - minResidential) * rateResidential;
      }
      break;
      case 'c':
      amountDue = minBillCommercial;
      if (nUsed > minCommercial) {
        amountDue += (nUsed - minCommercial) * rateCommercial;
      }
      break;
    }

    createMenu(menuWidth, 7, 5, 1);
    print("Water Bill Receipt", 't');
    calculatedAnswer = new String[] {
      String.format("Consumer Name: [%s]", consumer),
      String.format("Last Month's Reading: [%d]", previousReading),
      String.format("Current Month's Reading: [%d]", presentReading),
      String.format("Consumption this Month: [%d]", nUsed),
      String.format("Amount Due: [%.2f]", amountDue)
    };
    print(calculatedAnswer, 'a');
  }

  public static void showDescription() {
    doWrapBool = true;
    clearScreen();
    menuHeight = getLineCount(description) + questions.length + 2;
    createMenu(menuWidth, menuHeight, 5, 1);

    print(title, 't');
    print(description, 'd');
    System.out.print("\033[1B");
  }

  public static int[] integerInputMenu() {
    showDescription();
    int[] userInputs = inputRangeInt(0);
    return userInputs;
  }

  public static double[] doubleInputMenu() {
    showDescription();
    double[] userInputs = inputRangeDouble(0.0);
    return userInputs;
  }

  public static String[] stringInputMenu() {
    showDescription();
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

      if (Character.isWhitespace(name.charAt(0))) {
        errorMsg += "[Leading Space]";
      }

      if (Character.isWhitespace(name.charAt(name.length() - 1))) {
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
    description = "Routine to determine if a given number is even or odd.";

    questions = new String[] {
      "Input: | Even or Odd"
    };

    showDescription();
    mathIsEven(inputRangeInt(0));
    title = "Odd or Even";
  }

  public static void mathRoutine2() {
    description = "Routine to determine the sum of a series";

    questions = new String[] {
      "Input: | Sum of Input"
    };

    showDescription();
    mathSumOfSeries(integerInputMenu());
    title = "Sum of Series";
  }

  public static void mathRoutine3() {
    description = "Routine to determine the factors of an integer";

    questions = new String[] {
      "Input: | Factors of Input"
    };

    showDescription();
    mathFactors(integerInputMenu());
    title = "Factors of a Number";
  }

  public static void mathRoutine4() {
    description = "Routine to determine if a number is prime";

    questions = new String[] {
      "Input: | Prime or Not"
    };

    showDescription();
    mathIsPrime(integerInputMenu());
    title = "Prime or Not";
  }

  public static void mathRoutine5() {
    description = "Routine to calculate the area of a " +
    "circle given a radius";

    questions = new String[] {
      "Input: | Radius"
    };

    showDescription();
    mathCircleArea(doubleInputMenu());
    title = "Area of Circle";
  }

  public static void mathRoutine6() {
    description = "Routine to calculate the area of a " +
    "sqaure given the side length";

    questions = new String[] {
      "Input: | Side Length"
    };

    showDescription();
    mathSquareArea(doubleInputMenu());
    title = "Area of Square";
  }

  public static void mathRoutine7() {
    description = "Routine to calculate the area of a " +
    "triangle given the base length and height";

    questions = new String[] {
      "Base: | Base of Triangle",
      "Height: | Height of Triangle"
    };

    showDescription();
    mathTriangleArea(doubleInputMenu());
    title = "Area of Triangle";
  }

  public static void mathRoutine8() {
    description = "Routine to calculate the area of a " +
    "rectangle given the width and height";

    questions = new String[] {
      "Width: | Width of Rectangle",
      "Height: | Height of Rectangle"
    };

    showDescription();
    mathRectangleArea(doubleInputMenu());
    title = "Area of Rectangle";
  }

  public static void mathRoutine9() {
    description = "Routine to calculate the area of a " +
    "trapezoid given two of the bases and the height";

    questions = new String[] {
      "Base [A]: | Base of Trapezoid",
      "Base [B]: | Base of Trapezoid",
      "Height: | Height of Trapezoid"
    };

    showDescription();
    mathTrapezoidArea(doubleInputMenu());
    title = "Area of Trapezoid";
  }

  public static void mathRoutine10() {
    description = "Routine to calculate the area of a " +
    "parallelogram given the base and height";

    questions = new String[] {
      "Base: | Parallelogram",
      "Height: | Parallelogram"
    };

    showDescription();
    mathParallelogramArea(doubleInputMenu());
    title = "Area of Parallelogram";
  }

  public static void mathRoutine11() {
    description = "Routine to determine if a number is a perfect number";

    questions = new String[] {
      "Input: | Perfect or Not"
    };

    showDescription();
    mathPerfectNumber(integerInputMenu());
    title = "Perfect Number";
  }

  public static void mathRoutine12() {
    description = "Routine to create a Multiplication Table of a given size";

    questions = new String[] {
      "Input: | Size of Table"
    };

    showDescription();
    mathMultiTable(integerInputMenu());
    title = "Multiplication Table";
  }

  public static void mathRoutine13() {
    description = "Routine to determine the roots given the three values";

    questions = new String[] {
      "[a] Value: | A",
      "[b] Value: | B",
      "[c] Value: | C"
    };

    showDescription();
    mathRoots(doubleInputMenu());
    title = "Roots of Quadratic Equation";
  }

  public static void mathRoutine14() {
    description = "Create a Fibonacci Sequence given " +
    "the amount to create";

    questions = new String[] {
      "Input: | Count of Sequence"
    };

    showDescription();
    mathFibonacci(integerInputMenu());
    title = "Fibonacci Sequence";
  }

  public static void mathRoutine15() {
    description = "Create a Pascal Triangle given the size";

    questions = new String[] {
      "Input: | Size of Pascal"
    };

    showDescription();
    mathPascalTriangle(integerInputMenu());
    title = "Pascal Triangle";
  }

  public static void mathIsEven(int[] inputs) {
    int number = inputs[0];
    String parity = (number % 2 == 1) ? "Odd" : "Even";

    calculatedAnswer = new String[]{
      String.format("%d is %s", number, parity)
    };
  }

  public static void mathSumOfSeries(int[] inputs) {
    int number = inputs[0];

    int sum = number * (number + 1) / 2;

    calculatedAnswer = new String[]{
      String.format("The sum of the series [%d] is %d", number, sum)
    };
  }

  public static void mathFactors(int[] inputs) {
    int number = inputs[0];
    String factors = "1";

    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        factors += ", " + i;
      }
    }

    if (number != 1) {
      factors += " and " + number;
    }

    calculatedAnswer = new String[]{
      String.format("The factors of [%d] are:", number),
      factors
    };

  }

  public static void mathIsPrime(int[] inputs) {
    int number = inputs[0];

    boolean isPrimeBool = true;
    for (int i = 2; i <= number / 2; ++i) {
      if (number % i == 0) { // Not Prime
        isPrimeBool = false;
        break;
      }
    }

    if (number == 1) {
      isPrimeBool = false;
    }
    String isPrimeText = isPrimeBool ? "a prime number" : "not a prime number";

    calculatedAnswer = new String[]{
      String.format("%d is %s", number, isPrimeText)
    };
  }

  public static void mathCircleArea(double[] inputs) {
    double radius = inputs[0];
    double areaCircle = Math.PI * radius * radius;

    calculatedAnswer = new String[]{
      String.format("The Area of a circle with [%.2f] radius is %.2f", radius, areaCircle)
    };

  }

  public static void mathSquareArea(double[] inputs) {
    double sideLength = inputs[0];
    double areaSquare = sideLength * sideLength;

    calculatedAnswer = new String[]{
      String.format("The Area of a square with [%.2f] side length is %.2f", sideLength, areaSquare)
    };

  }

  public static void mathTriangleArea(double[] inputs) {
    double base = inputs[0], height = inputs[1];
    double areaTriangle = (base * height) / 2;

    calculatedAnswer = new String[]{
      String.format("The Area of a triangle with [%.2f] base and [%.2f] height is %.2f", base, height, areaTriangle)
    };

  }

  public static void mathRectangleArea(double[] inputs) {
    double width = inputs[0], height = inputs[1];
    double areaRectangle = width * height;

    calculatedAnswer = new String[]{
      String.format("The Area of a rectangle with [%.2f] width and [%.2f] height is %.2f", width, height, areaRectangle)
    };

  }

  public static void mathTrapezoidArea(double[] inputs) {
    double baseA = inputs[0], baseB = inputs[1], height = inputs[2];
    double areaTrapezoid = 0.5 * (baseA + baseB) * height;

    calculatedAnswer = new String[]{
      String.format("The Area of a trapezoid with [%.2f] base A, [%.2f] base B and [%.2f] height is %.2f", baseA, baseB, height, areaTrapezoid)
    };

  }

  public static void mathParallelogramArea(double[] inputs) {
    double base = inputs[0], height = inputs[1];
    double areaParallelogram = base * height;

    calculatedAnswer = new String[]{
      String.format("The Area of a rectangle with [%.2f] width and [%.2f] height is %.2f", base, height, areaParallelogram)
    };

  }

  public static void mathPerfectNumber(int[] inputs) {
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

    calculatedAnswer = new String[]{
      String.format("%d is %s", number, isPerfectText)
    };

  }

  public static void mathMultiTable(int[] inputs) {
    int size = inputs[0];
    doWrapBool = false;

    calculatedAnswer = new String[size];
    Arrays.fill(calculatedAnswer, "");

    int length = String.valueOf(size * size).length();
    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        calculatedAnswer[i - 1] += String.format("%" + (length + 2) + "d", i * j);
      }
    }
  }

  public static void mathRoots(double[] inputs) {
    double a = inputs[0], b = inputs[1], c = inputs[2];
    double discriminant = b * b - 4 * a * c;

    if (discriminant >= 0) { // Real Roots
      double sqrtDiscriminant = Math.sqrt(discriminant);

      double root1 = (-b + sqrtDiscriminant) / (2 * a);
      double root2 = (-b - sqrtDiscriminant) / (2 * a);

      calculatedAnswer = new String[]{
        String.format("[%.2f]a, [%.2f]b and [%.2f]c have reals roots:", a, b, c),
        String.format(">\t%.2f", root1),
        String.format(">\t%.2f", root2)
      };
    } else { // Imaginary Roots
      String root1Top = -b + " + sqrt(" + Math.abs(discriminant) + ") * i";
      String root2Top = -b + " - sqrt(" + Math.abs(discriminant) + ") * i";
      String divider = String.format("%" + root1Top.length() + "s", "").replace(" ", "─");
      String rootBottom = String.format("%.2f", 2 * a);
      rootBottom = String.format("%" + ((root1Top.length() + rootBottom.length()) / 2) + "s", rootBottom);

      calculatedAnswer = new String[]{
        String.format("[%.2f]a, [%.2f]b and [%.2f]c have Imaginary roots:", a, b, c),
        "",
        root1Top, divider, rootBottom,
        "", " and", "",
        root2Top, divider, rootBottom
      };
    }
  }

  public static void mathFibonacci(int[] inputs) {
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

    if (number != 1) {
      sequence += " and " + nextTerm;
    }

    calculatedAnswer = new String[]{
      String.format("The Fibonacci sequence with [%d] units are:", number),
      sequence
    };
  }

  public static void mathPascalTriangle(int[] inputs) {
    int size = inputs[0];
    doWrapBool = false;

    calculatedAnswer = new String[size];
    Arrays.fill(calculatedAnswer, "");

    for (int i = 0; i < size; i++) {
      int num = 1;

      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          calculatedAnswer[i] = String.format("%" + ((size - i) * 3) + "s", "");
        }
        calculatedAnswer[i] += String.format("%-6d", num);
        num = num * (i - j) / (j + 1);
      }
    }
  }

  public static void waitEnter() {
    String enter = "Press Enter to Continue...";
    int start = lPad + (menuWidth - enter.length()) - 5;

    String text = String.format("\033[%dC", start) +
    blackBG +
    enter +
    defaultBG;

    System.out.print(text);
    keyboard.nextLine();
    System.out.println("If you can see this, then the Terminal GUI will not work");
    clearScreen();
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

  public static int[] inputRangeInt(int min) {
    int[] answers = new int[questions.length];

    for (int i = 0; i < answers.length; i++) {
      answers[i] = inputRangeInt(questions[i], min);
    }

    return answers;
  }

  public static int[] inputRangeInt(int min, int max) {
    int[] answers = new int[questions.length];

    for (int i = 0; i < answers.length; i++) {
      answers[i] = inputRangeInt(questions[i], min, max);
    }

    return answers;
  }

  public static int inputRangeInt(String question, int min) {
    printLeftRight(question);
    int num = 0;

    while (true) {
      try {
        num = Integer.parseInt(keyboard.nextLine());
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
        continue;
      }
      clearComment(num, "√");

      if (num <= min) {
        print("Input > " + "[" + min + "]", 'e');
      } else break;
    }

    return num;
  }

  public static int inputRangeInt(String question, int min, int max) {
    printLeftRight(question);
    int num = 0;

    while (true) {
      try {
        num = Integer.parseInt(keyboard.nextLine());
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
        continue;
      }
      clearComment(num, "√");

      if (num <= min) {
        print("Input > " + "[" + min + "]", 'e');
      } else if (num >= max) {
        print("Input < " + "[" + max + "]", 'e');
      } else break;
    }

    return num;
  }

  public static String inputCorrectGuess(int randomInt) {
    createMenu(menuWidth, 3, 5, 1);
    print("Number Guessing Game", 't');
    String answers = "";
    int num = 0;
    printLeftRight("Guess: | Start the answer");

    while (true) {
      try {
        num = Integer.parseInt(keyboard.nextLine());
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
        continue;
      }

      clearComment(num, "√");

      answers += num + " ";
      if (num < randomInt) {
        print("Answer must be bigger than [" + num + "]", 'e');
      } else if (num > randomInt) {
        print("Answer must be smaller than [" + num + "]", 'e');
      } else {
        break;
      }
    }

    return answers;
  }

  public static double[] inputRangeDouble(double min) {
    double[] answers = new double[questions.length];

    for (int i = 0; i < answers.length; i++) {
      answers[i] = inputRangeDouble(questions[i], min);
    }

    return answers;
  }

  public static double[] inputRangeDouble(double min, double max) {
    double[] answers = new double[questions.length];

    for (int i = 0; i < answers.length; i++) {
      answers[i] = inputRangeDouble(questions[i], min, max);
    }

    return answers;
  }

  public static double inputRangeDouble(String question, double min) {
    printLeftRight(question);
    double num = 0;

    while (true) {
      try {
        num = Double.parseDouble(keyboard.nextLine());
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
        continue;
      }
      clearComment(num, "√");

      if (num <= min) {
        String formatFloat = String.format("%.2f", min);
        print("Input > " + "[" + formatFloat + "]", 'e');
      } else break;
    }

    return num;
  }

  public static double inputRangeDouble(String question, double min, double max) {
    printLeftRight(question);
    double num = 0;

    while (true) {
      try {
        num = Double.parseDouble(keyboard.nextLine());
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
        continue;
      }
      clearComment(num, "√");

      if (num <= min) {
        String formatFloat = String.format("%.2f", min);
        print("Input > " + "[" + formatFloat + "]", 'e');
      } else if (num >= max) {
        String formatFloat = String.format("%.2f", max);
        print("Input < " + "[" + formatFloat + "]", 'e');
      } else break;
    }

    return num;
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
    if (type == 't' || type == 'i' || type == 'e'|| !doWrapBool) {
      printUtil(text, type);
      return;
    }

    String[] textArr = wrapLine(text);
    for (String textA : textArr) {
      printUtil(textA, type);
    }
  }

  public static void printUtil(String text, char type) {
    if (text.equals("")) {
      return;
    }

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
      printValue += "\033[" + (leftTextCount + padCount) + "C";
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
      printValue += "ζ ";
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
    printValue += defaultFG;

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

    System.out.print(printValue);
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
    if (s == null || size <= s.length()) {
      return s;
    }

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

  public static void clearScreen() {
    System.out.print("\033[H\033[2J"); // Clear Screen
  }
}

