package Assigmentquestion;



public class Manager extends Employee {
    private String department;

    // Constructor
    public Manager(String name, int employeeId, double salary, String department) {
        super(name, employeeId, salary)
        this.department = department;
    }

    //   i am getting method
    public String getDepartment() {
        return department;
    }

    //  we are override wor
    @Override
    public void work() {
        System.out.println(getName() + " is managing the " + department + " department.");
    }
}
