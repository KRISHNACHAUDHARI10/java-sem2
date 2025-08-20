package Polo;

public class Methoddemo {
   private String brand;
   private String model;
   private int resolution; // DPI

 
 public Methoddemo(String brand, String model, int resolution) {
     this.brand = brand;
     this.model = model;
     this.resolution = resolution;
 }

 
 public void print(int pages) {
     System.out.println("Printing " + pages + " pages in Black & White.");
 }




 public void showDetails() {
	  System.out.println("Printer: " + brand + " " + model + " (" + resolution + " DPI)");
  }
 






 public static void main(String[] args) 
 {
     Methoddemo myPrinter = new Methoddemo("HP","LaserJet Pro",1200);
     myPrinter.showDetails();
     myPrinter.print(5);            
     }
 
}

