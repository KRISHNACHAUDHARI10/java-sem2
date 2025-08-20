package Polymerphisum;

public class Methodoverridinig {
   public static void main(String[] args) { 
	   Dear  obj = new Dear();
	   obj.eat();
	   Animal anobj = new Animal();
	   anobj.eat();
   }
}
class Animal{
	 void eat() {
		 System.out.println("eats anything");
	 }
}
class  Dear extends Animal{
	  void eat() {
		  System.out.println("eats gras");
	  }
}