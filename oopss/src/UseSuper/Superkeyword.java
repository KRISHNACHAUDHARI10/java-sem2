package UseSuper;

public class Superkeyword {
  public static void main(String[] args) {
     Child obj = new Child();
     
  }

}

class Animal {
	  Animal(){
		   System.out.println("Animal construcotre called");
	  }
}

class Child extends Animal{
      	Child(){
      		 super();
			System.out.println("Chilld construcotre called");
			
		}
}