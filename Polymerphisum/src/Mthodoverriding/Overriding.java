package Mthodoverriding;

import java.util.Scanner;

public class CarData {
    // Private fields for encapsulation
    private String brand;
    private int speed;

    // Getter for brand
    public String getBrand() {
        return brand;
    }

    // Setter for brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter for speed
    public int getSpeed() {
        return speed;
    }

    // Setter for speed
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Main method to test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarData car = new CarData();

        // Taking input from user
        System.out.print("Enter Car Brand: ");
        String userBrand = scanner.nextLine();
        car.setBrand(userBrand);

        System.out.print("Enter Car Speed (km/h): ");
        int userSpeed = scanner.nextInt();
        car.setSpeed(userSpeed);

        // Displaying the values
        System.out.println("\n--- Car Details ---");
        System.out.println("Car Brand: " + car.getBrand());
        System.out.println("Car Speed: " + car.getSpeed() + " km/h");

        scanner.close();
    }
}
