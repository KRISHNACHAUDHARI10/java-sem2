package Acoountpkg;
import java.util.ArrayList;
import java.util.Scanner;

public class Attandnace{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read and validate the number of students 
        int countA = getIntInput(sc, "Enter number of students in Division A: ");
        ArrayList<String> divisionA = new ArrayList<>();
        System.out.println("Enter the names of students in Division A:");
        for (int i = 0; i < countA; i++) {
            String name = sc.nextLine();
            divisionA.add(name);
        }

        // Read and validate the number of students 
        int countB = getIntInput(sc, "Enter number of students in Division B: ");
        ArrayList<String> divisionB = new ArrayList<>();
        System.out.println("Enter the names of students in Division B:");
        for (int i = 0; i < countB; i++) {
            String name = sc.nextLine();
            divisionB.add(name);
        }

      
        ArrayList<String> consolidatedAttendance = new ArrayList<>(divisionA);
        for (String student : divisionB) {
            if (!consolidatedAttendance.contains(student)) {
                consolidatedAttendance.add(student);
            }
        }

       
        System.out.println("\nConsolidated Attendance List of FYMCA Students:");
        for (String student : consolidatedAttendance) {
            System.out.println(student);
        }
        sc.close();
    }

    // Utility method to get a validated integer input from the user
    private static int getIntInput(Scanner sc, String message) {
        int number = -1;
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            try {
                number = Integer.parseInt(input);
                break; // If parsing is successful, break out of the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return number;
    }
}
