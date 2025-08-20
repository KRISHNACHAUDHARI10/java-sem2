package Prack;

import java.util.Scanner;  // Importing Scanner

public class Printer {
	String model;
    String location;
    String choice;

public void print() {
     
	System.out.println("I will print all the pages in black and white");
    
}

public void print(boolean flag) {
       
	System.out.println("I will print all the pages in colours!!");
    
}

public void printChoice() {
       
	System.out.println("Hello user! Enter Yes/yes if you want a colour print. Else enter No/no");

      Scanner sc = new Scanner(System.in); // Scanner instance
        choice = sc.next();

        if (choice.equalsIgnoreCase("Yes")) {
            // Call print() for color copies
            print(true);
        } else if (choice.equalsIgnoreCase("No")) {
            // Call print for black and white
            print();
            System.out.println("You have entered some incorrect input choice.");
        } else {
        	System.out.println("You have entered some incorrect input choice.");
        
        }

        sc.close(); // Closing scanner to prevent resource leaks
    }
 
} 
