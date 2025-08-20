package Account;

class Account {
    // Declaring variables
    int acc_no;
    String acc_type;
    String name;
    double balance;

    // Constructor to initialize account details
    public Account(int acc_no, String acc_type, String name, double balance) {
        this.acc_no = acc_no;
        this.acc_type = acc_type;
        this.name = name;
        this.balance = balance;
    }

    // Method to get balance
    public double getBalance() {
        return this.balance;
    }

    // Method to get customer name
    public String getName() {
        return this.name;
    }
}