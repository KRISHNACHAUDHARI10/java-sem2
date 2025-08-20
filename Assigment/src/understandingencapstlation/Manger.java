package understandingencapstlation;

class Manager extends Employee {
    String department;
    
    Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }
    
    @Override
    void details() {
        super.details();
        System.out.println("Department: " + department);
    }
    
    @Override
    void computeSalary() {
        salary *= 8;
    }
}
