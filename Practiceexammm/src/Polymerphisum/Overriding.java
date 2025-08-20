package Polymerphisum;

class Aprtment {
	public void rent(String name) {
		 System.out.print("this is aprtment"+name);
	}
}
class Room extends Aprtment {
	public void rent(String name) {
		System.out.print("this is room "+name);
	}
}

public class Overriding {
  public static void main(String[] args) {
	  Room obj = new Room();
	  obj.rent("krishna");
	  obj.rent("raju");
  } 
}
