package Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Bank {
    
	public static void main(String[] args) {
        // Creating a list to store account objects
        List<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Loop to input data for 10 customers
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter details for account " + (i + 1) + ":");

            // Input details for each customer
            System.out.print("Account Number: ");
            int acc_no = scanner.nextInt();

            System.out.print("Account Type (e.g., Savings, Current): ");
            String acc_type = scanner.next();

            scanner.nextLine(); // To clear the buffer

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Account Balance: ");
            double balance = scanner.nextDouble();

            // Creating Account object and adding to the list
            Account account = new Account(acc_no, acc_type, name, balance);
            accounts.add(account);
        }

        // Printing names of customers with balance greater than 10,000
        System.out.println("\nCustomers with balance greater than 10,000:");
        for (Account account : accounts) {
            
        	if (account.getBalance() > 10000) {
                System.out.println(account.getName());
            }
            
        }

        scanner.close();
    }
}