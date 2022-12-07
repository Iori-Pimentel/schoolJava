/**
* Name: Iori Z. Pimentel
* Date: Nov 28, 2022
* Activity Name and Number: Finals Exercise 6
------------------------------------------------------------

 Activity:

 Study the following program.  Be able to figure out
  what is done by the program.

 Where appropriate, provide the required
  comments. Every required comment briefly explains
  what is done by the corresponding part of the
  program.

 REQUIRED:
 Use the provided datafile.txt as the text file that has inputs
   for the program.  Show a sample run below:

 Sample Run:

   Copy and paste below the content
   of the output screen after successfully executing the program

 * */

package finals.activities;

import java.io.*;
import java.util.Scanner;

public class FileInputOutputFileDemo {
  /**
     * The following method invokes the
     * run method.
     * */
  public static void main(String[] args){
    FileInputOutputFileDemo.run();
    System.exit(0);
  }

  /**
     The following method implements
     the following.

     1. Declare an array that will be used to store
          courses numbers.

     2. Declare an array that will be used to store
          descriptive titles of courses.

     3. Declare an array that will be used to store
          units associated with course numbers.

     4. Declare an array that will be used to store
          grades that are associated with course numbers

     5. Accept the name of a textfile from comma separated
         values/data will be read and store the name of the
         file to the variable nameOfInputTextFile.  (Note: the
         name of the file to be entered when testing the program
         should be datafile.txt)

     6. Invoke a method that determines the number
         of lines in a textfile from which comma separated
         values/data will be read(i.e.number of lines int
         textfile with the name stored in nameOfInputTextFile).
         The number of lines should
         be stored in a variable countOfLines.

     7. Instantiate the arrays such that the length of each
         array is equal to the number of lines in a text file.
        (i.e. The length of each array is the value of countOfLines)

     8. Invoke a method that will populate the declared
         arrays in parallel out of data that are read from
         a text file.

     9. Invoke a method that will compute the average
          of the elements of the array for grades and
          let the average be stored in the variable
          average.

     10. Invoke a method that will show a formatted
     display of the elements of the populated arrays

     11.Invoke a method that will determine and show
          the highest grade.

     12.Invoke a method that will determine and show
          the lowest grade.

     13. Invoke the method that will determine and show the average
          of the grades.

     14. Invoke a method prints comma separated
         values in a text file where each line
         in the text file shows corresponding
         elements of the array of course number,
         array of descriptive title, array of
         units, array of grades and a remark PASSED
         or FAILED.  The remark PASSED should be for
         a grade that is at least 75 and the remark
         failed should be for a grade that is less
         than 75.
         The name of the textfile should be asked from
            the user at runtime.
     * */
  public static void run(){
    String[] courseNumbers;
    String[] courseDescriptiveTitles;
    byte[] units;
    byte[] grades;
    String nameOfInputTextFile = readNameOfFile("Please enter the name of input file");
    int countOfLines = countNumberOfLinesInFile(nameOfInputTextFile);
    courseNumbers = new String[countOfLines];
    courseDescriptiveTitles = new String[countOfLines];
    units = new byte[countOfLines];
    grades = new byte[countOfLines];
    populateArrays(nameOfInputTextFile,courseNumbers,courseDescriptiveTitles,units,grades);
    double average = computeAverage(grades);
    displayData(courseNumbers,courseDescriptiveTitles,units,grades);
    System.out.println("Highest Grade = "+ determineHighest(grades));
    System.out.println("Lowest Grade = "+ determineLowest(grades));
    System.out.println("Average of Grades = " + computeAverage(grades));
    printDataToTextFile(courseNumbers,courseDescriptiveTitles,units,grades);
  }

  /**
     * Displays on screen course numbers, course descriptive titles,
     * units, grades and appropriate remarks.
     * */
  public static void displayData(String[] cNumber, String[] dTitle,
    byte[] units, byte[] grades){
    System.out.printf("%-15s%-40s%-8s%-8s%-12s%n","Course Number","Descriptive Title","Units","Grade","Remark");
    for (int index=0; index<cNumber.length; index++){
      System.out.printf("%-15s%-40s%-8d%-8d",cNumber[index],dTitle[index],units[index], grades[index]);
      if (grades[index]<75)
      System.out.printf("%-12s%n","FAILED");
      else
      System.out.printf("%-12s%n","PASSED");
    }
    return;
  }

  /**
     * Prints on a text file course numbers, course descriptive titles,
     * units, grades and appropriate remarks.
     * */
  public static void printDataToTextFile(String[] cNumber, String[] dTitle,
    byte[] units, byte[] grades) {
    PrintWriter fileWriter = null;
    Scanner keyboard = new Scanner(System.in);
    System.out.println();
    System.out.println("The elements of the array of course numbers, " +
      "array of descriptive tiles, array of units, array of grades "
      + "with corresponding remark will be printed as comma " +
      "separated values in a text file. You will be asked to" +
      " enter the name of the textfile");
    System.out.print("Enter the name of the text file where data will be printed: ");
    String filename = keyboard.nextLine();

    try {
      fileWriter = new PrintWriter(new FileWriter(filename));
      for (int index = 0; index < cNumber.length; index++) {
        fileWriter.print(cNumber[index]+","+ dTitle[index]+","
          +units[index]+ ","+grades[index]+",");
        if (grades[index] < 75)
        fileWriter.println("FAILED");
        else
        fileWriter.println("PASSED");
      }
    } catch (Exception ex){
      System.out.println("A problem has occured.");
      ex.printStackTrace();
      System.exit(0);
    } finally {
      System.out.println("Data have been printed in "+ filename +".");
      fileWriter.close();
    }
    return;
  }

/**
* Returns a string representing a filename that is entered through
     * the keyboard
     * */
  public static String readNameOfFile(String promptMessage){
    String filename="";
    Scanner keyboard = new Scanner(System.in);
    System.out.print(promptMessage+ ": ");
filename = keyboard.nextLine();
    return filename;
  }

  /**
     * Returns the number of lines in a textfile with the given filename
     * */
  public static int countNumberOfLinesInFile(String filename){
    int count=0;
    Scanner inputFilePointer=null;
    try {
      inputFilePointer = new Scanner(new FileInputStream(new File(filename)));
      while (inputFilePointer.hasNextLine()){
        count+=1;
        inputFilePointer.nextLine();
      }
    } catch (FileNotFoundException exception){
      System.out.println("Sorry! The input file is missing");
      System.out.println("The program needs to close.");
      System.out.println("Try to run the program again after " +
        "ensuring that the file has been created.");
      System.exit(0);
    } finally {
      inputFilePointer.close();
    }
    return count;
  }

  /**
     * Populate in parallel the arrays for
     * course number(cNumber), descriptive title(dTitle),
     * units, grades out of values that are read
     * from an input textfile with a given name.
     * It is assumed that each line in the text file
     * has a comma separated values for course number,
     * descriptive title, units and grade in the same
     * order as they are listed.
     * */
  public static void populateArrays(String filename, String[] cNumber, String[] dTitle, byte[] units, byte[] grades) {
    Scanner inputFilePointer = null;
    int index = -1;

    try {
      inputFilePointer = new Scanner(new FileInputStream(new File(filename)));
      while (inputFilePointer.hasNextLine()) {
        index = index + 1;
        String lineOfStringRead = inputFilePointer.nextLine();
        String[] values = lineOfStringRead.split(",");
        cNumber[index] = values[0];
        dTitle[index] = values[1];
        units[index] = Byte.parseByte(values[2]);
        grades[index] = Byte.parseByte(values[3]);
      }
    } catch (FileNotFoundException exception) {
      System.out.println("Sorry! The input file is missing");
      System.out.println("The program needs to close.");
      System.out.println("Try to run the program again after " +
        "ensuring that the file has been created.");
      System.exit(0);
    } finally {
      inputFilePointer.close();
    }
  }

  /**
     * Returns the highest of the elements of a given array of
     *   values of type byte
     * */
  public static double computeAverage(byte[] array){
    double average=0;
    double sum=0;
    for (int index=0; index<array.length; index++){
      sum = sum + array[index];
    }
    average = sum/array.length;
    return average;
  }

  /**
     * Returns the highest of the elements of a given array of
     *   values of type byte
     * */
  public static byte determineHighest(byte[] array){
    byte highest = array[0];

    for (int index=1; index<array.length; index++){
      if (array[index] > highest )
      highest = array[index];
    }
    return highest;
  }


  /**
     * Returns the highest of the elements of a given array of
     *   values of type byte
     * */
  public static byte determineLowest(byte[] array){
    byte lowest = array[0];

    for (int index=1; index<array.length; index++){
      if (array[index] < lowest )
      lowest = array[index];
    }
    return lowest;
  }

} // end of FileInputOutputDemo class
