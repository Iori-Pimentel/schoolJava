/**
 * Name: Iori Z. Pimentel
 * Programming Date: Aud 31, 2022
 * Activity Name and Number: Prelim Exercise Number 3
 * Problem:
 * Write a program that will show the radius of a circle with a given area.
 * Analysis:
 * Input: area of a circle (area)
 * Processes: Compute the radius of the circle
 * Display the data associated with the circle
 * Output: radius
 * Algorithm:
 * 1. Assign the area of the circle
 * 2. Compute the radius: radius = square root of (area/PI)
 * 3. Show the given area of a circle
 * 4. Show the computed radius of the circle with a given area
 */

package prelim.exercises;


import static java.lang.Math.PI;

public class Circle2 {
    public static void main(String[] args) {
        double area = 15;
        double radius;

        radius = Math.sqrt(area / PI);

        System.out.print(
                "\n\n" +
                        "\t*********************************************************\n"+
                        "\t|\n" +
                        "\t|\n" +
                        "\t|\t Area of circle is " + area + ".\n" +
                        "\t|\t Radius of Circle is " + radius + ".\n" +
                        "\t|\n" +
                        "\t|\n" +
                        "\t*********************************************************"
        );
        System.exit(0);
    }
}
