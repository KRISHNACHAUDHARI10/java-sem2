package Acoountpkg;

import java.util.ArrayList;
import java.util.Scanner;

	
class Account {
	    int acc_no;
	    String acc_type;
	    String name;
	    double balance;

	    // Constructor to initialize Account object
	    public Account(int acc_no, String acc_type, String name, double balance) {
	        this.acc_no = acc_no;
	        this.acc_type = acc_type;
	        this.name = name;
	        this.balance = balance;
	    }

	    // Method to check if balance is greater than 10,000
	    public boolean hasBalanceGreaterThan10K() {
	        
	    	return this.balance > 10000;
	        
	    }

	    // Getter for name
	    public String getName() {
	        return name;
	    }
	}


