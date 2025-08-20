package MultipleInterface;

 interface A{
	  public void show();

 }
 interface B{
	public void show();
	
}
class C implements A,B{ 
	 public void show() {
		 System.out.print("this is runing");
	 }
}



public class multiple {
  public static void main(String[] args) {
	  C obj = new C();
	  obj.show();
  }
}
