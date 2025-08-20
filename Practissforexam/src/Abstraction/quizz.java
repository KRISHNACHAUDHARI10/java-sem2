package Abstraction;
// Abstract class Pen
abstract class Pen {
    abstract void write();
    abstract void refill();	
}
// Concrete class Found that extends Pen
class Found extends Pen {
    @Override
 
 public void write() {
      
        System.out.println("Writing...");
        
    }

    @Override
    public void refill() {
     
    	System.out.println("Refilling the pen...");
    	
    }
}

// Main class to test the implementation
public class quizz {
    public static void main(String[] args) {
    	
        Found obj = new Found();
        
        
        obj.write();
        obj.refill();
    }
}
