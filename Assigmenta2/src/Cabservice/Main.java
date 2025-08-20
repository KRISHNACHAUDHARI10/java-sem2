package Cabservice;

public class Main {
   public static void main(String[] args) {
	   Ridebooking  riobj = new  Ridebooking();
	   try {
		   riobj.Bookriede(1);
		   riobj.Bookriede(5);
	   }catch(RideoverBooked e) {
		   System.out.print(e.getMessage());
	   }
   }
}
