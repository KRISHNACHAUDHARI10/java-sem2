package CollectionFremwork;

interface  Home{

	
	void  objeact();


}


class Student implements Home{
	 
	
	public void objeact(){
		   System.out.println("this is objeact from home");

	  }



}

public class Book {
    public static void main(String[] args) {
    	Student obj = new Student();
    	
    	obj.objeact();
    }
	
	
}
