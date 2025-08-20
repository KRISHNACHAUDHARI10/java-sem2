package understandingencapstlation;

class Employee {
    String name;
    int id;
    double salary;
    
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    void details() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
    
    void computeSalary() {
        // Base method to be overridden
    }
}
