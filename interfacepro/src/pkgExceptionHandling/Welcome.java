package pkgExceptionHandling;

import java.util.Scanner;

public class Welcome{
	
	public void  greetings(String usmsg)  {
		
		if(usmsg  == null) {
		   
			System.out.println("thisi is null pointer exception");
			throw new NullPointerException();
	
		
		}
		else {
			System.out.println("helll my user"+ usmsg);
		}
	
	}
	
	
	public static void main(String[] args) {
		
		Welcome obj = new 	Welcome();
		Scanner sc= new Scanner(System.in);
	
		 String usmsg= sc.next();

	
		try {
			obj.greetings(usmsg);
		}
		catch (NullPointerException e) {
			System.out.print(e);
		}
		
	
	
	
	}
	
}