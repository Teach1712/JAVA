import java.util.Scanner;

// Parent class
class Addition {
    double num1, num2;
    
    void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        num2 = sc.nextDouble();
    }
    
    void add() {
        double result = num1 + num2;
        System.out.println("Result of Addition: " + result);
    }
}

// Child 1 of Addition
class Subtraction extends Addition {
    void subtract() {
        double result = num1 - num2;
        System.out.println("Result of Subtraction: " + result);
    }
}

// Child 2 of Subtraction
class Multiplication extends Subtraction {
    void multiply() {
        double result = num1 * num2;
        System.out.println("Result of Multiplication: " + result);
    }
}

// Lowest Child of Multiplication
class Division extends Multiplication {
    void divide() {
        if(num2 != 0) {
            double result = num1 / num2;
            System.out.println("Result of Division: " + result);
        } else {
            System.out.println("Error: Division by zero not allowed");
        }
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Division obj = new Division(); // object of lowest child class
        
        System.out.println("=== Simple Calculator ===");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction"); 
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        // Take input once, then use in switch
        obj.getInput();
        
        // Switch logic
        switch(choice) {
            case 1:
                obj.add();
                break;
            case 2:
                obj.subtract();
                break;
            case 3:
                obj.multiply();
                break;
            case 4:
                obj.divide();
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
}