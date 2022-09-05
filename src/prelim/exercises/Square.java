/**
 * Name: Iori Z. Pimentel
 * Date: Aug 24, 2022
 * Activity Name and Number: Prelim Exercise Number 2

 -----------------------------------------------------------------
 Input: Side length
 Processes: Find the Perimeter and Area of Square
 Display results
 Output: Perimeter, Area
 ------------------------------------------------------------------
 Algorithm:
 1. Assign the side length of the square
 2. Compute the perimeter : perimeter = 4 * side
 3. Compute the area: area = side * side
 4. Show the side length of the square
 5. Show the perimeter of the square
 6. Show the area of the square

 -------------------------------------------------------------------
 */

package prelim.exercises;


public class Square {
    public static void main(String[] args) {
        int side = 15;
        int perimeterOfSquare, areaOfSquare;

        perimeterOfSquare = 4 * side;
        areaOfSquare = side * side;

        System.out.print(
                "\n\n" +
                        "\t*********************************************************\n"+
                        "\t|\n" +
                        "\t|\n" +
                        "\t|\t Side length of square is " + side + ".\n" +
                        "\t|\t Perimeter of square is " + perimeterOfSquare + ".\n" +
                        "\t|\t Area of square is " + areaOfSquare + ".\n" +
                        "\t|\n" +
                        "\t|\n" +
                        "\t*********************************************************"
        );
        System.exit(0);
    }
}
