import java.util.Scanner;

public class ScientificMemCalc extends MemoryCalc {

	public ScientificMemCalc() {
		
	}
	
	@Override
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
			System.out.println("5. power");
			System.out.println("6. Logarithm");
			System.out.println("7. Clear");
			System.out.println("8. Quit");
			System.out.println();
			System.out.print("What would you like to do? ");

			choice = input.nextInt();

			if (choice < 1 || choice > 8) {
				System.out.println(choice + " wasn't one of the options");
			}

			if (choice == 8) {
				System.out.println("Goodbye!");
				System.exit(0);
			}
		}
		return choice;
	}
	
	public void power(double op2) {
		setCurrentValue(java.lang.Math.pow(getCurrentValue(), op2));
	}
	

	public void logarithm(double op2) {
		setCurrentValue(java.lang.Math.log(getCurrentValue()));
	}
}