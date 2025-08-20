package understandingencapstlation;

public class EmployeeDemo {
    public static void main(String[] args) {
        Manager mgr = new Manager("Alice", 101, 90000, "IT");
        Developer dev = new Developer("Bob", 102, 80000, "Java");
        Tester tester = new Tester("Charlie", 103, 70000, "Selenium");
        
        mgr.computeSalary();
        dev.computeSalary();
        tester.computeSalary();
        
        System.out.println("Manager Details:");
        mgr.details();
        
        System.out.println("\nDeveloper Details:");
        dev.details();
        
        System.out.println("\nTester Details:");
        tester.details();
    }
}