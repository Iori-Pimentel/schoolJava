/**
 * Name: Iori Z. Pimentel
 * Date: Aug 24, 2022
 * Activity Name and Number: Prelim Exercise Number 2

 -----------------------------------------------------------------
 Input: Radius of a circle (radius)
 Processes: Compute the circumference of the circle
 Compute the area of the circle
 Display results
 Output: circumference, area
 ------------------------------------------------------------------
 Algorithm:
 1. Assign the radius of the circle
 2. Compute the circumference : circumference = 2*(3.1416)*radius
 3. Compute the area: area = PI*radius*radius
 4. Show the radius of the circle
 5. Show the circumference of the circle
 6. Show the area of the circle

 -------------------------------------------------------------------
 */

package prelim.exercises;
import static java.lang.Math.PI;

public class Circle {
    public static void main(String[] args) {
        int radius = 15;
        double circumference, areaOfCircle;

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
