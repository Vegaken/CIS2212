//Kenji Hirai
//September 5, 2019
//CIS2212_02.Second Assignment-Basic Calculator

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		//Variables
		int userInput;
		double firstNum;
		double secondNum;
		
		Scanner input = new Scanner(System.in);
		
		//Menu
		System.out.println("Menu");
		System.out.println("1, Add");
		System.out.println("2, Subtract");
		System.out.println("3, Multiply");
		System.out.println("4, Divide");
		System.out.println("5, Generate Random Number");
	
		//User input
		System.out.print("What would you like to do? ");
		userInput = input.nextInt();
		
		//Calculate and output for user's choice
		switch(userInput) {
		case 1://Add
			System.out.print("What is the first number? ");
			firstNum = input.nextDouble();
			System.out.print("What is the second number? ");
			secondNum = input.nextDouble();
			System.out.println("Answer:" + (firstNum + secondNum));
			break;
		case 2://Subtract 
			System.out.print("What is the first number? ");
			firstNum = input.nextDouble();
			System.out.print("What is the second number? ");
			secondNum = input.nextDouble();
			System.out.println("Answer:" + (firstNum - secondNum));			
			break;
		case 3://Multiply 
			System.out.print("What is the first number? ");
			firstNum = input.nextDouble();
			System.out.print("What is the second number? ");
			secondNum = input.nextDouble();
			System.out.println("Answer:" + (firstNum * secondNum));
			break;
		case 4://Divide
			System.out.print("What is the first number? ");
			firstNum = input.nextDouble();
			System.out.print("What is the second number? ");
			secondNum = input.nextDouble();
			if ( secondNum == 0) {
				System.out.println("I'm sorry, you can't divide by zero.");
			}
			else {
			System.out.println("Answer:" + (firstNum / secondNum));		
			}
			break;
		case 5://Generate Random Number
			System.out.print("What is the lower limit? ");
			firstNum = input.nextDouble();
			System.out.print("What is the upper limit? ");
			secondNum = input.nextDouble();
			System.out.println("Answer:" + (firstNum + Math.random() * (secondNum-firstNum)));
			break;
		default://Invalid choice
			System.out.print("I'm sorry, " + userInput + " wasn't one of options.");
		}
		input.close();		
	}
}