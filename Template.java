import java.lang.*;
import java.util.*;
public class Template {
  public static void main(String[] args) throws InterruptedException {
    System.out.print("\033[H\033[2J"); // Clear Screen
    createMenu(50, 6, 3, 4);
    print("Calculate Sum of Series", 't');
    String output = "Program to create a Mulitiplication table";
    String input = "Enter A: ";
    Scanner keyboard = new Scanner(System.in);

    // System.out.println("→↗↑↖↓↘↙");
    print("Enter [a]: ", 'i');
    int num1 = getPositiveInput();

    print("Enter [b]: ", 'i');
    int num2 = getPositiveInput();

    print("Enter [c]: ", 'i');
    int num3 = getPositiveInput();
  }

  public static int leftSide = 0;
  public static int rigthSide = 0;
  public static int menuWid = 0;
  public static int menuHei = 0;

  public static void createMenu(int wid, int hei, int tpad, int lpad) {
    menuWid = wid;
    menuHei = hei;
    StringBuilder sBuild = new StringBuilder();
    String row = new String(new char[wid]).replace("\0", "─");
    String space = new String(new char[wid]).replace("\0", " ");
    String pad = new String(new char[lpad]).replace("\0", " ");


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

  public static String colorString(String input, String color) {
    return color + input + "\033[39m";
  }

  public static void printNext() {
    System.out.print("\033[u\033[1B");
  }

  public static int getPositiveInput() {
    Scanner keyboard = new Scanner(System.in);
    int num = 0;
    while (true) {
      try {
        num = Integer.parseInt(keyboard.nextLine());
        printNext();
        if (num < 0) {
          print("Value must be greater than 0.", 'e');
        }
        else break;
      } catch (NumberFormatException e) {
        print("Try Again", 'e');
      }
    }
    return num;
  }

  public static void print(String text, char type) {
    String questionFG = "\033[33m";
    String redFG = "\033[31m";
    String inputQFG = "\033[34m";
    String commentFG = "\033[37m";
    String answerFG = "\033[36m";
    String defaultFG = "\033[39m";
    String printValue = "";

    switch (type) {
      case 't': // Window Title
        printValue =
          "\033[s" // Save Cursor Position
        + "\033[1C" // Move Cursor to Rigth by 1
        + text
        + "\033[u"
        + "\033[2B";
        break;

      case 'i': // Prompt for Input
        leftSide = text.length();
        printValue =
          "\033[s" // Save Cursor Position
        + inputQFG
        + text
        + defaultFG;
        break;

      case 'e': // Prompt for Input
        rigthSide = text.length();
        int total = menuWid - rigthSide - leftSide - 2;
        printValue =
          "\033[u"
        + "\033[" + leftSide + "C"
        + String.format("%" + total + "s", "")
        + redFG 
        + text
        + defaultFG
        + "\033[u"
        + "\033[" + leftSide + "C";
        break;
      default:
        break;
    }
    System.out.print(printValue);
  }


}
