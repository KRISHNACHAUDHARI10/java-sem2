package SortingUtility;

import java.util.Arrays;
import java.util.Collections;
class SortString {
	private String str;
                                       
    public SortString(String str) {

    	this.str = str;
    
    }

 public void ascendingSort() {
 
	    char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println("Ascending Order" + new String(chars));
 
 
}
	
public void descendingSort() {
   Character[] chars = new   Character[str.length()];
   for(int i=0;i<str.length();i++) {
	   chars[i] = str.charAt(i);
	   
   }
   Arrays.sort(chars,Collections.reverseOrder());
   StringBuilder strbuild = new  StringBuilder();
   for(char c:chars) {
	  strbuild.append(c);
	 }
   
   System.out.print(strbuild);
  }
}