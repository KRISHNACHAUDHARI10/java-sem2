package Cabservise;

import java.util.ArrayList;
import java.util.Scanner;

public class HistoricalCharacterBadge {
    public static void main(String[] args) {
        // Create an ArrayList to store the chosen historical characters
        ArrayList<String> chosenCharacters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Assume we have 5 volunteers (you can change this number as needed)
        System.out.println("Enter the names of 5 historical characters (each volunteer will pick one):");
        
        for (int i = 0; i < 5; i++) {
            String character;
            
            // Loop until the volunteer picks a unique character
            while (true) {
                System.out.print("Volunteer " + (i + 1) + ", enter a historical character: ");
                character = scanner.nextLine();

                // Check if the character is already chosen
                if (chosenCharacters.contains(character)) {
                    System.out.println("This character is already taken. Please choose a different one.");
                } else {
                    // If the character is not taken, add it to the list
                    chosenCharacters.add(character);
                    break; // Exit the loop for this volunteer
                }
            }
        }

        // Display all the chosen characters
        System.out.println("\nFinal list of chosen historical characters:");
        for (String character : chosenCharacters) {
            System.out.println(character);
        }

        // Close the scanner
        scanner.close();
    }
}

