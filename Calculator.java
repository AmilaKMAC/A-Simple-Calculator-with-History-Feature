import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private static final List<String> calculationHistory = new ArrayList<>();

    // Operations 
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static Double divide(double a, double b) {
        if (b == 0) {
            System.out.println("float division by zero");
            return null;
        }
        return a / b;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double remainder(double a, double b) {
        return a % b;
    }

    // Print history
    public static void history() {
        if (calculationHistory.isEmpty()) {
            System.out.println("No past calculations to show");
        } else {
            for (String calc : calculationHistory) {
                System.out.println(calc);
            }
        }
    }

    // Selection
    public static int selectOp(String choice, Scanner sc) {
        if (choice.equals("#")) {
            return -1; // terminate
        } else if (choice.equals("$")) {
            return 0; // reset
        } else if (choice.equals("?")) {
            history();
            return 1;
        } else if ("+-*/^%".contains(choice)) {
            double num1, num2;

            // First number
            while (true) {
                System.out.print("Enter first number: ");
                String input = sc.next();
                if (input.endsWith("$")) return 0;
                if (input.endsWith("#")) return -1;
                try {
                    num1 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Not a valid number, please enter again");
                }
            }

            //Second number
            while (true) {
                System.out.print("Enter second number: ");
                String input = sc.next();
                if (input.endsWith("$")) return 0;
                if (input.endsWith("#")) return -1;
                try {
                    num2 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Not a valid number, please enter again");
                }
            }

            // Calculation 
            Double result = null;
            switch (choice) {
                case "+": result = add(num1, num2); break;
                case "-": result = subtract(num1, num2); break;
                case "*": result = multiply(num1, num2); break;
                case "/": result = divide(num1, num2); break;
                case "^": result = power(num1, num2); break;
                case "%": result = remainder(num1, num2); break;
                default: System.out.println("Something went wrong"); return 1;
            }

            //Save and print result
            String lastCalculation;
            if (result != null) {
                lastCalculation = String.format("%s %s %s = %s", num1, choice, num2, result);
            } else {
                lastCalculation = String.format("%s / %s = None", num1, num2);
            }
            calculationHistory.add(lastCalculation);
            System.out.println(lastCalculation);

            return 1;
        } else {
            System.out.println("Unrecognized operation");
            return 1;
        }
    }

    //Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Select operation.");
            System.out.println("1.Add      : + ");
            System.out.println("2.Subtract : - ");
            System.out.println("3.Multiply : * ");
            System.out.println("4.Divide   : / ");
            System.out.println("5.Power    : ^ ");
            System.out.println("6.Remainder: % ");
            System.out.println("7.Terminate: # ");
            System.out.println("8.Reset    : $ ");
            System.out.println("9.History  : ? ");

            System.out.print("Enter choice (+,-,*,/,^,%,#,$,?): ");
            String choice = sc.next();

            int result = selectOp(choice, sc);

            if (result == -1) {
                System.out.println("Done. Terminating");
                break;
            } else if (result == 0) {
                System.out.println("Resetting...");
                calculationHistory.clear();
            }
        }

        sc.close();
    }
}
