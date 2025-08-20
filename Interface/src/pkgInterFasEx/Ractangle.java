package pkgInterFasEx;
import newabstract.Figure;


public class Ractangle extends Figure implements Shape{
	
   public Ractangle() {
	
	   System.out.println("creating rectangle class objeact");

   
}
   
   
   //ovberridding the draw shape
 public void drawshape(int no_of_side) {
	     System.out.println("This is draw shape implmemntaion from Rectangle class ."+"This shape has:"+no_of_side+"sides");
}
   
public void printShapeDetails() {
   System.out.println("this is message from Ractangle class");
}
   
   
   // this is abstract method area  form figure 
public  double ara() {
	 System.out.print("area of Ractangle is calculated here");
	 return 0.0; 
   
}
   
public  double volume() {
	
	   System.out.print("volume of Ractangle is calculated here ");
	   return 0.0;
}
   
   public void draw() {
	
	   System.out.println("Draw of a Ractangle ");
	    }
   
}
