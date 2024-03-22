package org.example.question2;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        try {
            int result = divideoperation(dividend, divisor);
            System.out.println("Result" + result);
        } catch (DivisionException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        }
    }

    public static int divideoperation(int dividend, int divisor) throws DivisionException {
        try {
            int result = dividend / divisor;
            System.out.println("Division completed with dividend: " + dividend + " and divisor: " + divisor);
            return result;
        } catch (ArithmeticException e) {
            System.out.println("Error occurred: " + e.getMessage());
            throw new DivisionException("Please enter valid divisor");
        }
    }
}
