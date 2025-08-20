package Polo;


public class Overlloding {
	 String name;
	 int age; 
	  	
	   public static  String printname(String name) {
          return name;
	 }
       public static int  printage(int age) {
		   return age;
	 }
	 
public static void main(String[] args) {
	 
	 System.out.println(printname("krishna"));
	 System.out.println(printage(45));
                                             	 
    }
}
