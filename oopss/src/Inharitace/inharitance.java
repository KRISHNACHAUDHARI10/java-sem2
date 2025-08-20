package Inharitace;

public class inharitance {
     public static void main(String[] args) {
    	 
    	   Fish  obj = new Fish();
    	   obj.eat();
    	   
     }
}
//base class
class  Animal  {
    String  color;
     void eat() {
    	  System.out.println("eats");
     }
     void  breathe() {
    	 System.out.println("breathes");
     }
}

//derive class 
class  Fish extends Animal{
	int  fins;
	 void  swim() {
		 System.out.print("swims in water");
	 }
	}
