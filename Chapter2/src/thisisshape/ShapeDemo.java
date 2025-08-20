
package thisisshape;

public class ShapeDemo { 
	
	public static void main(String args[]){
		
	//this is objeact for interface	
	Shape obj= new Sqare();
	obj.drawshape();
	obj.printshape();
	
	
	
	//this is objeact for subclass to inharit superclass
   Sqare objsq =  new Sqare();
   
	objsq.area(52);
	objsq.size("Larege");
	objsq.volume(50);
	
	
	
	
	} 
}
