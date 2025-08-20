package inharitance;
 class Car{
	int id=1;
	String name;
	
	void  driving() {
		System.out.print("this is driving");
	}
	
}
class Enoo extends Car{
	 public  void ful() {
		 System.out.println(id);
		 System.out.println("i am full");
    
    }
}

public class Single {
    
	
	public static void main(String[] args) {
      Enoo obj = new Enoo();
      obj.ful();
    }
}
