package Polymerphisum;

class Student {
    String name;
    int age;
    String course;
 
    
    // Constructor 1: No-argument constructor
    Student() {
        this("Unknown", 0, "Not Assigned");  // Constructor 3 को call करता है
        System.out.println("Default constructor called");
        
    }

    // Constructor 2: Two-argument constructor
    Student(String name, int age) {
        this(name, age, "Computer Science");  // Constructor 3 को call करता है
        System.out.println("Two-argument constructor called");
    }

    // Constructor 3: Three-argument constructor
    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
        System.out.println("Three-argument constructor called");
    }

    // Method to display student info
    void display() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Course: " + course);
    }
}

public class Cunstructorchining {
    public static void main(String[] args) {
        // Object 1: using default constructor
        System.out.println("Creating student s1:");
        Student s1 = new Student();
        s1.display();

        System.out.println("\n------------------------\n");

        // Object 2: using two-argument constructor
        System.out.println("Creating student s2:");
        Student s2 = new Student("Amit", 21);
        s2.display();
    }
}
