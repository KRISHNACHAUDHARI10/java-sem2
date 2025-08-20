package Cabservice;


	// Custom exception class
	class RideOverBooked extends Exception {
	    // Constructor to pass the message when the exception is thrown
	    public RideOverBooked(String message) {
	        super(message);
	 
	    }
}