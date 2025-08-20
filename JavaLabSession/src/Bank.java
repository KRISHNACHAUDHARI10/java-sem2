import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class Bank {

	public static void main(String[] args) {
	    List<Accountes> accountes=  new  ArrayList<>();
	    Scanner sc= new Scanner(System.in);
	    
	    
	    for (int i =0; i<3; i++) {
	    	 System.out.println("Enter details for account " + (i + 1) + ":");
	    
	     
	    System.out.print(" accountes no: ");
	    int acc_no = sc.nextInt();
	    
	    System.out.print("Account type(Saving ,currnet)");
	    String acc_type = sc.next();
	    
	    
	    System.out.print("enter accountes names :- ");
	    String  name= sc.next();
	    
	    
	    System.out.print("enter accountes balanse :- ");
	    double balance= sc.nextDouble();

	    
	    
	    Accountes account = new Accountes(acc_no,acc_type, name,balance);
	     accountes.add(account);
	    }
	     
	     for(Accountes account:accountes) {
	    	 
	    	 if(account.getbalance() > 10000) {
	                System.out.println(account.getName());
	        
	    	 }
	     }
	     
	     
	    
	    
	    
	}
	
	
}
