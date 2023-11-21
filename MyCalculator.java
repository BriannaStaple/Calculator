package project1;
import java.util.Scanner;

public class MyCalculator{

    public static void main(String[] args) {

    	Scanner input = new Scanner (System.in);
        String mode;
        do {
            System.out.println("Enter the calculator mode: Standard/Scientific?");
            mode = input.nextLine().trim();
        } while (!mode.equalsIgnoreCase("Standard") && !mode.equalsIgnoreCase("Scientific"));

        String operation;
        do {
            if (mode.equalsIgnoreCase("Standard")) {
                System.out.println("The calculator will operate in standard mode.");
                System.out.println("Enter '+' for addition, '-' for subtractions, '*' for multiplication, '/' for division");
            } else {
                System.out.println("Enter '+' for addition, '-' for subtractions, '*' for multiplication, '/' for division, 'sin' for sin x, 'cos' for cos x, 'tan' for tan x:");
            }
            operation = input.nextLine().trim();
            if (mode.equalsIgnoreCase("Scientific") && !operation.matches("[+\\-*/]|(sin|cos|tan)")) {
                System.out.println("Invalid operator " + operation);
                continue;
            }
        } while (!operation.matches("[+\\-*/]|(sin|cos|tan)"));

        int count;
        do {
            System.out.println("How many numbers do you want to " + (operation.equals("sin") || operation.equals("cos") || operation.equals("tan") ? "find the " + operation : operation) + "?");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next();
            }
            count = input.nextInt();
            input.nextLine(); // Consume the remaining newline
        } while (count <= 0);

        double result = 0;
        if (operation.equals("sin") || operation.equals("cos") || operation.equals("tan")) {
            System.out.println("Enter a number in radians to find the " + operation);
            double number = input.nextDouble();
            switch (operation) {
                case "sin":
                    result = Math.sin(number);
                    break;
                case "cos":
                    result = Math.cos(number);
                    break;
                case "tan":
                    result = Math.tan(number);
                    break;
            }
        } else {
            System.out.println("Enter " + count + " numbers:");
            result = input.nextDouble();
            for (int i = 1; i < count; i++) {
                double num = input.nextDouble();
                switch (operation) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "*":
                        result *= num;
                        break;
                    case "/":
                        if (num == 0) {
                            System.out.println("Division by zero is not allowed.");
                            return;
                        }
                        result /= num;
                        break;
                }
            }
        }
        System.out.println("Result: " + result);

        System.out.println("Do you want to start over? (Y/N)");
        String restart = input.next().trim();
        if (!restart.equalsIgnoreCase("Y")) {
           return;
        	   if (!restart.equalsIgnoreCase("N")) {
        		 System.out.println("Goodbye");
        	    }
        	   }
        }
    }
}