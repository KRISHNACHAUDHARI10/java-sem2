package Arraylist;
import java.util.ArrayList;
class arraylist{
	 public static void main(String[] args) {
    
		 ArrayList<Integer>  list = new ArrayList<>();
		 list.add(50);
		 list.add(60);
		 list.add(70)
		 list.add(80);
		 
	
         list.remove(0);
       
         
         list.set(1,600);
         System.out.print(list);   
	    list.clear();
	    System.out.print(list);
	 }
}
