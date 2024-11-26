package ICT1M3xGroup2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FinalProject {

    // ANSI color codes
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
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";  
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ANSI_BLACK_BACKGROUND + ANSI_RED + "Do you want to go to the menu? (yes/no): " + RESET );
        String userChoice = scanner.next().toLowerCase();

        if (userChoice.equals("yes")) {
            // Clear the console by overwriting the output and proceed to the menu
        	loadingScreen(2500);
            clearConsole();
            // Proceed to the menu
            boolean exit = false;
            while (!exit) {
                // Show the menu and let the user select an option
                showMenu(scanner);


                if (userChoice.equals("no")) {
                    exit = true;  // Exit the loop
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Exiting the program." + RESET);
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Thank you for using the application. GOOD BYE!" + RESET);
                } else if (!userChoice.equals("yes")) {
                    System.out.println(ANSI_RED + "Invalid input. Please enter 'yes' or 'no'." + RESET);
                }
            }
        } else {
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Exiting the program." + RESET);
            System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Thank you for using the application. GOOD BYE!" + RESET);
        }
        scanner.close();
    }

    // Show the menu after the loading screen
    public static void showMenu(Scanner scanner) {
        boolean exit = false;
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
                    System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Thank you for using the application. GOOD BYE!" + RESET);
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
    
    public static void loadingScreen(long waitTimeMS) {
        String heart = 
                "   *****      *****    \n" +
                "  *******    *******   \n" +
                " *********  *********  \n" +
                "*********************  \n" +
                " *******************   \n" +
                "  *****************    \n" +
                "   ***************     \n" +
                "    *************      \n" +
                "     ***********       \n" +
                "      *********        \n" +
                "       *******         \n" +
                "        *****          \n" +
                "         ***           \n" +
                "          *            \n";
        // Print Heart Art
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED + heart + RESET);
        
        String[] loadingFrames = {"|", "/", "-", "\\"};
        long waitTime = waitTimeMS / 10;
        
        for (int i = 0; i <= 10; i++) {
            String currentFrame = loadingFrames[i % loadingFrames.length];
            System.out.print(ANSI_CYAN  +"Loading... " + currentFrame + " " + i * 10 + "%\r" + RESET );
            
            try {
                TimeUnit.MILLISECONDS.sleep(waitTime);
            } catch (Exception e) {}
        }

        System.out.println("\nHeart Beat Complete!");
    }

    // Clear the console (simulated by overwriting the output)
    public static void clearConsole() {
        for (int i = 0; i <= 100; i++) {
        	System.out.println("\n");
        }
    }

    private static void cmToM(Scanner scanner) {

			try {
				System.out.println("Enter the value in cm: ");
				double cm = scanner.nextDouble();
				
				if (cm < 0 ) {
					throw new IllegalArgumentException("Value cannot be negative.");
				}
				
				double m = cm / 100;			
				System.out.println(ANSI_GREEN + cm + " cm is equal to " + m + " m.");
			} catch (InputMismatchException e) {
				System.out.println(ANSI_RED + "Error: Invalid input. Please enter numeric values. ");
				scanner.next(); // Clear  invalid input
			} catch (IllegalArgumentException e ) {
				System.out.println(ANSI_RED + "Error: " + e.getMessage());
			}
				
    }

    private static void cmToMm(Scanner scanner) {
    
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

    private static void rectangleAreaAndPerimeter(Scanner scanner) {
			try { 
				System.out.print("Enter the Length of the rectangle: ");				
				double length = scanner.nextDouble();
				System.out.print("Enter the width of the rectangle: ");
				double width = scanner.nextDouble();
				
				if(length < 0 || width < 0) {
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
    
    private static void circleAreaAndCircumference(Scanner scanner) {
    		try {
    			System.out.print("Enter the radius of the circle: ");
    			double radius = scanner.nextDouble();
    			
    			if (radius < 0) {
    				throw new IllegalArgumentException("Radius cannot be negative.");
    			}
    			
    			double area = Math.PI * radius * radius;
    			double circumference = 2 * Math.PI * radius;
    			
    			System.out.println("Area of the circle: " + area);
    			System.out.println(ANSI_GREEN + "Circumference of the Circle: " + circumference);
    		} catch (InputMismatchException e) {
    			System.out.println(ANSI_RED + "Error: Invalid input. Pleasee enter numeric values.");
    			scanner.next();  //Clear invalid input
    		} catch (IllegalArgumentException e) {
    			System.out.println(ANSI_RED + "Error: " + e.getMessage() + RESET);
    		}
    		
    	}

    // Basic Calculator with enhanced error handling using integer choices for operations
    public static void calculator(Scanner scanner) {
        while (true) {
            try {
                System.out.print(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "Enter first number: ");
                double num1 = scanner.nextDouble();
                
                System.out.println(ANSI_YELLOW + "Choose an operation:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.print(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "Enter your choice (1-4): ");
                int operatorChoice = scanner.nextInt();

                System.out.print(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "Enter second number: ");
                double num2 = scanner.nextDouble();
                
                switch (operatorChoice) {
                    case 1:
                        System.out.println(ANSI_GREEN + " RESULT: " + (num1 + num2) + RESET);
                        break;
                    case 2:
                        System.out.println(ANSI_GREEN + " RESULT: " + (num1 - num2) + RESET);
                        break;
                    case 3:
                        System.out.println(ANSI_GREEN + " RESULT: " + (num1 * num2) + RESET);
                        break;
                    case 4:
                        if (num2 == 0) {
                            System.out.println(ANSI_RED + "Error: Division by zero is not allowed." + RESET);
                        } else {
                            System.out.println(ANSI_GREEN + " RESULT: " + (num1 / num2) + RESET);                     
                        }
                        break;
                    default:
                        System.out.println(ANSI_BLUE + "Invalid choice. Please select a valid operation (1-4)." + RESET);
                }
                // Ask if the user wants to continue the calculator
                System.out.print(ANSI_YELLOW + "Do you want to continue in Calculator? (yes/no): ");
                String continueChoice = scanner.next().toLowerCase();

                if (continueChoice.equals("no")) {
                    break;  // Exit the calculator loop and return to the main menu
                } else if (!continueChoice.equals("yes")) {
                    System.out.println(ANSI_RED + "Invalid input. Please enter 'yes' or 'no'." + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Invalid input. Please enter numeric values." + RESET);
                scanner.next(); // Clear invalid input              
            } catch (ArithmeticException e) {
                System.out.println(ANSI_RED + "Error: " + e.getMessage() + RESET);
            }
        }
        
    }
}
