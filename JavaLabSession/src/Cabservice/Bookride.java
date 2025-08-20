package Cabservice;

// Class to handle the booking of the ride
class Bookride {
   
	public int bookedSeats = 0;  // Number of seats already booked

    // Method to book seats
    
   public void bookSeat(int totalNoOfBooking) throws RideOverBooked {
        if (bookedSeats + totalNoOfBooking > 4) {
            // If total bookings exceed 4, throw RideOverBooked exception
            throw new RideOverBooked("Ride is overbooked! Only 4 seats available.");
        } else {
            bookedSeats += totalNoOfBooking;  // Update the booked seats
            System.out.println(totalNoOfBooking + " seat(s) successfully booked.");
        }
    } 
    
   
}
