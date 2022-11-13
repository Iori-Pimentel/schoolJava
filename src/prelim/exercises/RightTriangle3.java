/**
 * Name: Iori Z. Pimentel
 * Date: Sep 5, 2022
 * Activity Name and Number: Prelim Exercise Number 4

 -----------------------------------------------------------------
 Input: Base, Height, and Hypotenuse
 Processes: Find the Perimeter and Area of a Right Triangle
 Display results
 Output: Perimeter, Area
 ------------------------------------------------------------------
 Algorithm:
 1. Ask the user for the base, height of the triangle using Scanner
 2. Compute the hypotenuse: sqrt (base * base + height * height)
 2. Compute the perimeter: perimeter = base + height + hypotenuse
 3. Compute the area: area = 0.5 * base * height
 4. Show the base, height and hypotenuse of the triangle
 5. Show the perimeter of the triangle
 6. Show the area of the triangle

 -------------------------------------------------------------------
 */

package prelim.exercises;
import java.util.Scanner;


public class RightTriangle3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int base = 0, height = 0;

    System.out.print("Type the value of the base: ");
    base = Integer.parseInt(keyboard.nextLine());

    System.out.print("Type the value of the height: ");
    height = Integer.parseInt(keyboard.nextLine());

    double hypotenuse;
    hypotenuse = Math.sqrt(base * base + height * height);

    double perimeterOfRightTriangle, AreaOfRightTriangle;
    perimeterOfRightTriangle = base + height + hypotenuse;
    AreaOfRightTriangle = 0.5 * base * height;

    System.out.print(
      "\n\n" +
      "\t*********************************************************\n" +
      "\t|\n" +
      "\t|\n" +
      "\t|\t Base of triangle is " + base + " and height of triangle is " + height + "\n" +
      "\t|\t and hypotenuse of triangle is " + hypotenuse + ".\n" +
      "\t|\n" +
      "\t|\t Perimeter of triangle is " + perimeterOfRightTriangle + ".\n" +
      "\t|\t Area of triangle is " + AreaOfRightTriangle + ".\n" +
      "\t|\n" +
      "\t|\n" +
      "\t*********************************************************"
    );
    System.exit(0);
  }
}
