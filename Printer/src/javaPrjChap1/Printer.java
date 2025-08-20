import java.util.Scanner;

public class Printer {
    String model;
    String location;
    String choice;
    
    // Default constructor
    public Printer() {
        this.model = "Default Model";
        this.location = "Unknown";
    }
    
    // Parameterized constructor
    public Printer(String model, String location) {
        this.model = model;
        this.location = location;
    }
    
    public void print() {
        System.out.println("I will print all the pages in black and white");
    }
    
    public void print(boolean flag) {
        if (flag) {
            System.out.println("I will print all the pages in colours!!");
        } else {
            print();
        }
    }
    
    public void printChoice() {
        System.out.println("Hello user! Enter Yes/yes if you want a colour print. Else enter No/no");
        Scanner sc = new Scanner(System.in);
        choice = sc.next();
        
        if (choice.equalsIgnoreCase("Yes")) {
            // Call print() for colour copies
            print(true);
        } else if (choice.equalsIgnoreCase("No")) {
            // Call print for black and white
            print();
        } else {
            System.out.println("You have entered some incorrect input choice.");
        }
        sc.close();
    }
    
    public void displayDetails() {
        System.out.println("Printer Model: " + model);
        System.out.println("Printer Location: " + location);
    }
    
public static void main(String[] args) {
        Printer myPrinter = new Printer("HP LaserJet", "Office");
        myPrinter.displayDetails();
        myPrinter.printChoice();
    }
}