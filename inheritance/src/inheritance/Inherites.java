package inheritance;

class Vehicle{
    
	String color;
    int milage;
    int price;
    
    void display() {
    
         	System.out.println(color);
    	    System.out.println(milage);
    	    System.out.println(price);
    
    	
    }
    
    
    
}
  

class Car extends Vehicle{
	
	void drive() {
		
		System.out.println("this is vehical");
	
	}
	
  }

public class Inherites {
 
	public static void main(String[] args) {
		
		Car obj1= new Car();
	    obj1.price=50000;
        obj1.price=2000;
	    obj1.color="blue";
	    obj1.milage=55;
	    obj1.display();
	 
    }
};
