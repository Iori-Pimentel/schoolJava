import java.util.*;

public class Ansi {
  public static void main(String[] args) throws InterruptedException{
    Scanner keyboard = new Scanner(System.in);
    // System.out.print("\033[30;40m");
    System.out.print(
      "\033[5000;5000H" +
      "\033[6n" +
      "\033[H" +
      "Only press enter"
    );
    String key = keyboard.nextLine();
    System.out.print("\033[0m");
    System.out.print("\033[H\033[2J" );
    key = key.replaceAll("[^0-9;]", "");

    int width = Integer.parseInt(key.split(";")[0]);
    int height = Integer.parseInt(key.split(";")[1]);

    System.out.println(width);
    System.out.println(height);
    keyboard.nextLine();
  }
}
