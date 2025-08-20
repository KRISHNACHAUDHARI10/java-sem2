package Inharitace;

public class Multiple {
  public static void main(String[] args) {
    Dog obj = new Dog();
    obj.legs= 5;
     System.out.print(obj.legs);
  }
}

class Animals{
	String color;
	
	void eat() {
		 System.out.println("eats");
	}
	
	void  breathe() {
		System.out.print("breathes");
	}
}
class Mamel extends Animals{
	    int legs;

}
class Dog extends  Mamel{
     	String 	bred;
}
