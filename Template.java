import java.lang.*;
import java.util.*;
public class Template {
  public static void main(String[] args) {
    System.out.print("\033[H\033[2J"); // Clear Screen
    createMenu(64, 6, 3, 4);
    print("Calculate Sum of Series", 't');
    Scanner keyboard = new Scanner(System.in);

    // System.out.println("→↗↑↖↓↘↙");
    print("Enter [a]: ", 'i');
    print("[a] > 0", 'c');
    int num1 = getPositiveInput();

    print("Enter [b]: ", 'i');
    print("[b] > 0", 'c');
    int num2 = getPositiveInput();

    print("Enter [c]: ", 'i');
    print("[c] > 0", 'c');
    int num3 = getPositiveInput();

    createMenu(32, 6, 3, 12);
    print("Answers", 't');

    int[] textArr = {num1, num2, num3};
    print(textArr, 'a');
    createMenu(64, 6, 3, 4);
    print("Calculate Sum of Series", 't');
    String[] answersheet = {
      "Hello This us ",
      "Hetw"
    };
    print(answersheet, 'd');
    int num4 = getPositiveInput();
  }

  public static int leftTextCount = 0;
  public static int rightTextCount = 0;
  public static int menuWid = 0;
  public static int menuHei = 0;

  public static void createMenu(int wid, int hei, int tpad, int lpad) {
    menuWid = wid;
    menuHei = hei;
    StringBuilder sBuild = new StringBuilder();
    String space = String.format("%" + wid + "s", "");
    String pad = String.format("%" + lpad + "s", "");
    String row = space.replace(" ", "─");


    sBuild.append(
      String.format("%s\033[s┌%s┐\n", pad, row)
    );

    for (int i = 0; i < hei; i++) {
      sBuild.append(
        String.format("%s│%s│\n", pad, space)
      );  
    }

    sBuild.append(
      String.format("%s└%s┘\n", pad, row)
    );
    
    for (int i = 0; i < tpad; i++) {
      System.out.println();
    }
    System.out.println(sBuild);
    System.out.print("\033[u\033[2C");
  }

  public static int getPositiveInput() {
    Scanner keyboard = new Scanner(System.in);
    int num = 0;
    while (true) {
      try {
        num = Integer.parseInt(keyboard.nextLine());
        System.out.print("\033[u\033[1B");
        if (num < 0) {
          print("Value must be greater than 0", 'e');
        }
        else break;
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
      }
    }
    return num;
  }

  public static void print(String text, char type) {
    printUtil(text, type);
  }

  public static void print(int text, char type) {
    printUtil(Integer.toString(text), type);
  }

  public static void print(int[] textArr, char type) {
    for (int text : textArr) {
      printUtil(Integer.toString(text), type);
    }
  }

  public static void print(String[] textArr, char type) {
    for (String text : textArr) {
      printUtil(text, type);
    }
  }

  public static void print(double text, char type) {
    printUtil(Double.toString(text), type);
  }

  public static void printUtil(String text, char type) {
    String yellowFG = "\033[33m";
    String redFG = "\033[31m";
    String blueFG = "\033[34m";
    String grayFG = "\033[37m";
    String greenFG = "\033[36m";
    String defaultFG = "\033[39m";
    String saveCursor = "\033[s";
    String updateCursor = "\033[u";
    String printValue = "";
    int padCount;

    switch (type) {
      case 't':
      case 'i':
      case 'd':
      case 'a':
        leftTextCount = text.length();
        printValue += saveCursor;
      break;

      case 'c':
      case 'e':
        rightTextCount = text.length();
        padCount = menuWid - rightTextCount - leftTextCount - 2;
        printValue += updateCursor;
        printValue += "\033[" + leftTextCount + "C";
        printValue += String.format("%" + padCount + "s", "");
      break;
    }

    switch (type) {
      case 't':
        printValue += "\033[1C";
        printValue += yellowFG;
      break;
      case 'i':
        printValue += blueFG;
      break;
      case 'a':
        printValue += greenFG;
      break;
      case 'c':
        printValue += grayFG;
      break;
      case 'e':
        printValue += redFG;
      break;
    }

    printValue += text;

    switch (type) {
      case 't':
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


}
