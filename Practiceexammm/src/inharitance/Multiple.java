package inharitance;

class Train{
	 String enginee;
	 
public void worke () {
	   System.out.println(enginee);
  }
}
class Vandebharat extends Train{

	public void  neww(String enginee) {
		   System.out.println("hy i am new my enginee is" +enginee);
	  }
	
}

class Chennaiexpress extends Train{

	public void  genral(String enginee) {
		   System.out.println("hy i am new my  genral is" +enginee);
	  }
	
}

public class Multiple {
  public static void main(String[] args) {
       //vandebharat
	  Vandebharat vande = new  Vandebharat();
	  vande.neww("Pluto");
	  
     }
}
