/**
 * Name: Iori Z. Pimentel
 * Date: Sep 12, 2022
 * Activity Name and Number: Prelim Exercise Number 8
------------------------------------------------------------
Problem:
Write a program for determining the roots of a quadratic equation. A quadratic equation
has the form ax2 + bx + c = 0. The numerical coefficients a, b and c should be entered at
run time. The literal coefficient is assumed to be x (i.e. There is no need to read the
literal coefficient).
Notes:
 Quadratic Formula
 first root = (-b + Math.sqrt(b*b-4*a*c))/(2*a)
 second root = (-b - Math.sqrt(b*b - 4*a*c))/(2*a)
Sample run:
------------------------------------------------------------
 Enter the coefficient of x squared (a): 1
 Enter the coefficient of x (b): -4
 Enter the constant (c): 4
 The roots of (1)x^2 + (-4)x + (4) = 0 are 2.00 and 2.00.
------------------------------------------------------------
Analysis
Inputs: Coefficients a, b and c
Processes:
  Read the coefficients
  Compute the roots
  Show the roots
  Outputs: First root and second root
Algorithm
1. Show an introduction of the application/program
2. Read the value of a
3. Read the value of b
4. Read the value of c
5. Compute root1: root1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a)
6. Compute root2: root2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a)
7. Display the roots.
*/

package prelim.exercises;

import java.util.Scanner;
import java.lang.Math;

public class QuadraticSolver {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("This program determines the roots of a quadratic equation" +
      "\nof the form ax^2 +bx +c = 0.");

    System.out.print("Enter the coefficient of x^2 (a): ");
    double a = Double.parseDouble(keyboard.nextLine());

    System.out.print("Enter the coefficient of x (b): ");
    double b = Double.parseDouble(keyboard.nextLine());

    System.out.print("Enter the constant (c): ");
    double c = Double.parseDouble(keyboard.nextLine());

    double discriminant = b * b - (4 * a * c);
    if (discriminant < 0){
      System.out.println("\nThe expression given has no real roots.");
      System.out.println("Exiting the program...");
      System.exit(0);
    }

    double discriminantSqrt = Math.sqrt(discriminant);
    double root1 = (-b + discriminantSqrt) / (2 * a);
    double root2 = (-b - discriminantSqrt) / (2 * a);

    System.out.printf("\n%s%.2f%s%.2f%s%.2f%s%.2f%s%.2f%c%n", "a: ", a, ", b: ",
      b, ", c: ", c, " has the roots ", root1, " and ", root2, '.');
    System.exit(0);

  }
}
