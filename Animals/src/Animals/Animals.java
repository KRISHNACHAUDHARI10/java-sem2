package Animals;

//Parent class
class Animal {
 int age;
 String gender;
 double weight;

 // Constructor
 public Animal(int age, String gender, double weight) {
     this.age = age;
     this.gender = gender;
     this.weight = weight;
 }

 // Method for eating
 public void eat() {
     System.out.println("Animal is eating...");
 }

 // Method for sleeping
 public void sleep() {
     System.out.println("Animal is sleeping...");
 }
 
 //methiod sound
 public void sound() {
	System.out.println("");
 }

 // Method to display details
   public void details() {
     System.out.println("Animal Details - Age: " + age + ", Gender: " + gender + ", Weight: " + weight + " kg");
   }
}
