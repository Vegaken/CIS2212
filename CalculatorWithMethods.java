//Kenji Hirai
//September 21, 2019
//CIS2212_04.Fourth Assignment - Calculator with Methods

import java.util.Scanner;

public class CalculatorWithMethods {

	//Display the menu and return choice
	public static int getMenuOption() {
		
		int userInput;
		int counter = 0;

		Scanner input = new Scanner(System.in);

		System.out.println("Menu");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Generate Random Number");
		System.out.println("6. Quit");
			
		//User input
		System.out.print("What would you like to do? ");
		userInput = input.nextInt();
		
		while ( userInput < 1 || userInput > 6) {
			if (counter >= 2) {
				System.out.println("I'm sorry, " + userInput + " wasn't one of options.");
				System.out.println("Please try again later.");
				System.exit(0);	
			} 
			
			System.out.println("I'm sorry, " + userInput + " wasn't one of options.");
			
			System.out.println("Menu");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Generate Random Number");
			System.out.println("6. Quit");

			//User input
			System.out.print("What would you like to do? ");
			userInput = input.nextInt();
			counter++;
			}
		return userInput;		
	}
	
	//Display the prompt to the user and read value from the user
	public static double getOperand(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.print(prompt);
		return input.nextDouble();
	}
	
	//Addition method
	public static double add(double operand1, double operand2) {
		operand1 = getOperand("What is the first number? "); 
		operand2 = getOperand("What is the second number? "); 
		double result = operand1 + operand2; 
		return result;
	}
	
	//Subtract method
	public static double subtract(double operand1, double operand2) {
		operand1 = getOperand("What is the first number? "); 
		operand2 = getOperand("What is the second number? "); 
		double result = operand1 - operand2; 
		return result;
	}
	
	//Multiply method
	public static double multiply(double operand1, double operand2) {
		operand1 = getOperand("What is the first number? "); 
		operand2 = getOperand("What is the second number? "); 		
		double result = operand1 * operand2;
		return result;
	}
	
	//DIvide method
	public static double divide(double operand1, double operand2) {
		operand1 = getOperand("What is the first number? "); 
		operand2 = getOperand("What is the second number? "); 		
		double result = operand1 / operand2;
		if (operand2 == 0) 
			result = Double.NaN;
		return result;
	}
	
	//Random method
	public static double random(double lowerLimit, double upperLimit) {
		lowerLimit = getOperand("What is the lower limit? "); 
		upperLimit = getOperand("What is the upper limit? "); 		
		double result = lowerLimit + Math.random() * (upperLimit-lowerLimit); 
		return result; 
	}
	
	//Main method
	public static void main(String[] args) {
		
		//Variables
		int userInput;
		double operand1 = 0;
		double operand2 = 0;
		double lowerLimit = 0;
		double upperLimit = 0;
		double result = 0;
		
		do {
		
		userInput = getMenuOption();
		
		switch(userInput) {
		case 1://Add
			result = add(operand1,operand2);
			System.out.println("Answer:" + result);
			break;
		case 2://Subtract 
			result = subtract(operand1,operand2);
			System.out.println("Answer:" + result);
			break;
		case 3://Multiply 
			result = multiply(operand1,operand2);
			System.out.println("Answer:" + result);			
			break;
		case 4://Divide
			result = divide(operand1,operand2);
			System.out.println("Answer:" + result);			
			break;
		case 5://Generate Random Number
			result = random(lowerLimit,upperLimit);
			System.out.println("Answer:" + result);			
			break;
		case 6:
			System.out.print("Good bye!");
			System.exit(0);
			break;
			}		
		}while(userInput != 6);
		}
	}