package inheritance;



public class Methodoverloding {
	
   public sictat int sum(int a,int b) {
	   return a+b;
   }
   
   public static int sum(int a,int b,int c) {
	   return a+b+c;
	   
   }
   public static String sum(String x,String y) {
	   
	   return x+y;
	   
   }
   public static void main(String[] args) {
	   
	   System.out.println(sum(7,8)); 
	   System.out.println(sum(7,8,9));
	   System.out.println(sum("krishna","akash"));
	   
   }
   
}
