/**
 * Simple Calculator - Basic Arithmetic Operations
 * Difficulty: Easy 🟢
 * Topic: Basic Programming, Methods
 */
import java.util.Scanner;

public class Calculator {
    
    /**
     * Addition operation
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public static double add(double a, double b) {
        return a + b;
    }
    
    /**
     * Subtraction operation
     * @param a first number
     * @param b second number
     * @return difference of a and b
     */
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    /**
     * Multiplication operation
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * Division operation
     * @param a dividend
     * @param b divisor
     * @return quotient of a and b
     * @throws ArithmeticException if b is zero
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
    
    /**
     * Main method with interactive calculator
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Simple Calculator ===");
        System.out.println("Available operations: +, -, *, /");
        System.out.println("Enter 'quit' to exit");
        
        while (true) {
            try {
                System.out.print("\nEnter first number (or 'quit'): ");
                String input = scanner.nextLine();
                
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                
                double num1 = Double.parseDouble(input);
                
                System.out.print("Enter operator (+, -, *, /): ");
                String operator = scanner.nextLine();
                
                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());
                
                double result;
                switch (operator) {
                    case "+":
                        result = add(num1, num2);
                        break;
                    case "-":
                        result = subtract(num1, num2);
                        break;
                    case "*":
                        result = multiply(num1, num2);
                        break;
                    case "/":
                        result = divide(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operator!");
                        continue;
                }
                
                System.out.printf("Result: %.2f %s %.2f = %.2f%n", 
                                num1, operator, num2, result);
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format!");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println("Thank you for using the calculator!");
        scanner.close();
    }
}
