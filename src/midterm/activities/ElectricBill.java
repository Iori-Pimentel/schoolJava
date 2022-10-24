package midterm.activities;

import java.util.Scanner;

public class ElectricBill {
    public static void main(String[] args) {
        System.out.println("Program to calculate the bill for electric service subscriber" +
                "given the ");

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
                System.out.println("Invalid Value...");
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

    }
}
