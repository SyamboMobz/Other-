package testing;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    // ANSI color codes 
    public static final String RESET = "\u001B[0m"; // Reset code
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    public static void main(String[] args) {                        
        Scanner scanner = new Scanner(System.in);
        
        // Show loading screen at the beginning
        showLoadingScreen();
        
        boolean exit = false;       
        while (!exit) {
            try {
                System.out.println(ANSI_BLACK_BACKGROUND + ANSI_YELLOW + "\n===== MENU ======" + RESET);
                System.out.println(ANSI_CYAN + "1. Calculator");
                System.out.println(ANSI_GREEN + "2. Area & Circumference of Circle");
                System.out.println(ANSI_YELLOW + "3. Area & Perimeter of Rectangle");
                System.out.println(ANSI_BLUE + "4. Convert cm to mm");
                System.out.println(ANSI_PURPLE + "5. Convert cm to m");
                System.out.println(ANSI_RED + "6. Exit");
                System.out.print(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "Enter your choice: " + RESET);
                
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        calculator(scanner);
                        break;
                    case 2:
                        circleAreaAndCircumference(scanner);
                        break;
                    case 3:
                        rectangleAreaAndPerimeter(scanner);
                        break;
                    case 4:
                        cmToMm(scanner);
                        break;
                    case 5:
                        cmToM(scanner);
                        break;
                    case 6:
                        exit = true;          
                        
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Exiting the program." + RESET);
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Thank you _ for using my application. GOOD BYE!" + RESET);
                        break;
                    default:
                        System.out.println(ANSI_RED + "Invalid choice. Please select a valid option." + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Invalid input. Please enter a number." + RESET);  
                scanner.next(); // Clear invalid input    
            } catch (Exception e) {
                System.out.println(ANSI_RED + "An unexpected error occurred: " + e.getMessage() + RESET);
            }                
        }
        scanner.close();
    }

    // Loading screen method
    public static void showLoadingScreen() {
    	System.out.println(ANSI_BLACK_BACKGROUND + ANSI_CYAN + "Hello Mabuhay!" + RESET);
        
        try { 
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500); // Wait for 0.5 seconds
                System.out.print(ANSI_WHITE + ".");
            }
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_CYAN + "Loading interrupted" + RESET);            
        }
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_CYAN + "\nLoading complete!\n" + RESET);
    }

    // Basic Calculator with enhanced error handling
    public static void calculator(Scanner scanner) {
        while (true) {
            try {
                System.out.print(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "Enter operator (+, -, *, /): ");
                char operator = scanner.next().charAt(0);
                System.out.print(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "Enter second number: ");
                double num2 = scanner.nextDouble();
                
                switch (operator) {
                    case '+':
                        System.out.println(ANSI_GREEN + " RESULT: " + (num1 + num2) + RESET);
                        break;
                    case '-':
                        System.out.println(ANSI_GREEN + " RESULT: " + (num1 - num2) + RESET);
                        break;
                    case '*':
                        System.out.println(ANSI_GREEN + " RESULT: " + (num1 * num2) + RESET);
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println(ANSI_RED +  "Error: Division by zero is not allowed." + RESET);
                        } else {
                            System.out.println(ANSI_GREEN + " RESULT: " + (num1 / num2) + RESET);                     
                        }
                        break;
                    default:
                        System.out.println(ANSI_BLUE + "Invalid operator. Please use +, -, *, or /." + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Invalid input. Please enter numeric values." + RESET);
                scanner.next(); // Clear invalid input             
            } catch (ArithmeticException e) {
                System.out.println(ANSI_RED + "Error: " + e.getMessage() + RESET);
            }
        }
    }

    // Area & Circumference of Circle with enhanced error handling
    public static void circleAreaAndCircumference(Scanner scanner) {
        try {
            System.out.print("Enter the radius of the circle: ");
            double radius = scanner.nextDouble();
            
            if (radius < 0) {
                throw new IllegalArgumentException("Radius cannot be negative.");
            }
            
            double area = Math.PI * radius * radius;
            double circumference = 2 * Math.PI * radius;
            
            System.out.println("Area of the circle: " + area);
            System.out.println(ANSI_GREEN + "Circumference of the Circle: " + circumference + RESET);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Error: Invalid input. Please enter numeric values." + RESET);
            scanner.next();  // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + "Error: " + e.getMessage() + RESET);
        }
    }

    // Area & Perimeter of Rectangle
    public static void rectangleAreaAndPerimeter(Scanner scanner) {
        try { 
            System.out.print("Enter the Length of the rectangle: ");                
            double length = scanner.nextDouble();
            System.out.print("Enter the width of the rectangle: ");
            double width = scanner.nextDouble();
            
            if (length < 0 || width < 0) {
                throw new IllegalArgumentException("Length and width cannot be negative.");
            }
            
            double area = length * width;
            double perimeter = 2 * (length + width);            
            System.out.println(ANSI_GREEN + "Area of the rectangle: " + area + RESET);
            System.out.println(ANSI_GREEN + "Perimeter of the rectangle: " + perimeter + RESET);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Error: Invalid input. Please enter numeric values." + RESET);
            scanner.next(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + "Error: " + e.getMessage() + RESET);
        }
    }

    // Conversion: cm to mm with error handling
    public static void cmToMm(Scanner scanner) {
        try {
            System.out.print("Enter the value in cm: ");
            double cm = scanner.nextDouble();
            
            if (cm < 0) {
                throw new IllegalArgumentException("Value cannot be negative.");
            }
            double mm = cm * 10;
            System.out.println(ANSI_GREEN + cm + " cm is equal to " + mm + " mm." + RESET);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Error: Invalid input. Please enter numeric values." + RESET);
            scanner.next(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + "Error: " + e.getMessage() + RESET);
        }                  
    }

    // Conversion: cm to m with error handling
    public static void cmToM(Scanner scanner) {
        try {
            System.out.print("Enter the value in cm: ");
            double cm = scanner.nextDouble();
            
            if (cm < 0) {
                throw new IllegalArgumentException("Value cannot be negative.");
            }
            
            double m = cm / 100;            
            System.out.println(ANSI_GREEN + cm + " cm is equal to " + m + " m." + RESET);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Error: Invalid input. Please");
} 
    }
}
