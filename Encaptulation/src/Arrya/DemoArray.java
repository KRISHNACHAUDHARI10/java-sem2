package Arrya;
import java.util.Scanner;
public class DemoArray {


public static  void main(String[] args) {
   
   Scanner sc= new Scanner(System.in);
   System.out.println("type  number what you want"); 
   int n =  sc.nextInt();
   Integer[] arr= new Integer[n];
   
   for(int i = 0;i<n;i++) {
	   arr[i] = sc.nextInt();
   }
   
   Arraysort obj= new Arraysort(arr);
   obj.assendingArray();
   obj.dessandingArray();
   
   
   }

}
