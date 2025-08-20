package CollectionFremwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class 	ArrayListuse {  // Renamed class

    // Create an object of ArrayList using Generics
  List<Integer> myIntList = new ArrayList<>();
    
    
    public List<Integer> addElementToCollection() {
    	
        Scanner sc = new Scanner(System.in);
        System.out.println("Initial size of ArrayList: " + myIntList.size());
        System.out.println("Add Elements to the ArrayList:");

        try {
            
        	for (int i = 0; i < 5; i++) {
                System.out.println("Enter " + (i + 1) + " value:");
                Integer tempIntObj = sc.nextInt();
                myIntList.add(tempIntObj); // Add to collection
            }
            System.out.println("All Elements added Successfully.");
            System.out.println("Size of ArrayList after adding elements: " + myIntList.size());
        }
        
        catch (Exception e) {
        
        	System.out.println("Insertion into the collection was unsuccessful! Due to: " + e.getMessage());
     
        }
        
        finally {
            sc.close();  // Remove this if using System.in again
     
        }

        return myIntList;
        
    }
   public void printCollectionElement(List tempList) {
	    System.out.print("Element of the List are ");
	    tempList.forEach((n) ->System.out.print(n));
	   
  }
   
   public void printCollectionUsingIterator(List tempList) {
	   Iterator<Integer> itr =tempList.iterator();
	   while(itr.hasNext()) {
		   System.out.print("the nexxt element of the collection");
		   int x= (int)itr.next();
		   System.out.print(x);
	   }
   }
   
}