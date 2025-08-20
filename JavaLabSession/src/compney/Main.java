package compney;

public class Main {
  public static void main(String[] args) {
	  EngineeringDepartment   enobj = new EngineeringDepartment ();
	  enobj.enroll();
	  enobj.terminate();
	  enobj.calculatepay();
	  
     System.out.println("");
     System.out.println(" ");

      ProductionDepartment   probj = new ProductionDepartment ();
	  probj.enroll();
	  probj.terminate();
	  probj.calculatepay();
	  
  
   }

}
