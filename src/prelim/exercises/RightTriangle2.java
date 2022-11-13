/**
 * Name: Iori Z. Pimentel
 * Programming Date: Aud 31, 2022
 * Activity Name and Number: Prelim Exercise Number 3
 * Problem:
 * Write a program that will show the hypotenuse of a triangle with a given base and height.
 * Analysis:
 * Input: Base and Height
 * Processes: Compute the Hypotenuse of the circle
 * Display the data associated with the Triangle
 * Output: Hypotenuse
 * Algorithm:
 * 1. Assign the base and height of the triangle
 * 2. Compute the hypotenuse: sqrt(base * base + height * height)
 * 3. Show the given base and height of the triangle
 * 4. Show the computed hypotenuse of the triangle
 */
package prelim.exercises;

public class RightTriangle2 {
  public static void main(String[] args) {
    int base = 3, height = 4;

    double hypotenuse;

    hypotenuse = Math.sqrt(base * base + height * height);

    System.out.print(
      "\n\n" +
      "\t*********************************************************\n" +
      "\t|\n" +
      "\t|\n" +
      "\t|\t Base of triangle is " + base + " and height of triangle is " + height + ".\n" +
      "\t|\t Hypotenuse of triangle is " + hypotenuse + ".\n" +
      "\t|\n" +
      "\t|\n" +
      "\t*********************************************************"
    );
    System.exit(0);
  }
}
