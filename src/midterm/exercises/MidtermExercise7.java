/**
 * Name: Iori Z. Pimentel
 * Date: Oct 17, 2022
 * Activity Name and Number: Midterm Exercise Program 7
 ------------------------------------------------------------
The bill for a water service subscriber is prepared as follows:
    1. Read the name of the water consumer
    2. Read the previous water meter reading in cubic meters (reading last month) from the
    consumer’s meter.
    The meter reading cannot be less than zero.
    3. Read the present water meter reading in cubic meters (reading this month) from the
    consumer’s meter.
    The present water meter reading cannot be less than the previous water meter reading.
    4. Compute the volume of water consumed (consumption = CMUSed) by subtracting the
    previous reading from the present reading.
    5. Read the classification of the consumer (c for commercial or r for residential)
    6. Compute the amount due from the consumer. The amount due is computed based on the
    following
    For residential consumers
    If Cubic Meters Consumed is then Amount Due (pesos)
    ==============================================
    Less than or equal to 12 180.00
    More than 12 180.00 + (cubicMetersConsumed – 12) * 30.00

    For commercial consumers
    If Cubic Meters Consumed is then Amount Due (pesos)
    ==============================================
    Less than or equal to 30 600.00
    More than 30 600.00 + (cubicMetersConsumed – 30) * 50.00
    7. Print a bill statement. The bill statement should show the name of the subscriber, the readings,
    the consumption and the amount due.
    Required:
    Complete the following program for the Water Bill problem described above.
    The program should provide validation of data entries so that the billing process will be
    constrained to dealing with valid values.
 */
package midterm.exercises;
import java.util.Scanner;
public class MidtermExercise7 {
    public static void main(String[] args) {
        int presentReading, previousReading;
        Scanner keyboard = new Scanner(System.in);
        String consumer; // to hold name of consumer
        char cType; // to hold type of consumer

        int nCMUsed; // to hold number of cubic meters of water used
        int minCMResidential = 12; // to hold cut-off for minimum Bill for residential consumers
        double minBillResidential = 180.00; // minimum bill for <= 12 Cubic Meters used
        float rateResidential = 30.00F; // cost of 1 Cubic Meter above the min. consumption
        int minCMCommercial = 30; /* to hold cut-off for minimum Bill for commercial consumers */
        double minBillCommercial = 600.00; // minimum bill for <= 20Cubic Meters used
        float rateCommercial = 50.00F; /* cost of 1 Cubic Meter above the min. consumption for commercial consumers */
        double amountDue = 0.0; // to hold the amount due

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

        nCMUsed = presentReading - previousReading;

        while (true) {
            System.out.print("Enter the classification as a consumer: ");
            cType = keyboard.nextLine().toLowerCase().charAt(0);

            if (!(cType == 'r' || cType == 'c'))
                System.out.println("Invalid classification...");
            else break;
        }

        switch (cType) {
            case 'r':
                amountDue = minBillResidential;
                if (nCMUsed > minCMResidential) {
                    amountDue += (nCMUsed - minCMResidential) * rateResidential;
                }
                break;
            case 'c':
                amountDue = minBillCommercial;
                if (nCMUsed > minCMCommercial) {
                    amountDue += (nCMUsed - minCMCommercial) * rateCommercial;
                }
                break;
        }

        System.out.println();
        System.out.println("Consumer Name: " + consumer);
        System.out.printf("Last Month's Reading: %d\n", previousReading);
        System.out.printf("Current Month's Reading: %d\n", presentReading);
        System.out.printf("Consumption this Month: %d\n", nCMUsed);
        System.out.printf("Amount Due: %.2f\n", amountDue);

    } // end of main
} // end of class
