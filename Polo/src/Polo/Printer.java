package Polo;

public class Printer {

	
	
	
	String brand;
   int price;
   int dipi;
   
  
Printer(String brand,int price,int dipi){
	   this.brand=brand;
	   this.price=price;
	   this.dipi=dipi;
	   
 }
public void Print(int page) {
     System.out.print("this is page"+ page);	
	}
public void Print(int page,String iscolor) {
	System.out.print("this is page"+iscolor );	
}

 void ineed( String brand,int price,int dipi) {
	  System.out.print("brand" + brand+"price"+price+"dipi"+dipi);
 	  }
}

