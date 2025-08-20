package BankingSytsem;
import java.util.*;

//Bank Class
class Bank {
 private List<Account> accounts;

 public Bank() {
     this.accounts = new ArrayList<>();
 }

 public void addAccount(Account account) {
     accounts.add(account);
     System.out.println("Account added successfully.");
 }

 public void showAllAccounts() {
     for (Account account : accounts) {
         account.viewBalance();
     }
 }
}