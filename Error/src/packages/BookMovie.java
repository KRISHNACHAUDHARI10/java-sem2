package packages;

public class BookMovie {
    // Instance variables
    int availableTkt;
    int totalTickets = 0;

    // Constructor to initialize totalTickets
    public BookMovie(int tkc) {
        this.totalTickets = tkc;
    }

    // Method to set available tickets based on the day
    public void setDay(String weekDay) {
        switch (weekDay.toLowerCase()) { // Convert input to lowercase for case insensitivity
            case "mon", "tue", "thu", "fri" -> availableTkt = 120;
            case "sat" -> availableTkt = 100;
            case "sun" -> availableTkt = 50;
            default -> availableTkt = 50;
        }
    }

    // Method to calculate ticket price and check availability
    public boolean setPrice(int noOfTickets) {
        final double TKTPRC = 150.50;

        if (noOfTickets <= availableTkt) {
            double totalAmount = noOfTickets * TKTPRC;
            System.out.println("This is your payment amount: " + totalAmount);
            availableTkt -= noOfTickets; // Reduce available tickets after booking
            return true;
        } else {
            System.out.println("Tickets not available. Better luck next time.");
            return false;
        }
    }

    public static void main(String[] args) {
        BookMovie obj = new BookMovie(120);
        obj.setDay("mon");
        System.out.println("Tickets available: " + obj.availableTkt);

        if (obj.setPrice(100)) {       
            System.out.println("Booking successful!");
        } else {
            System.out.println("Booking failed.");
        }
    }
}
