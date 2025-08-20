package inheritance;

class Laptop{
	  String name="rama"	;
	  void a() {
		  System.out.println("this is parent class"+name);  
	  }
}
class Lenovo extends Laptop{
   String name="shyama";
       void b(){
	     
    	   System.out.println("this is sub class"+name); 
    	   System.out.println(super.name); 

   }
}


public class Super {
  public static void main(String[] args) {
	   Lenovo obj1= new Lenovo();
	   
	   obj1.b();
  }
}
