package Animals;

//Subclass of Animal
class Mammal extends Animal {
 int litterSize;
 int gestationPeriod;

 // Constructor
 public Mammal(int age, String gender, double weight, int litterSize, int gestationPeriod) {
     super(age, gender, weight);  // Calling parent constructor
     this.litterSize = litterSize;
     this.gestationPeriod = gestationPeriod;
 }

 // Overriding details method
 @Override
	 public void details() {
	     super.details();
	     System.out.println("Mammal Details - Litter Size: " + litterSize + ", Gestation Period: " + gestationPeriod + " days");
	 }
}
