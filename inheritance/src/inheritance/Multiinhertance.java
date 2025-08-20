package inheritance;

class A{
	void methoda() {
		System.out.println("method of A class");
	}
}
class B extends A{
	void methodb() {
		System.out.println("method of B class");
	}
	
}
class C extends B{ 
	void methodc() {
		System.out.println("method of C class");
	}
	
}

public class Multiinhertance {
   public static void main(String[] args) {
	   C objc = new C();
	   objc.methodc();
	   objc.methodb();
	   objc.methoda();
   }
}
