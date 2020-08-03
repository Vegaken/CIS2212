import java.util.Scanner;

public class MemoryCalc {

	private double currentValue = 0.0;
	
	MemoryCalc() {
		
	}
	
	
	public double getCurrentValue() {
		return currentValue;
	}
	
	
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	
	public int displayMenu() {
		Scanner input = new Scanner(System.in);

		int choice = -1;

		while (choice < 1 || choice > 6) {
			System.out.println();
			System.out.println("Menu");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Clear");
			System.out.println("6. Quit");
			System.out.println();
			System.out.print("What would you like to do? ");

			choice = input.nextInt();

			if (choice < 1 || choice > 6) {
				System.out.println(choice + " wasn't one of the options");
			}

			if (choice == 6) {
				System.out.println("Goodbye!");
				System.exit(0);
			}
		}

		return choice;
	}


	public double getOperand(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.print(prompt);
		return input.nextDouble();
	}


	public void add(double op2) {
		currentValue += op2;
	}


	public void subtract(double op2) {
		currentValue -= op2;
	}


	public void multiply(double op2) {
		currentValue *= op2;
	}


	public void divide(double op2) {
		if (op2 == 0) {
			currentValue = Double.NaN;
		} else {
			currentValue /= op2;
		}
	}
	
	public void clear() {
		currentValue = 0;
	}
}
