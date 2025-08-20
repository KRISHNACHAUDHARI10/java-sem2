package Cabservice;

public class Main {

	
	
	
	public static void main(String[] args) {
        Bookride ride = new Bookride();  // Create an object of BookARide

        try {
            ride.bookSeat(4);  // Book 3 seats
            ride.bookSeat(9);  // Try to book 2 more seats (this should throw an exception)
        } catch (RideOverBooked e) {
            // Handle the RideOverBooked exception
            System.out.println(e.getMessage());
        }
    }
	
	
}
