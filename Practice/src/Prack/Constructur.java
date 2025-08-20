package Prack;

class Ram{
	int id;
	int age;
	Ram(int id,int age){
	this.id=id;
	this.age=age;
	}
	
	public void Print() {
		  System.out.print(id);
		  System.out.print(age);
	}
}



public class Constructur {
	
	  public static void main(String[] args) {
    	 Ram obj1 = new Ram(1,14);
    	 obj1.Print();
  }
}
