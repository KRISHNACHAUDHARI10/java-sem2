package Cabservice;

public class Ridebooking {
      
	
private int totalbooked=1;
	    
public void Bookriede(int totalNoOfBooking)throws RideoverBooked {
 		 if(totalNoOfBooking >4) {
		throw new RideoverBooked("ride is overloded you can not book ride full sorry");
	}
 else {
	 System.out.print("your ride booked sucssfully" +totalNoOfBooking);
 }

}
	
	
}
