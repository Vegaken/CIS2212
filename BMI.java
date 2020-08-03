//Kenji Hirai
//August 29, 2019
//CIS2212_01.First Assignment-Calculate BMI

import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		
		// Variables
		double weight;
		double height;
		double bmi;
		double targetBMI;
		double targetWeight;
		
		Scanner input = new Scanner(System.in);
		
		// User input
		System.out.print("How much do you weight in ponds?: ");
		weight = input.nextDouble();
		System.out.print("How tall are you in inches?: ");
		height = input.nextDouble();
		
		// BMI formula
		bmi = (weight / (height * height)) * 703;

		// Output for BMI
		System.out.print("Your BMI is " + bmi);
		System.out.print("\nA BMI between 20 and 24 is considered ideal. What would you like your BMI to be?: ");
		targetBMI = input.nextDouble();
		
		// Output for target weight
		targetWeight = (targetBMI / 703) * (height * height);
		System.out.print("Your weight needs to be " + targetWeight + " pounds for your BMI to be " + targetBMI );
		
		input.close();	
	}
}
