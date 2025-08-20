package overloding;

public class Prack {
	
	//method overloding *//
	public static int Substraction(int number1 , int number2) {
		return number1+number2;
	}
	public static int Substraction(int number1 , int number2,int number3 ) {
		return number1+number2+number3;
	}
	public static String Substraction(String name,String addresh) {
		return name+addresh;
	}
	
  public static void main(String[] args) {
	  Prack obj1= new Prack();
	  System.out.println(Substraction(5,10));
	  System.out.println(Substraction(20,10,40));
	  System.out.println(Substraction("krishna","surat- Gujrat"));
  }
}
