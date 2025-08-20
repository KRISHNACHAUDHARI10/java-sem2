interface Car{
	public void start();
}

class Eleectronic implements Car{
 
	
	public void start(){
	  System.out.println("this car is running");

	}
	
}


public class InterfaceDemo {

	public static void main(String[] args) {
	
	   Car obj = new  Eleectronic();
	   obj.start();
     

	}

}
