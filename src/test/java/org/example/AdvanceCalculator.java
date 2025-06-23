package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class AdvanceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation;

        System.out.println("Welcome to Advanced Calculator");
        System.out.println("Available Operations:");
        System.out.println("1. + : Addition");
        System.out.println("2. - : Subtraction");
        System.out.println("3. * : Multiplication");
        System.out.println("4. / : Division");
        System.out.println("5. % : Modulus");
        System.out.println("6. ^ : Power");
        System.out.println("7. s : Square Root (uses first number only)");
        System.out.println("8. a : Absolute Value (uses first number only)");
        System.out.println("9. f : Factorial (uses first number only)");
        System.out.println("10. i : Sine (uses first number only, in degrees)");
        System.out.println("11. c : Cosine (uses first number only, in degrees)");
        System.out.println("12. t : Tangent (uses first number only, in degrees)");
        System.out.println("13. l : Natural Logarithm (uses first number only)");
        System.out.println("Enter 'q' to quit");

        while (true) {
            System.out.print("\nEnter operation: ");
            operation = scanner.next();

            if (operation.equals("q")) {
                System.out.println("Exiting calculator.");
                break;
            }

            double num1 = 0, num2 = 0;
            boolean unary = operation.matches("[safictl]");

            try {
                System.out.print("Enter first number: ");
                num1 = scanner.nextDouble();

                if (!unary) {
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                }

                switch (operation) {
                    case "+":
                        System.out.printf("%.2f + %.2f = %.2f%n", num1, num2, num1 + num2);
                        break;
                    case "-":
                        System.out.printf("%.2f - %.2f = %.2f%n", num1, num2, num1 - num2);
                        break;
                    case "*":
                        System.out.printf("%.2f * %.2f = %.2f%n", num1, num2, num1 * num2);
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero");
                        } else {
                            System.out.printf("%.2f / %.2f = %.2f%n", num1, num2, num1 / num2);
                        }
                        break;
                    case "%":
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero");
                        } else {
                            System.out.printf("%.2f %% %.2f = %.2f%n", num1, num2, num1 % num2);
                        }
                        break;
                    case "^":
                        System.out.printf("%.2f ^ %.2f = %.2f%n", num1, num2, Math.pow(num1, num2));
                        break;
                    case "s":
                        System.out.printf("√%.2f = %.2f%n", num1, Math.sqrt(num1));
                        break;
                    case "a":
                        System.out.printf("|%.2f| = %.2f%n", num1, Math.abs(num1));
                        break;
                    case "f":
                        if (num1 < 0 || num1 != (int) num1) {
                            System.out.println("Error: Factorial is only defined for non-negative integers");
                        } else {
                            System.out.printf("%.0f! = %.2f%n", num1, (double) factorial((int) num1));
                        }
                        break;
                    case "i":
                        System.out.printf("sin(%.2f°) = %.2f%n", num1, Math.sin(Math.toRadians(num1)));
                        break;
                    case "c":
                        System.out.printf("cos(%.2f°) = %.2f%n", num1, Math.cos(Math.toRadians(num1)));
                        break;
                    case "t":
                        System.out.printf("tan(%.2f°) = %.2f%n", num1, Math.tan(Math.toRadians(num1)));
                        break;
                    case "l":
                        if (num1 <= 0) {
                            System.out.println("Error: Natural logarithm is only defined for positive numbers");
                        } else {
                            System.out.printf("ln(%.2f) = %.2f%n", num1, Math.log(num1));
                        }
                        break;
                    default:
                        System.out.println("Invalid operation! Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid number input. Please try again.");
                scanner.nextLine(); // Clear buffer
            }
        }

        scanner.close();
    }

    // Helper method to calculate factorial
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

