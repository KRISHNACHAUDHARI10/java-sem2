package Sports;
import java.util.ArrayList;
import java.util.Scanner;

public class Sportsgame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // i am taking  Input for Football participation
        System.out.print("Enter number of students in Football: ");
        int footballCount = sc.nextInt();
        sc.nextLine(); // consume newline

        ArrayList<String> footballList = new ArrayList<>();
        System.out.println("Enter the names of players participating in Football:");
        for (int i = 0; i < footballCount; i++) {
            String name = sc.nextLine();
            footballList.add(name);
        }

        //i am taking Input for Cricket participation
        System.out.print("Enter number of students in Cricket: ");
        int cricketCount = sc.nextInt();
        sc.nextLine(); // i am definding newline

        ArrayList<String> cricketList = new ArrayList<>();
        System.out.println("Enter the names of players participating in Cricket:");
        for (int i = 0; i < cricketCount; i++) {
            String name = sc.nextLine();
            cricketList.add(name);
        }

        // Find common participants between Football and Cricket
        ArrayList<String> sportsCoreTeam = new ArrayList<>();
        for (String name : footballList) {
            if (cricketList.contains(name)) {
                // Add only if the name is not already added to avoid duplicates
                if (!sportsCoreTeam.contains(name)) {
                    sportsCoreTeam.add(name);
                }
            }
        }

        // Display the SportsCoreTeam list
        System.out.println("\nSports Core Team (players who participated in both Football and Cricket):");
        if (sportsCoreTeam.isEmpty()) {
            System.out.println("No common participants found.");
        } else {
            for (String name : sportsCoreTeam) {
                System.out.println(name);
            }
        }
        
        sc.close();
    }
}
