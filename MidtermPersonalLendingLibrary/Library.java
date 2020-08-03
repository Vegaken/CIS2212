//Kenji Hirai
//October 24, 2019
//CIS2212_A.Midterm Project - A Personal Lending Library

import java.util.Arrays;
import java.util.Scanner;


public class Library {

	MediaItem[] items = new MediaItem[100];
	int numberOfItems;
	
	public Library() {
	
	}
	
	public static int displayMenu() {
		int userInput;
		int counter = 0;									
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n" + "Menu");
		System.out.println("1. Add new item");
		System.out.println("2. Mark an item as on loan");
		System.out.println("3. List all items");										
		System.out.println("4. Mark an item as returned");
		System.out.println("5. Quit");
		
		System.out.print("What would you like to do? ");
		userInput = input.nextInt();
		
		while (userInput < 1 || userInput > 5) {
			 
			System.out.println("I'm sorry, " + userInput + " wasn't one of options.");
			
			System.out.println("\n" + "Menu");
			System.out.println("1. Add new item");
			System.out.println("2. Mark an item as on loan");
			System.out.println("3. List all items");										
			System.out.println("4. Mark an item as returned");
			System.out.println("5. Quit");

			System.out.print("What would you like to do? ");
			userInput = input.nextInt();
			counter++;
			}
			return userInput;	
	}
	
	public void addNewItem(String title, String format) {
		items[numberOfItems] = new MediaItem(title, format);
		numberOfItems++;
	}
	
	public void markItemOnLoan(String title, String name, String date) {
		boolean find = false;
		
		for (int i = 0; i < numberOfItems && !find; i++) {
			if (items[i].getTitle().equals(title)) {
			items[i].markOnLoan(name, date);
			find = true;
			}
		}
		if (!find) {
			System.out.println("I'm sorry, I couldn't find " + title + " in the library.");
		}
	}
	
	public String[] listAllItems() {
		String stringArray[] = new String[numberOfItems];
		
		for (int i = 0; i < numberOfItems; i++) {
			if (items[i].getonloan() == true) {
				stringArray[i] = items[i].getTitle() + "(" + items[i].getFormat() + ")" + " loaned to " + items[i].getLoanedTo() + " on " + items[i].getDateLoaned(); 
			}
			else {
				stringArray[i] = items[i].getTitle() + "(" + items[i].getFormat() + ")";
			}
		}
		return stringArray;
	}
	
	public void markItemReturned(String title) {
		boolean find = false;
		
		for (int i = 0; i < numberOfItems && !find; i++) {
			if (items[i].getTitle().equalsIgnoreCase(title)) {
				items[i].markReturned();
				find = true;
			}
		}
		if (!find) {
			System.out.println("I'm sorry, I couldn't find " + title + " in the library.");
		}
	}
	
	public static void main(String[] args) {
		
		MediaItem itemInfo = new MediaItem();
		
		Scanner input = new Scanner(System.in);					
		Library track = new Library();
		
		String title;
		String format;
		String name;
		String date;
		int userInput;
		
		do {
			userInput = displayMenu();
				
			switch (userInput) {
			case 1:
				System.out.print("What is the title? ");
				title = input.nextLine();
	
				System.out.print("What is the format? ");
				format = input.nextLine();
				
				track.addNewItem(title, format);
				break;
	
			case 2:
				System.out.print("Which item (enter the title)? ");
				title = input.nextLine();
				
				System.out.print("Who are you loaning it to? ");
				name = input.nextLine();
				
				System.out.print("When did you loan it to them? ");
				date = input.nextLine();
				
				track.markItemOnLoan(title, name, date);
				break;
			
			case 3:
				for (int i = 0; i < track.listAllItems().length; i++) {
					System.out.println(track.listAllItems()[i]);
				}
				break;
				
			case 4:
				System.out.print("Which item (enter the title)? ");
				title = input.nextLine();
				track.markItemReturned(title);
				break;
				
			case 5:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			}
		} while(userInput != 5);							
	}
}
