package Eccomarcewebsite;
class ShoppingCart {
    private static final int MAX_UNITS = 5;
    private String product;
    private int quantity;
    
    public ShoppingCart(String product, int quantity) throws MaximumProductsLimitExceededException {//it is my customize exception
        if (quantity > MAX_UNITS) {
            throw new MaximumProductsLimitExceededException("Cannot add more than " + MAX_UNITS + " units of " + product + " to the cart.");
        }
        this.product = product;//
        this.quantity = quantity;
        System.out.println(quantity + " units of " + product + " added to the cart.");
    }
}