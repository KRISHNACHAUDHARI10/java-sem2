package Prack;

abstract class Book{
     abstract public  void read();
     
public void print() {
    	System.out.println("this is abstraction");
     }
}

class Muck extends Book{
	   public void read() {
		  System.out.println("this clled abstraction");
	  }
}

public class Abb {
	
  public static void main(String[] args) {
	   
	  Muck  obj1=new Muck();
	     obj1.read();
	     
	     obj1.print();
  
  }
  
}
