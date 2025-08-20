package SortingUtility;
import java.util.Arrays;
import java.util.Collections;

//Implementation for sorting an array of integers
class SortArray {
    private Integer[] arr;

public SortArray(Integer[] arr) {
         this.arr = arr;
}
    
 public void ascendingSort() {
    
    	Arrays.sort(arr);
        System.out.println("Ascending Order: " + Arrays.toString(arr));
   }
public void descendingSort() {
    	Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Descending Order: " + Arrays.toString(arr));    
    }
}