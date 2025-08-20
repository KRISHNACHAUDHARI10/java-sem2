package Modifers;

public class CharcterUtility {
     void countVowels(String str) {
    	System.out.print("hello om");
     }
     
final void countOccurance(char ch,String str) {
  	    System.out.print('a');
     	System.out.println("vasudev");
     }
}
class  MyCharcterUtility  extends CharcterUtility {
	   
	public void countVowels(String str) {
		System.out.print("krishna"+ str); 
  
	
	}
	
public static void main(String[] args) {
	
   MyCharcterUtility obj = new MyCharcterUtility();
    obj.countVowels("raj");

  }
}
