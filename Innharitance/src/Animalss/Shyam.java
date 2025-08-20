package Animalss;

class Vehical{
    int fual;
    String  name;
  
    
}
 class Bike extends Vehical{
	 
	 
	 public  void start(String drive) {
		 System.out.println("i am driving "+ drive);
	 }
 }


public class Shyam {
   public static void main(String[] args) {
	  
	   Bike obj = new Bike();
	   obj.start("this balero");
      
    }
}
