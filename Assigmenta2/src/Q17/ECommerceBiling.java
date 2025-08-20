package Q17;
import java.util.Vector;

// MarathonRunner class to keep runner detail
class MarathonRunner {
    private String name;
    private int badgeNbr;
    private double startTime;
    private double endTime;

    // constructor
    public MarathonRunner(String name, int badgeNbr, double startTime, double endTime) {
        this.name = name;
        this.badgeNbr = badgeNbr;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // get name
    public String getName() {
        return name;
    }

    // get badge number
    public int getBadgeNbr() {
        return badgeNbr;
    }

    // get start time
    public double getStartTime() {
        return startTime;
    }

    // get end time
    public double getEndTime() {
        return endTime;
    }

    // to display details properly
    public String toString() {
        return "Name: " + name + ", Badge No: " + badgeNbr + ", Start Time: " + startTime + ", End Time: " + endTime;
    }
}

public class ECommerceBiling {
    public static void main(String[] args) {

        // creating vector to hold finishers
        Vector<MarathonRunner> finishers = new Vector<>();

        // adding some runners - we can asume same start time
        finishers.add(new MarathonRunner("Ravi", 1, 0, 135.2));
        finishers.add(new MarathonRunner("Sneha", 2, 0, 128.5));
        finishers.add(new MarathonRunner("Amit", 3, 0, 145.3));
        finishers.add(new MarathonRunner("Neha", 4, 0, 121.0));
        finishers.add(new MarathonRunner("Vikram", 5, 0, 139.9));

        // check if no finishers
        if (finishers.isEmpty()) {
            System.out.println("No data found. nobody finishd the race");
            return;
        }

        // assuming 1st one as both first and last
        MarathonRunner first = finishers.get(0);
        MarathonRunner last = finishers.get(0);

        // now loop to compare end time
        for (MarathonRunner r : finishers) {
            if (r.getEndTime() < first.getEndTime()) {
                first = r;
            }
            if (r.getEndTime() > last.getEndTime()) {
                last = r;
            }
        }

        // display result
        System.out.println("First Runner to finish the marathon:");
        System.out.println(first);

        System.out.println("\nLast Runner to finish the marathon:");
        System.out.println(last);
    }
}
