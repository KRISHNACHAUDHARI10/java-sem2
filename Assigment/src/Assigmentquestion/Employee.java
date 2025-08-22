package Assigmentquestion;




public class Employee {
    private String name;
    private int employeeId
    private double salary;

    // Constructor
    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void work() {
        System.out.println(name + " is working");
    }
}
