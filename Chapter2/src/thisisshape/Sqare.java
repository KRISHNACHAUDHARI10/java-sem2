package thisisshape;
import figursss.Figure;


public class Sqare extends Figure  implements Shape {
        
    public void drawshape() {	
    	System.out.println("Drawing shape from sqare class");
    
    }
    
    // overirdemethod
    
    
public  void  printshape() {
  	  System.out.println("this is method default from shape");
    
}
    
    
    //abstract method from figur anthore package
    public   void area(int areaa) {
    	 	System.out.println("area of sqare is " + areaa);
    
    }
     
    public  void volume(int  volumee) {
		System.out.println("my volume is " + volumee);
	
    }
	
	
 public   void size(String sizee) {
      
		System.out.println("the size of sqare is  " + sizee);
    }
	
	
    
    
    
    
    
    
    
	
	
}
