package Cabservise;
import java.util.ArrayList;
import java.util.Scanner;

public class TechnologyCount {
    public static void main(String[] args) {
        // ArrayList to store the technologies chosen by students.
        ArrayList<String> technologies = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Asking each student for their technology choice.
        System.out.println("Enter the technologies (Java, Python, MERN, etc.) chosen by 15 students:");
        for (int i = 0; i < 15; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            String technology = scanner.nextLine();
            // Adding the student's choice to the list.
            technologies.add(technology);
        }

        // Initializing counters for each technology.
        int javaCount = 0, pythonCount = 0, mernCount = 0;

        // Counting how many times each technology was chosen.
        for (String tech : technologies) {
            switch (tech.toLowerCase()) { // To make it case-insensitive
                case "java":
                    javaCount++;
                    break;
                case "python":
                    pythonCount++;
                    break;
                case "mern":
                    mernCount++;
                    break;
                // Just in case there's an unrecognized technology.
                default:
                    System.out.println("Unrecognized technology: " + tech);
                    break;
            }
        }

        // Displaying the count of each technology.
        System.out.println("\nTechnology Count:");
        System.out.println("Java: " + javaCount);
        System.out.println("Python: " + pythonCount);
        System.out.println("MERN: " + mernCount);

        // Closing the scanner to avoid memory leaks.
        scanner.close();
    }
}
