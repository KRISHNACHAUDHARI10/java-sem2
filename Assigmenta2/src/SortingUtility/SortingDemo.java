package SortingUtility;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class SortingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking input for an array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        Integer[]  arr= new Integer[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        SortArray sortArray = new SortArray(arr);
        System.out.println("\nSorting Array:");
        sortArray.ascendingSort();
        sortArray.descendingSort();
        
        
        // Taking input for a string
        System.out.print("\nEnter a string: ");
        scanner.nextLine();  // Consume the newline
        String str = scanner.nextLine();

        
        SortString sortString = new SortString(str);
        System.out.println("\nSorting String:");
        sortString.ascendingSort();
        sortString.descendingSort();

        scanner.close();
    }
}