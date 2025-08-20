public class Accountes {
   
	int acc_no;
   String acc_type;
   String name;
   double balance;
      
   
   public Accountes(int acc_no,String acc_type,String name,double balance) {
	   this.acc_no = acc_no;
	   this.acc_type=acc_type;
	   this.name = name;
	   this.balance =balance;

}
   
   public String getName() {
	   return  name;
   }
   
   
   public double getbalance() {
	   return balance;
   }
   
   
 

}
