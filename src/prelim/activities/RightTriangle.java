/**
 * Name: Iori Z. Pimentel
 * Date: Sep 21, 2022
 * Class Code and Course Number: 9315 - CS 112
 -----------------------------------------------------------------
 Input: Base, Height, and Hypotenuse
 Processes: Find the Perimeter and Area of a Right Triangle
 Display results
 Output: Perimeter, Area
 ------------------------------------------------------------------
 Algorithm:
 1. Assign the base, height and hypotenuse of the triangle
 2. Compute the perimeter : perimeter = base + height + hypotenuse
 3. Compute the area: area = 0.5 * base * height
 4. Show the base, height and hypotenuse of the triangle
 5. Show the perimeter of the triangle
 6. Show the area of the triangle

 -------------------------------------------------------------------
 */

package prelim.activities;

public class RightTriangle {
  public static void main(String[] args) {
    int base = 10, height = 8, hypotenuse = 5;

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
