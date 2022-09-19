/**
 * Create a program that uses the for statement to computes the value of
 * base raised to exponent
 * where base and exponent are whole numbers that are
 * entered at program runtime
 *
 *
 INPUT: base, exponent
 OUTPUT: value of base raised to exponent

 ALGORITHM:
   1. Declare variables for base, exponent and valueOfPower
   2. Prompt the program user to enter the value of base
   3. Let the computer accept the value of base
   4. Prompt the program user to enter the value of exponent
   5. Let the computer accept the value of exponent
   6. Initialize valueOfPower to 1;
   7. for ( x= 1 to exponent )
        let valueOfPower = valueOfPower*base
   8. Show the value of power
 * */
package prelim.samples;

import com.sun.jdi.Value;

import java.util.Scanner;

public class DemoClass1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("""
                \nThis program will compute the value of base raised to exponent \
                where exponent is a small integer.
                You will be asked to enter the value of base and the exponent.\n""");



        System.out.print("Enter the value of base: ");
        int base = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter the value of exponent which must be a small integer: ");
        int exponent = Integer.parseInt(keyboard.nextLine());

        int valueOfPower = 1;
        for (int i = 0; i < exponent; i++) {
            valueOfPower *= base;
        }

        System.out.printf("The value of %d raised to %d is %,d.\n", base, exponent, valueOfPower);

        System.exit(0);
    }
}
