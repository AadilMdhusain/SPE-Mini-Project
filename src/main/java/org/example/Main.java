package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.println("\n--- Scientific Calculator ---");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Log (ln x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            if (choice == 5) {
                System.out.println("Exiting Calculator...");
                break;
            }

            double num, result;
            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    num = scanner.nextDouble();
                    if (num < 0) {
                        System.out.println("Error: Square root of negative number is not defined.");
                    } else {
                        result = calc.sqrt(num);
                        System.out.println("√" + num + " = " + result);
                    }
                    break;

                case 2:
                    System.out.print("Enter a non-negative integer: ");
                    int n = scanner.nextInt();
                    if (n < 0) {
                        System.out.println("Error: Factorial of negative number is not defined.");
                    } else {
                        long factResult = calc.factorial(n);
                        System.out.println(n + "! = " + factResult);
                    }
                    break;

                case 3:
                    System.out.print("Enter a positive number: ");
                    num = scanner.nextDouble();
                    if (num <= 0) {
                        System.out.println("Error: Logarithm of zero or negative number is not defined.");
                    } else {
                        result = calc.ln(num);
                        System.out.println("ln(" + num + ") = " + result);
                    }
                    break;

                case 4:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exponent = scanner.nextDouble();
                    result = calc.power(base, exponent);
                    System.out.println(base + "^" + exponent + " = " + result);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
