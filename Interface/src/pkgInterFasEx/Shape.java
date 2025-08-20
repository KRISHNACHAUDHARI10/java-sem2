package pkgInterFasEx;



public interface Shape {

	//abstract method
	public void drawshape(int no_of_side);
  
   //default method
   public default void printShapeDetailes() {
	 
	   System.out.println("this is from interface ");
	 }
   //static method
   public static void aboutShape() {
	   System.out.println("Shar interface ");
	   
   }

}




