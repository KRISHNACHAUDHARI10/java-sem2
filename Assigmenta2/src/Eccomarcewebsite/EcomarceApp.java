package Eccomarcewebsite;

public class EcomarceApp {
    public static void main(String[] args) {
        try {
            ShoppingCart cart1 = new ShoppingCart("Laptop", 3);
            ShoppingCart cart2 = new ShoppingCart("Smartphone", 6);
        } catch (MaximumProductsLimitExceededException e) {  // i am catching exception 
            System.out.println("Exception: " + e.getMessage());//i am catch exception 
        }
    }
}