package pkgstructre;
class Developer extends Employee {
    String Department;

    public Developer(String name, int employeid, int salary, String Department) {
        super(name, employeid, salary);
        this.Department = Department;
    }
    
    public void work() {
    	System.out.println("i am devloper");
    }
}
