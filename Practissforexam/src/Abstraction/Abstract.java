package Abstraction;
//
//abstract class Car{
//	String name;
//	int price;
//	
//	
//	abstract void  drive();
//	void color() {
//		System.out.print("black color");
//	}
//	
//	
//}
//
//
//
//class Mahendra extends Car{
//	    void  drive() {
//		   System.out.println("i am not driving");
//	    }
//}
//
//public class Abstract {
//  public static void main(String[] args) {
//	  Mahendra obj = new Mahendra();
//	    obj.drive();
//	    obj.color();
//  }
//}
//




//
//
//abstract class Car {
//    // Data Abstraction: Essential Attributes
//    protected String brand;
//    protected String model;
//    protected int year;
//    protected String engineType;
//    protected double fuelLevel;
//    protected double speed;
//    protected boolean isEngineOn;
//
//    // Constructor
//    public Car(String brand, String model, int year, String engineType) {
//        this.brand = brand;
//        this.model = model;
//        this.year = year;
//        this.engineType = engineType;
//        this.fuelLevel = 100; // Full tank
//        this.speed = 0;
//        this.isEngineOn = false;
//    }
//
//    // Procedural Abstraction: Essential Methods
//    public abstract void startEngine();
//    public abstract void stopEngine();
//    public abstract void accelerate();
//    public abstract void brake();
//    public abstract void refuel(double amount);
//    public abstract void getStatus();
//}
//
