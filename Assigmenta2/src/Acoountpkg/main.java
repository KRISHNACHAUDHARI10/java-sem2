package Acoountpkg;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
 public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
      ArrayList<Account> accounts = new ArrayList<>();
      for(int i=0; i<10; i++) {
         System.out.println("type account holder name " +( i+1));
         
        System.out.print("type your account no");
        int   acc_no = sc.nextInt();
       
        System.out.println("type your accounnt_type");
        String acc_type = sc.next();
        
        System.out.println("type your name");
        String name= sc.next();
        
        System.out.println("type your balance");
        double balance = sc.nextDouble();
         
        Account account = new Account(acc_no,acc_type,name,balance);
        accounts.add(account);
        
        
      } 
 
   

      for (Account account :accounts) {
   	     if(account.hasBalanceGreaterThan10K()) { 
   	    	 System.out.print(account.getName());
   	     }
      }
 
 }
}
