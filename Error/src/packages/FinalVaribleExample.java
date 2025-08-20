package packages;


import java.util.Scanner;

/**
 * This class is used to understand the use of final keyword with instance and local variables.
 * We use the example of a ticket booking window.
 */


public class FinalVaribleExample {

	 
    public final int TOTAL_TICKETS; //we can skip initializing final variable here.
	//or we can use the following syntax which initializes the final variable at the time of declaration
	// public final int totalTickets=200;
	public int tktsAvailable=0;
	
	
	/**
	 * The class constructor is used to initialise the final instance variable, TOTAL_TICKETS
	 * @param totTkc
	 */
	public FinalVaribleExample(int totTkc)
{
		//initialising a final variable.
		this.TOTAL_TICKETS = totTkc;

}
	/**
	 * This method takes the day of the week from the user and sets the no of available tickets for sale on 
	 * that day. 
	 * Monday,Tuesday,Wednesday,Thursday - 150
	 * Friday - ALL TICKETS
	 * Saturday, Sunday - 175
 */
public void setAvailableTkts(String wkDy)
	{
		//Depending on the day of the week, we set the available tickets count. For this we are
		//using switch case implementation of case list and arrow case as per JDK21 version
		switch(wkDy) {
			case "Mon","Tue","Wed","Thur"->
			{
					tktsAvailable = 150;
			}
			case "Fri"->
			{
				tktsAvailable = 200;
			}
			case "Sat","Sun"->
			{
				tktsAvailable = 175;
			}
			default->
				tktsAvailable = 0;	
		}
	}
	public boolean bookTickets(final int noOfTkts)
	     
	  {
	     final double TKTPRC =150.50;
	
		//assign some ticket price to the local variable. 
		double tktAmount=0.0;
		//check if the noOfTkts are less than the total tickets. proceed with the booking then. else return false
		if(noOfTkts < tktsAvailable) {
			tktAmount = TKTPRC*noOfTkts;
			System.out.println("Please pay: "+tktAmount+" at the ticket counter.");
			//updating available tickets count.
			tktsAvailable = tktsAvailable - noOfTkts;
		}
		else
			return false;
			return true;
		}
		public static void main(String arg[]) {
			FinalVaribleExample fnVrObj = new FinalVaribleExample(120); 
			fnVrObj.setAvailableTkts("Mon");
			System.out.println("Available tickets are:"+ fnVrObj.tktsAvailable);
			if(fnVrObj.bookTickets(100))
				System.out.println("Tickets are booked!! Please pay the amount");
			else
				System.out.println("Tickets could not be booked. Better luck next time");
			
			System.out.println("Available tickets are:"+ fnVrObj.tktsAvailable);
			
			if(fnVrObj.bookTickets(70))
				System.out.println("Tickets are booked!! Please pay the amount");
			else
				System.out.println("Tickets could not be booked. Better luck next time");
			}

	}



