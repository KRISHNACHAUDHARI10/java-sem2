package pkgExceptionHandling;

public class exception {

	
	public static void main(String[] args) {
		
		int a= 6;
		int b= 0;

		
		try {
			
		
			int c= a/b;
		     System.out.print(c);
		     
		}
		
		
		catch(Exception e) {
			
			System.out.print("sorry this is not possible");
			System.out.print(e);
			
		}
		
	
		
	}
	
}
 