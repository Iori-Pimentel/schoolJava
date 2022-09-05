/**
 * Name: Iori Z. Pimentel
 * Date: Sep 5, 2022
 * Activity Name and Number: Prelim Exercise Number 4

 -----------------------------------------------------------------
 Input: Side length
 Processes: Find the Perimeter and Area of Square
 Display results
 Output: Perimeter, Area
 ------------------------------------------------------------------
 Algorithm:
 1. Ask the user the side length of the square using Scanner
 2. Compute the perimeter : perimeter = 4 * side
 3. Compute the area: area = side * side
 4. Show the side length of the square
 5. Show the perimeter of the square
 6. Show the area of the square

 -------------------------------------------------------------------
 */

package prelim.exercises;


import java.util.Scanner;

public class Square3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int side = 0;
        int perimeterOfSquare, areaOfSquare;

        System.out.print("Type the value of the side: ");
        side = Integer.parseInt(keyboard.nextLine());

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
