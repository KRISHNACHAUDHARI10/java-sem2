package Abstracion;


abstract class Plan {
	  abstract  void enginee();
	  void print() {
		  System.out.print("hello i am plkan");
	  }
 }
 
 
 
class Fy88 extends Plan {
	 void enginee() { 
		 System.out.println("this is roxv enginee");
	 }
}
public class Abb {
	
  public static void main(String[] args) {
	  Fy88 obj = new Fy88();
	  obj.enginee();
  }
}
