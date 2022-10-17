/**
 * Name: Iori Z. Pimentel
 * Date: Oct 17, 2022
 * Activity Name and Number: Midterm Exercise Program 8
 ------------------------------------------------------------
    Test the program given below with different possible input values. Note that the program allows
    the computer to determine and show the roots of a quadratic equation after the computer is given
    the numerical coefficients of the quadratic equation. Note further that if the roots of the quadratic
    equation are imaginary, the program gives a String representation of the imaginary roots. The
    given program is written such that aside from the main method, other methods are included.
    However, you may not mind the other methods at this point. Focus on seeing and
    understanding sample runs of the program.
    Required:
    Rewrite the following program such that the program has only the main method. The re-written
    program should have the same result/output as the given program. (Filename:
    MidtermExercise8.java)

*/
package midterm.exercises;
import java.util.Scanner;
import java.lang.*;
public class MidtermExercise8 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double a, b, c, root1, root2, discriminant;
        System.out.println("This program helps you solve for the roots of a Quadratic Equation.");
        System.out.println("You should enter the coefficients of the quadratic equation");
        System.out.print("Enter a: ");
        a = Double.parseDouble(keyboard.nextLine());
        System.out.print("Enter b: ");
        b = Double.parseDouble(keyboard.nextLine());
        System.out.print("Enter c: ");
        c = Double.parseDouble(keyboard.nextLine());
        discriminant = b * b - 4 * a * c;

        if (discriminant >= 0){
            double sqrtDiscriminant = Math.sqrt(discriminant);
            root1 = (-b + sqrtDiscriminant) / (2 * a);
            root2 = (-b - sqrtDiscriminant) / (2 * a);
            System.out.println("The roots are: " + root1 + " and " + root2 + ".");
        }else {
            String root1String =  -b / (2 * a) + " + (square root of (" + (-1) * discriminant + ") * i) / " + (2 * a);
            String root2String = -b / (2 * a) + " - (square root of (" + (-1) * discriminant + ") * i) / " + (2 * a);
            System.out.println("The imaginary roots are: " + root1String + " and " + root2String + ".");
        }
        System.exit(0);
    }
} // end of class