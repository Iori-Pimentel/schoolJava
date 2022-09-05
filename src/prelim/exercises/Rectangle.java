/**
 * Name: Iori Z. Pimentel
 * Date: Aug 24, 2022
 * Activity Name and Number: Prelim Exercise Number 2

 -----------------------------------------------------------------
 Input: Length and Width
 Processes: Find the Perimeter and Area of Rectangle
 Display results
 Output: Perimeter, Area
 ------------------------------------------------------------------
 Algorithm:
 1. Assign the length and width of the rectangle
 2. Compute the perimeter : perimeter = 2 * (length + width)
 3. Compute the area: area = length * width
 4. Show the length and width of the rectangle
 5. Show the perimeter of the rectangle
 6. Show the area of the rectangle

 -------------------------------------------------------------------
 */

package prelim.exercises;


public class Rectangle {
    public static void main(String[] args) {
        int length = 15, width = 10;
        int perimeterOfRectangle, areaOfRectangle;

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
