package Assigmentquestion;


public class EmployeeDemo {
    public static void main(String[] args) {
        // Creating objects of different classes
        Employee employee = new Employee("Krishna", 101, 5000);
        Manager manager = new Manager("Raj", 102, 000, "HR");
        Developer developer = new Developer("Om", 103, 75000, "Java");
        Tester tester = new Tester("Mohit", 104, 70000, "Selenium");

        // i am Demonstrating the work behavior of each object
        System.out.println("Employee: " + employee.getName() + " , employee id"+ employee.getEmployeeId()+ ", Salary: " + employee.getSalary());
        employee.work();

        System.out.println("\nManager: " + manager.getName() + ", Salary: " + manager.getSalary() +", Department: " + manager.getDepartment());
        manager.work();

        System.out.println("\nDeveloper: " + developer.getName() + ", Salary: " + developer.getSalary() +", Programming Language: " + developer.getProgrammingLanguage());
        developer.work();

        System.out.println("\nTester: " + tester.getName() + ", Salary: " + tester.getSalary() +", Testing Tool: " + tester.getTestingTool());
        tester.work();
    }
}

