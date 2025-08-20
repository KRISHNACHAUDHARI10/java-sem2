package Animals;

//Main class
public class InheritanceDemo {

	public static void main(String[] args) {
     // Create an Animal object
     Animal animal = new Animal(5, "Male", 15.2);
     System.out.println("\n--- Animal Info ---");
     animal.details();
     animal.eat();
     animal.sleep();

     // Create a Mammal object
     Mammal mammal = new Mammal(3, "Female", 8.5, 4, 60);
     System.out.println("\n--- Mammal Info ---");
     mammal.details();

     // Create a Dog object
     Dog dog = new Dog(2, "Male", 10.0, 6, 65, 30.5, false);
     System.out.println("\n--- Dog Info ---");
     dog.details();
     dog.getTrained();  // Training the dog
     dog.getTrained();  // Checking training status
     
     
     Lion lion =new Lion(2,"Male",53.2,50,true);
     lion.details();


     System.out.println("\nProgram execution complete!");
   
    }

}

