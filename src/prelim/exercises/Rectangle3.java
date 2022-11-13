/**
 * Name: Iori Z. Pimentel
 * Date: Sep 5, 2022
 * Activity Name and Number: Prelim Exercise Number 4

 -----------------------------------------------------------------
 Input: Length and Width
 Processes: Find the Perimeter and Area of Rectangle
 Display results
 Output: Perimeter, Area
 ------------------------------------------------------------------
 Algorithm:
 1. Ask the user for the length and width of the rectangle using Scanner
 2. Compute the perimeter : perimeter = 2 * (length + width)
 3. Compute the area: area = length * width
 4. Show the length and width of the rectangle
 5. Show the perimeter of the rectangle
 6. Show the area of the rectangle

 -------------------------------------------------------------------
 */

package prelim.exercises;


import java.util.Scanner;

public class Rectangle3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int length = 0, width = 0;
    int perimeterOfRectangle, areaOfRectangle;

    System.out.print("Type the value of the length: ");
    length = Integer.parseInt(keyboard.nextLine());

    System.out.print("Type the value of the width: ");
    width = Integer.parseInt(keyboard.nextLine());

    perimeterOfRectangle = 2 * (length + width);
    areaOfRectangle = length * width;


    System.out.print(
      "\n\n" +
      "\t*********************************************************\n"+
      "\t|\n" +
      "\t|\n" +
      "\t|\t Length of rectangle is " + length + " and width of rectangle is " + width + ".\n" +
      "\t|\t Perimeter of rectangle is " + perimeterOfRectangle + ".\n" +
      "\t|\t Area of rectangle is " + areaOfRectangle + ".\n" +
      "\t|\n" +
      "\t|\n" +
      "\t*********************************************************"
    );
    System.exit(0);
  }
}
