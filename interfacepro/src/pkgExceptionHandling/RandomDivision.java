package pkgExceptionHandling;

import java.util.Random;
public class RandomDivision {

	public int randomDiv() {
	
	   Random rndNum = new Random();
	   int num1 = rndNum.nextInt(1);
	   int num2 = rndNum.nextInt(2);
	   int result= 0;
	 
	   try 
	   {
		   System.out.println("Num is :" + num1);
		   System.out.println("Num is :" + num2);
		   result= num1/num2;
	   
	   }
	   catch (ArithmeticException ae) {
		   System.out.println("Exeption" + ae);
		   
	   }
	   return result;
	  	}
   
public static void main(String[] args) {
	  
	   RandomDivision randsobj= new  RandomDivision();
	   int res =   randsobj.randomDiv();
	   System.out.println("Result of diving two random number is "+ res) ;
   
   
     }


   
}
