package love;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project {
    public static final String RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showLoadingScreen();

        boolean exit = false;
        while (!exit) {
            try {
                System.out.println(ANSI_BLACK_BACKGROUND + ANSI_YELLOW + "\n===== MENU =====" + RESET);
                System.out.println(ANSI_CYAN + "1. Calculator");
                System.out.println(ANSI_GREEN + "2. Area & Circumference of Circle");
                System.out.println(ANSI_YELLOW + "3. Area & Perimeter of Rectangle");
                System.out.println(ANSI_BLUE + "4. Convert cm to mm");
                System.out.println(ANSI_PURPLE + "5. Convert cm to m");
                System.out.println(ANSI_RED + "6. Exit");
                System.out.print(ANSI_YELLOW + "Enter your choice: " + RESET);

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
                        break;
                    default:
                        System.out.println(ANSI_RED + "Invalid choice. Please select a valid option." + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Invalid input. Please enter a number." + RESET);
                scanner.next();
            }
        }
        scanner.close();
    }

    public static void showLoadingScreen() {
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_CYAN + "Hello Mabuhay!" + RESET);
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.print(ANSI_WHITE + ".");
            }
        } catch (InterruptedException e) {
            System.out.println(ANSI_RED + "Loading interrupted" + RESET);
        }
        System.out.println("\n" + ANSI_CYAN + "Loading complete!" + RESET);
    }

    public static void calculator(Scanner scanner) {
        boolean backToMenu = false;
        while (!backToMenu) {
            try {
                System.out.print(ANSI_YELLOW + "Enter first number: " + RESET);
                double num1 = scanner.nextDouble();
                System.out.print(ANSI_YELLOW + "Enter operator (+, -, *, /): " + RESET);
                char operator = scanner.next().charAt(0);
                System.out.print(ANSI_YELLOW + "Enter second number: " + RESET);
                double num2 = scanner.nextDouble();

                switch (operator) {
                    case '+':
                        System.out.println(ANSI_GREEN + "RESULT: " + (num1 + num2) + RESET);
                        break;
                    case '-':
                        System.out.println(ANSI_GREEN + "RESULT: " + (num1 - num2) + RESET);
                        break;
                    case '*':
                        System.out.println(ANSI_GREEN + "RESULT: " + (num1 * num2) + RESET);
                        break;
                    case '/':
                        if (num2 != 0) {
                            System.out.println(ANSI_GREEN + "RESULT: " + (num1 / num2) + RESET);
                        } else {
                            System.out.println(ANSI_RED + "Error: Division by zero is not allowed." + RESET);
                        }
                        break;
                    default:
                        System.out.println(ANSI_RED + "Invalid operator. Use +, -, *, or /." + RESET);
                }
                System.out.print(ANSI_CYAN + "Do you want to go back to the menu? (y/n): " + RESET);
                char response = scanner.next().charAt(0);
                if (response == 'y' || response == 'Y') {
                    backToMenu = true;
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Invalid input. Please enter numeric values." + RESET);
                scanner.next();
            }
        }
    }

    public static void circleAreaAndCircumference(Scanner scanner) {
    }

    public static void rectangleAreaAndPerimeter(Scanner scanner) {
    
    }

    public static void cmToMm(Scanner scanner) {
    }

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
            System.out.println(ANSI_RED + "Error: Invalid input. Please enter numeric values." + RESET);
            scanner.next();
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + "Error: " + e.getMessage() + RESET);
        }
    }
                                   }
