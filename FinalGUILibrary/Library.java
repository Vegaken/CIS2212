 //Kenji Hirai
//December 13, 2019
//CIS2212_A.Final Project - A Personal Lending Library

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Library {

	
	public Library() {
		
	}
	
	ArrayList <MediaItem> listOfMediaItems = new ArrayList <>();
	
	
	public void addNewItem(String title, String format) {
		MediaItem itemobj = new MediaItem(title, format);
		listOfMediaItems.add(itemobj);
	}
	
	public void markItemOnLoan(MediaItem mediaItem, String name, String date) {
		mediaItem.markOnLoan(name, date);
	}
	
	public void markItemReturned(MediaItem mediaItem) {
		mediaItem.markReturned();
	}
	
	public void delete(MediaItem mediaItem) {
		listOfMediaItems.remove(mediaItem);
	}
	
	public void save() {
        try {
        	File file = new File("library.txt");
        	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        	
        	for(MediaItem mediaItem: listOfMediaItems) {											
        		pw.println(mediaItem.toFileString());
        	}
        	pw.close();						
        } 
       
        catch (FileNotFoundException ex) {
        	LibraryGUI.displayError(ex, "File not found.");
        }
        catch (IOException ex)	{
			LibraryGUI.displayError(ex, "Error");
        }
	}
	
	public void open() {
		try {
			File file = new File("library.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));		
				
			String str;													
			
			while((str = br.readLine()) != null) {
				for(MediaItem mediaItem: listOfMediaItems) {											
	        		System.out.println(mediaItem.toFileString());
	        	}				
			}														
			br.close();				
		}
		catch (FileNotFoundException ex) {
				LibraryGUI.displayError(ex, "File not found.");
		}
		catch (IOException ex)	{
				LibraryGUI.displayError(ex, "Error");
		}
	}
}