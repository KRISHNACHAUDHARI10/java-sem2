package BankingSytsem;

import java.util.*;

//Account Interface
interface Account {
 void deposit(double amount);
 void withdraw(double amount);
 void calculateInterest();
 void viewBalance();
}