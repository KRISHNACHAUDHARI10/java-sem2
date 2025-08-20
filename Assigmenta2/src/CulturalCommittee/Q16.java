package CulturalCommittee;
import java.util.ArrayList;
import java.util.Scanner;

public  class Q16{
   
	public static void main(String[] args) {
	   ArrayList<String> volunter  =  new ArrayList();
	   Scanner sc= new Scanner(System.in);
		
		while(volunter.size()< 15) {
		System.out.println("type your name");
		String name = sc.nextLine();
		
		 volunter.add(name);
		 
		 if(volunter.size() == 15) {
			 System.out.print("volunter are full we  dont' more then  15 volunter"); 
		 }
   }
		 sc.close();
   }
	
}	