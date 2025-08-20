package Arrya;
import java.util.Arrays;
import java.util.Collections;


public class Arraysort implements Thearray{
      
private  Integer[] arr;
      
public Arraysort(Integer[] arr) {
      this.arr=arr;
}
      
    
public  void assendingArray() {
	
	Arrays.sort(arr);
	System.out.print(Arrays.toString(arr));
	  
 }
public void dessandingArray() {
	 
	     	Arrays.sort(arr,Collections.reverseOrder());
			System.out.print(Arrays.toString(arr));
	  
 
    }


}
