/**
 * Name: Iori Z. Pimentel
 * Date: Oct 24, 2022
 * Activity Name and Number: Midterm Sample
 ------------------------------------------------------------
 Write a program that prints strings
 in a datafile(textfile).When the program
 runs, the user is asked to enter 5 strings.
 The strings entered are then printed in a file
 called sample.txt.

 Sample Run:
 Enter a name: John
 John was printed in the sample.txt file.
 Enter a name: Anne
 Anne was printed in the sample.txt file.
 Enter a name: Mark
 Mark was printed in the sample.txt file.
 Enter a name: Luke
 Luke was printed in the sample.txt file.
 Enter a name: Kate
 Kate was printed in the sample.txt file.
 */
package midterm.samples;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class FilePrintSample {
    public static void main(String[] args) {
        PrintWriter fileWriter = null;
        String enteredString = null;
        Scanner keyboard = new Scanner(System.in);

        try {
            fileWriter = new PrintWriter(new FileOutputStream(new File("sample.txt")));
            for (int counter=1; counter<=5; counter++) {
                System.out.print("Enter a name: ");
                enteredString = keyboard.nextLine();
                fileWriter.println(enteredString);
                System.out.println(enteredString+" was printed in sample.txt file");
            }
        } catch (Exception ex){
            System.out.println("Error");
            ex.printStackTrace();
        }
        fileWriter.close();
        System.exit(0);
    }
}