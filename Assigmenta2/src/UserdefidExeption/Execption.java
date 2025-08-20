package UserdefidExeption;
import java.util.Scanner;
public class Execption {
   public static void main(String[] args) throws dailtlimits {
	   System.out.print("ples enter withdraw money");
	   Scanner sc = new Scanner(System.in);
	   int ammount = sc.nextInt();
	   
	   if(ammount>10000){
		   throw new dailtlimits("you are trying to withdraw more then moneuy");
		   
	    }
	   else {
		   System.out.print("you  wihdawn money sccuecfully  enjoy ");
	   }
   }
}
class dailtlimits extends Throwable{
	dailtlimits(String str){
		super(str);
	}
}

