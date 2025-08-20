package BankingSytsem;


	

//Current Account Class
class CurrentAccount implements Account {
 private String accountNumber;
 private double balance;
 private double overdraftLimit;

 public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
     this.accountNumber = accountNumber;
     this.balance = balance;
     this.overdraftLimit = overdraftLimit;
 }

 public CurrentAccount(String accountNumber2, int balance2, int overdraftLimit2) {
	// TODO Auto-generated constructor stub
}

@Override
 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited " + amount + " into Current Account: " + accountNumber);
 }

 @Override
 public void withdraw(double amount) {
     if (balance + overdraftLimit >= amount) {
         balance -= amount;
         System.out.println("Withdrew " + amount + " from Current Account: " + accountNumber);
     } else {
         System.out.println("Overdraft limit exceeded in Current Account: " + accountNumber);
     }
 }

 @Override
 public void calculateInterest() {
     System.out.println("Current Accounts do not accrue interest.");
 }

 @Override
 public void viewBalance() {
     System.out.println("Current Account: " + accountNumber + " | Balance: " + balance);
 }
}