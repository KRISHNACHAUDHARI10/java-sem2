package BankingSytsem;


//Savings Account Class
class SavingsAccount implements Account {
 private String accountNumber;
 private double balance;
 private double interestRate;

 public SavingsAccount(String accountNumber, double balance, double interestRate) {
     this.accountNumber = accountNumber;
     this.balance = balance;
     this.interestRate = interestRate;
 }

 @Override
 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited " + amount + " into Savings Account: " + accountNumber);
 }

 @Override
 public void withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         System.out.println("Withdrew " + amount + " from Savings Account: " + accountNumber);
     } else {
         System.out.println("Insufficient balance in Savings Account: " + accountNumber);
     }
 }

 @Override
 public void calculateInterest() {
     double interest = balance * (interestRate / 100);
     balance += interest;
     System.out.println("Interest added to Savings Account: " + accountNumber + " | Interest: " + interest);
 }

 @Override
 public void viewBalance() {
     System.out.println("Savings Account: " + accountNumber + " | Balance: " + balance);
 }
}

