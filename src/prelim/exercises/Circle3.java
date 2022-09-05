/**
 * Name: Iori Z. Pimentel
 * Date: Aug 31, 2022
 * Activity Name and Number: Prelim Exercise Number 4

 Problem:
 Write a program that computes and shows the area and the circumference of a circle with
 a given radius. Let the radius be entered through the keyboard at program runtime.
 Analysis:
 Input: Radius of a circle (radius)
 Processes:
 Read the radius of the circle
 Compute the circumference of the circle

 Compute the area of the circle
 Display results
 Output: circumference, area
 Algorithm:
 1. Read/Accept the radius of the circle
 2. Compute the circumference: circumference = 2 * PI * radius
 3. Compute the area: area = PI * radius * radius
 4. Show the radius of the circle
 5. Show the circumference of the circle
 6. Show the area of the circle
 */


package prelim.exercises;
import static java.lang.Math.PI;
import java.util.Scanner;

public class Circle3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int radius = 0;
        double circumference, areaOfCircle;

        System.out.print("Type the value of the radius: ");
        radius = Integer.parseInt(keyboard.nextLine());

        circumference = 2 * PI * radius;
        areaOfCircle = PI * radius * radius;

        System.out.print(
                "\n\n" +
                        "\t*********************************************************\n"+
                        "\t|\n" +
                        "\t|\n" +
                        "\t|\t Radius of circle is " + radius + ".\n" +
                        "\t|\t Circumference of circle is " + circumference + ".\n" +
                        "\t|\t Area of circle is " + areaOfCircle + ".\n" +
                        "\t|\n" +
                        "\t|\n" +
                        "\t*********************************************************"
        );
        System.exit(0);
    }
}
