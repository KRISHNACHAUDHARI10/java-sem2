package CollectionFremwork;


import java.util.Scanner;
public class TestDebugger {
 
   
 public int addition(int n1,int n2) {
      int sum=0;
	 sum= n1+n2;
	  return sum;
 }
 
   public static void main(String arg[]) {
      int x,y=0;
      int sum =0;
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the first number" );
      x= sc.nextInt();
      System.out.print("Enter tsecond number");
      y=sc.nextInt();
      TestDebugger objTsdb = new TestDebugger() ;
      sum =  objTsdb.addition(x,y);
      System.out.print("Result of addtion is "+ sum);
      
   }
}
