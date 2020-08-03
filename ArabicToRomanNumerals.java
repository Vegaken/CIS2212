//Kenji Hirai
//October 13, 2019
//CIS2212_06.Seventh Assignment - Arabic to Roman Numerals

import java.util.Scanner;

public class ArabicToRomanNumerals {

	public static String arabicToRoman(int arabic) {
		
		int [] arabicArray = {1, 4, 5, 9, 10, 40, 50, 90, 99, 100, 400, 500, 900, 1000};
		String [] romanArray = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "XCIX", "C", "CD", "D", "CM", "M"} ;
	    String result = "";
	    int numAddRoman = 0;
	       
	    for (int i = arabicArray.length-1; i >= 0; i--) {
	    	if(arabic >= arabicArray[i]) {
	    		numAddRoman = arabic / arabicArray[i];
	               while(numAddRoman != 0) {
	        		   result = result + romanArray[i];
	        		   numAddRoman--;
		           } 
	        	   arabic = arabic % arabicArray[i];
	           }
	       }
	       return result;
		}

	public static void main(String[] args) {

	   Scanner input = new Scanner(System.in);
	   int userInput = 0;
	   
	   while(true){
		   System.out.print("\nEnter an integer (-1 to quit): ");
		   userInput = input.nextInt();
		   System.out.print(arabicToRoman(userInput));
		  
		   if (userInput == -1) {
			   	System.out.print("Goodbye!");
		   		System.exit(0);
		   }
		   else if(userInput < 1 || userInput > 3999) {
	    	   System.out.print("The Romans did not have a way to represent negative numbers or zero.");
	       }
	   	}
	}
}

/*

Test Plan:
	
Normal Case: 

1 outputs I
4 outputs IV
9 outputs IX
99 outputs XCIX
500 outputs D
3999 outputs MMMCMXCIX
Reason: They represent of single, double, triple, and four digits. 
	
Invalid Case: Display an error message for numbers outside of this range. 
	 
0 outputs message stating Romans did not have a way to represent negative numbers or zero.
-2 outputs message stating Romans did not have a way to represent negative numbers or zero.
Reason: They don't have a concept of in Roman numeral.	
	 
Boundary Case: 

-1 outputs Goodbye message and quit program.
Reason: -1 has to be handled in a special way.		

*/