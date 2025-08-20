package BankingSytsem;


//Main Class
public class BankingSystemDemo {
        public static void main(String[] args) {
       Bank bank = new Bank();
     
       SavingsAccount savings = new SavingsAccount("S123", 5000, 5);
       CurrentAccount current = new CurrentAccount("C456", 2000, 1000);
     
       bank.addAccount(savings);
       bank.addAccount(current);
     
       savings.deposit(1000);
       savings.calculateInterest();
       savings.viewBalance();
     
       current.withdraw(2500);
       current.viewBalance();
     
       bank.showAllAccounts();
    }
}
