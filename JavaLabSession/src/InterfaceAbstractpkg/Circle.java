package InterfaceAbstractpkg;

public class Circle implements Area {

   private double radius;
   
   public Circle(double radius) {	 
      this.radius=radius;
   }
	   
   public double compute() {
     return  PI *radius*radius;
	   
}
    public void print() {
		 
    	System.out.println("Area of Circle: " + compute());

    }
}
