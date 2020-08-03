//Kenji Hirai
//September 29, 2019
//CIS2212_05.Fifth Assignment - An Array Calculator

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCalculator {

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
		System.out.println("5. Dot product");
		System.out.println("6. Generate random array");
		System.out.println("7. Quit");
		
		System.out.print("What would you like to do? ");
		userInput = input.nextInt();
		
		while (userInput < 1 || userInput > 7) {
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
			System.out.println("5. Dot product");
			System.out.println("6. Generate random array");
			System.out.println("7. Quit");

			System.out.print("What would you like to do? ");
			userInput = input.nextInt();
			counter++;
			}
			return userInput;
		}

	//getOperand method for operandArray prompt
	public static double[] getOperand(String prompt, int size) {
		
		Scanner input = new Scanner(System.in);
		System.out.println(prompt);
	
		double[] operandArray = new double[size];
	
		for(int i = 0; i < size; i++)
		{
			operandArray[i] = input.nextDouble();
		}
		return operandArray;
	}

	//getOperand Method for prompt
	public static double getOperand(String prompt) {
		
		Scanner input = new Scanner(System.in);
		System.out.println(prompt);

		double number;
		
		number = input.nextDouble();
		return number;
	}
	
	//Addition method
	public static double[] add(double[] operand1, double[] operand2) {

		double[] addResult = new double[operand1.length];

		for(int i = 0; i < operand1.length; i++) {
			addResult[i] = (operand1[i] + operand2[i]);
		}
		return addResult;
	}
	
	//Subtract Method
	public static double[] subtract(double[] operand1, double[] operand2) {
		
		double[] subtractResult = new double[operand1.length];

		for(int i = 0; i < operand1.length; i++) {
			subtractResult[i] = (operand1[i] - operand2[i]);
		}
		return subtractResult;
	}
	

	//Multiply method
	public static double[] multiply(double[] operand1, double[] operand2) {
		
		double[] multiplyResult = new double[operand1.length];	

		for(int i = 0; i < operand1.length; i++) {
			multiplyResult[i] = (operand1[i] * operand2[i]);
		}
		return multiplyResult;
	}
	
	//Divide method
	public static double[] divide(double[] operand1, double[] operand2)	{
		
		double[] divideResult = new double[operand1.length];

		for(int i = 0; i < operand1.length; i++) {
			if(operand2[i] == 0) {
				divideResult[i] = Double.NaN;
			}
			else {
				divideResult[i] = (operand1[i] / operand2[i]);
			}
		}
		return divideResult;
	}

	//Random Method
	public static double[] random(double lowerLimit, double upperLimit, int size) {
		
		double[] randomResult = new double[size];

		for(int i = 0; i < size; i++) {
			randomResult[i] = lowerLimit + Math.random() * (upperLimit - lowerLimit); 							
		}
		return randomResult;
	}
	
	//Dot product method
	public static double dotProduct(double[] operand1, double[] operand2) {

		double dotResult = 0;

		for(int i = 0; i < operand1.length; i++) {
			dotResult += (operand1[i] * operand2[i]);
		}
		return dotResult;
	}
	
	//Main method
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);					
		
		int userInput = 0;
		int arraySize = 0;
		double[] operand1;											
		double[] operand2;
		double[] resultArray;	
		double upperLimit;
		double lowerLimit;
		double dotProductValue;
		
		do {
			userInput = getMenuOption();
				
			switch (userInput) {
			case 1://Add
				System.out.print("How many values are in the arrays? ");
				arraySize = input.nextInt();
	
				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				resultArray = add(operand1, operand2);

				System.out.println("The result is " + Arrays.toString(resultArray));
				break;
	
			case 2://Subtract
				System.out.print("How many values are in the arrays? ");
				arraySize = input.nextInt();

				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				resultArray = subtract(operand1, operand2);

				System.out.println("The result is " + Arrays.toString(resultArray));
				break;
			
			case 3://Multiply
				System.out.print("How many values are in the arrays? ");
				arraySize = input.nextInt();
				
				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				resultArray = multiply(operand1, operand2);

				System.out.println("The result is " + Arrays.toString(resultArray));
				break;
				
			case 4://Divide
				System.out.print("How many values are in the arrays? ");
				arraySize = input.nextInt();
				
				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				resultArray = divide(operand1, operand2);

				System.out.println("The result is " + Arrays.toString(resultArray));
				break;
			
			case 5://Dot product
				System.out.print("How many values are in the arrays? ");
				arraySize = input.nextInt();
		
				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				dotProductValue = dotProduct (operand1, operand2);
		
				System.out.println("The result is " + dotProductValue);
				break;
				
			case 6://Random 
				System.out.print("How many values should be in the random array? ");
				arraySize = input.nextInt();
				
				lowerLimit = getOperand("What is the lower limit for the random number?");
				upperLimit = getOperand("What is the upper limit for the random number?");
				resultArray = random(lowerLimit, upperLimit, arraySize);

				System.out.println("The result is " + Arrays.toString(resultArray));
				break;
				
			case 7://Exit
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			}
		} while(userInput != 7);					
	}	
}