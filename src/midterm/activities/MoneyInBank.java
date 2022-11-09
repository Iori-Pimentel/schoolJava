package midterm.activities;

import javax.swing.*;
import java.util.Scanner;

public class MoneyInBank {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        float annualRate;
        float quarterlyRate;
        double principal;
        double interest;
        double finalAmount;
        double depositAmount;
        double withdrawAmount;
        byte quarter;
        int year;
        char opt;

        annualRate = 0.05F; 

        System.out.print("Enter the year: ");
        year = Integer.parseInt(keyboard.nextLine()); 
        System.out.print("Enter the initial principal: ");
        principal = Double.parseDouble(keyboard.nextLine()); 
        System.out.printf("%s%.2f%n", "Principal = ", principal); 
        System.out.printf("%s%.2f%c%n", "Interest Rate = ", annualRate * 100, '%');
        quarterlyRate = annualRate / 4; 
        finalAmount = principal;


        for (quarter = 1; quarter <= 4; quarter++) {
            while (true) {
                System.out.print("Pick an Option: ");
                System.out.println("[d]Deposit\t[w]Withdraw\t[c]Continue\t[q]Quit");
                opt = keyboard.nextLine().toLowerCase().charAt(0);

                if (!(opt == 'd' || opt == 'w' || opt == 'c' || opt == 'q'))
                    System.out.println("Invalid option...");
                else break;
            }

            switch (opt) {
                case 'd':
                    while (true) {
                        System.out.print("Enter the Deposit Amount: ");
                        depositAmount = Double.parseDouble(keyboard.nextLine());

                        if (depositAmount < 0)
                            System.out.println("The Deposit Amount cannot be negative.");
                        else break;
                    }
                    finalAmount += depositAmount;
                    System.out.println("Deposit Amount: " + depositAmount);
                    break;
                case 'w':
                    while (true) {
                        System.out.print("Enter the Withdraw Amount: ");
                        withdrawAmount = Double.parseDouble(keyboard.nextLine());

                        if (withdrawAmount < 0)
                            System.out.println("The Withdraw Amount cannot be negative.");
                        else break;
                    }
                    finalAmount -= withdrawAmount;
                    System.out.println("Withdraw Amount: " + withdrawAmount);
                    break;
                case 'c':
                    System.out.println("Continuing without Depositing or Withdrawing...");
                    break;
                case 'q':
                    System.out.println("Closing the Program...");
                    System.exit(0);
                    break;
            }
            principal = finalAmount; 
            interest = principal * quarterlyRate; 
            finalAmount = principal + interest;
            System.out.printf("%6s%8s%16s%30s%n", "Year", "Quarter", "Interest", "Amount");
            System.out.printf("%6s%8d%16.2f%30.2f%n", year, quarter, interest, finalAmount);
        }

        System.exit(0);
    } 
}
