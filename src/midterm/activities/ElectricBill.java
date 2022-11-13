/**
 * Name: Iori Z. Pimentel
 * Date: Nov 7, 2022
 * Activity Name and Number: Midterm Activity
 ------------------------------------------------------------
 The bill for an electric service subscriber is prepared as follows:
 1. Read the name of the electric consumer
 2. Read the previous electric meter reading in kWh Units (reading last month) from the
 consumer’s meter.
 The meter reading cannot be less than zero.
 3. Read the present electric meter reading in kWh Units (reading this month) from the
 consumer’s meter.
 The present electric meter reading cannot be less than the previous electric meter reading.
 4. Compute the amount of electric consumed by subtracting the
 previous reading from the present reading.
 5. Read the classification of the consumer (c for commercial or r for residential)
 6. Compute the amount due from the consumer. The amount due is computed based on the
 following
 For residential consumers
 If kWh Units Consumed is then Amount Due (pesos)
 ==============================================
 Less than or equal to 12 180.00
 More than 12 180.00 + (cubicMetersConsumed – 12) * 30.00

 For commercial consumers
 If kWh Units Consumed is then Amount Due (pesos)
 ==============================================
 Less than or equal to 30 600.00
 More than 30 600.00 + (cubicMetersConsumed – 30) * 50.00
 7. Print a bill statement. The bill statement should show the name of the subscriber, the readings,
 the consumption and the amount due.
 Required:
 Complete the following program for the electric Bill problem described above.
 The program should provide validation of data entries so that the billing process will be
 constrained to dealing with valid values.

 */

package midterm.activities;

import java.util.Scanner;

public class ElectricBill {
  public static void main(String[] args) {
    System.out.println("Program to calculate the bill for electric service subscriber. ");

    int presentReading, previousReading;
    Scanner keyboard = new Scanner(System.in);
    String consumer; 
    char cType; 

    int nUsed; 
    int minResidential = 12;
    double minBillResidential = 180.00; 
    float rateResidential = 30.00F; 
    int minCommercial = 30;
    double minBillCommercial = 600.00; 
    float rateCommercial = 50.00F;
    double amountDue = 0.0; 

    System.out.print("Enter the consumer's name: ");
    consumer = keyboard.nextLine();
    while (true) {
      System.out.print("Enter the meter reading last month: ");
      previousReading = Integer.parseInt(keyboard.nextLine());

      if (previousReading < 0)
      System.out.println("The meter reading cannot me negative.");
      else break;
    }
    while (true) {
      System.out.print("Enter the meter reading this month: ");
      presentReading = Integer.parseInt(keyboard.nextLine());

      if (presentReading < previousReading)
      System.out.println("The meter reading cannot me less than the previous reading.");
      else break;
    }

    nUsed = presentReading - previousReading;

    while (true) {
      System.out.print("Enter the classification as a consumer: ");
      cType = keyboard.nextLine().toLowerCase().charAt(0);

      if (!(cType == 'r' || cType == 'c'))
      System.out.println("Invalid Value...");
      else break;
    }

    switch (cType) {
      case 'r':
      amountDue = minBillResidential;
      if (nUsed > minResidential) {
        amountDue += (nUsed - minResidential) * rateResidential;
      }
      break;
      case 'c':
      amountDue = minBillCommercial;
      if (nUsed > minCommercial) {
        amountDue += (nUsed - minCommercial) * rateCommercial;
      }
      break;
    }

    System.out.println();
    System.out.println("Consumer Name: " + consumer);
    System.out.printf("Last Month's Reading: %d\n", previousReading);
    System.out.printf("Current Month's Reading: %d\n", presentReading);
    System.out.printf("Consumption this Month: %d\n", nUsed);
    System.out.printf("Amount Due: %.2f\n", amountDue);

  }
}
