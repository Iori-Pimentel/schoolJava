import java.lang.*;
import java.util.*;
public class Template {
  public static void main(String[] args) throws InterruptedException {
    System.out.print("\033[H\033[2J"); // Clear Screen
    createMenu(40, 6, 3, 4);
    print("Calculate Sum of Series", 't');
    String output = "Program to create a Mulitiplication table";
    String input = "Enter A: ";
    Scanner keyboard = new Scanner(System.in);

    // System.out.println("→↗↑↖↓↘↙");
    print("Enter [a]: ", 'i');
    int num1 = Integer.parseInt(keyboard.nextLine());
    System.out.print("\033[u\033[1B");
    printNext();
    print("Enter [b]: ", 'i');
    int num2 = Integer.parseInt(keyboard.nextLine());

  }

  public static void createMenu(int wid, int hei, int tpad, int lpad) {
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
    System.out.print("\033[u");
  }

  public static String colorString(String input, String color) {
    return color + input + "\033[39m";
  }

  public static void printNext() {
    System.out.print("\033[u\033[1B");
  }

  public static void print(String text, char type) {
    String questionFG = "\033[33m";
    String inputQFG = "\033[34m";
    String commentFG = "\033[37m";
    String answerFG = "\033[36m";
    String defaultFG = "\033[39m";
    String printValue = "";

    switch (type) {
      case 't': // Window Title
        printValue =
          "\033[s" // Save Cursor Position
        + "\033[3C" // Move Cursor to Rigth by 3
        + text
        + "\033[u"
        + "\033[2B";
        break;

      case 'i': // Prompt for Input
        printValue =
          "\033[s" // Save Cursor Position
        + "\033[2C" // Move Cursor to Rigth by 2
        + inputQFG
        + text
        + defaultFG;
        break;

      default:
        break;
    }
    System.out.print(printValue);
  }


}
