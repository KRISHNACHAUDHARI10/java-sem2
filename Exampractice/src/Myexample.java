interface A{
	
	int age=44;
    
	void good();
	
	default void run() {//by default public and abstract 
    	    System.out.println("this is methid");
     }
    static void fly() {//this is static metod 
    	  System.out.println("this is flying");
    }
}


class B implements A{
	   
	public void good(){
		System.out.println("i am using good ");
	
	
	}
	
	

  }





public class Myexample {
    public static void main(String[] args) {
    	
    	A  obj = new  B();
    	 obj.run();  
        obj.good();
        System.out.println(A.age);
       
    	
    }
}
