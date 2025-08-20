package Animals;

//Subclass of Mammal
class Dog extends Mammal {
 double tailLength;
 boolean isTrained;

 // Constructor
 public Dog(int age, String gender, double weight, int litterSize, int gestationPeriod, double tailLength, boolean isTrained) {
     super(age, gender, weight, litterSize, gestationPeriod);  // Calling Mammal constructor
     this.tailLength = tailLength;
     this.isTrained = isTrained;
 }

 // Method for training the dog
 public void getTrained() {
     if (!isTrained) {
         System.out.println("Training the dog...");
         isTrained = true;
     } else {
         System.out.println("The dog is already trained.");
     }
 }

 // Overriding details method
 @Override
 public void details() {
     super.details();
     System.out.println("Dog Details - Tail Length: " + tailLength + " cm, Trained: " + (isTrained ? "Yes" : "No"));
    }
 
 //override dog class
 public void sound() {
	 System.out.println("Dog is burk");
 }
 
}
