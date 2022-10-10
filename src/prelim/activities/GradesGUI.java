/**
 * Name: Iori Z. Pimentel
 * Date: Sep 21, 2022
 * Class Code and Course Number: 9315 - CS 112
 -----------------------------------------------------------------
 Input: The user's three grades using Scanner
 Processes: Find the average of the user's grades.
 ------------------------------------------------------------------
 Algorithm:
 1. avg = (g1 + g2 + g3) / 3
 -------------------------------------------------------------------
 Output: Average Grade
 Display results and a Remark
 */


package prelim.activities;

import netscape.javascript.JSObject;

import javax.swing.*;
import java.util.Scanner;

public class GradesGUI {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Program to calculate score average");

        double firstGrade = Double.parseDouble(JOptionPane.showInputDialog("What is your first grade? "));
        double secondGrade = Double.parseDouble(JOptionPane.showInputDialog("What is your second grade? "));
        double thirdGrade = Double.parseDouble(JOptionPane.showInputDialog("What is your third grade? "));

        double avg = (firstGrade + secondGrade + thirdGrade) / 3;

        JOptionPane.showMessageDialog(null, String.format("Your grade average is %.2f\n", avg));

        if (avg < 75)
            JOptionPane.showMessageDialog(null, ":-(");
        else
            JOptionPane.showMessageDialog(null, "Good Job");
    }
}
