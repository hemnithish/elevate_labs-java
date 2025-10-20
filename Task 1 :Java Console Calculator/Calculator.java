import java.util.Scanner;

public class Calculator {

    // --- Arithmetic Methods ---
    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    // --- Main Program ---
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char continueCalc='y';

        System.out.println("---------- Simple Calculator ----------");

        do {
            System.out.print("Enter first number: ");
            double num1 = input.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = input.nextDouble();

            System.out.print("Choose operation (+, -, *, /): ");
            char operator = input.next().charAt(0);

            double result;

            switch (operator) {
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    break;
                case '/':
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operator. Please try again.");
                    continue;
            }

            System.out.println("Result: " + result);

            System.out.print("Do you want to continue? (y/n): ");
            continueCalc = input.next().charAt(0);

            System.out.println();

        } while (continueCalc == 'y' || continueCalc == 'Y');

        System.out.println("Program terminated. Thank you!");
        input.close();
    }
}
