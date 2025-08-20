package pkgExceptionHandling;

public class Test {
	
   public void m1(String  msg)throws NullPointerException
   {
	   
	   if(msg==null) {
		   System.out.print("the message string was NULL");
	       throw new NullPointerException();
	   }
	   
	   
   }
   
   public static void main(String[] ah[]) {

	   Test obj = new Test();
	      
	    try {
	    	obj.m1(null);
	    }
	    catch(NullPointerException npe) {
	    	System.out.print(npe);
	    }
	    finally {
	    	System.out.print("this has to be printed");
	    }
	    
   }
}
