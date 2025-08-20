package newabstract;

abstract class Abstr {
     abstract void run();
     
}

class Demo extends Abstr{
	public void run() {
		System.out.println("this is abstract method");
	}
}

public class Abstractes {
	public static void main(String[] args) {
	
		
		Demo obj =  new Demo();
		obj.run();
	
	}
}
