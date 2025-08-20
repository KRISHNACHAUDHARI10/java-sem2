package overloding;

class Bank{
	public void Charge(){
		System.out.println("Bank charges  is  6%");
	}
}


class Pnb extends Bank{
	 //@override
	 public void Charge(){
	    System.out.println("Rate of  charges is 7%");
	 }
}

class Baroda extends Bank{
	public void Charge(){
		 System.out.print("Bgenrally baroda bank charge is 8%");
	}
}



public class Methodoverriding {
 
 public static void main(String[] args) {
	 Bank obj =new Bank();
	 Pnb obj1 =new Pnb();
	 Baroda obj2 = new Baroda();
	 obj.Charge();
	 obj1.Charge();
	 obj2.Charge();
	   
    }
     	
 	
}
