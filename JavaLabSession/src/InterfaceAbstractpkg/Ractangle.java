package InterfaceAbstractpkg;

public class Ractangle implements Area{
   
   private  double length;
   private double height;
	
	
   
public  Ractangle(double length,double height) {
		 this.length =length;
		 this.height=height;
}


public double compute() {
	  return length * height;
}
public void print() {
	System.out.print("Area of Ractangle "+compute());
	}
}
