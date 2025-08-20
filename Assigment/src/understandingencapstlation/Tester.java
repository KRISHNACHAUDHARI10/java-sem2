package understandingencapstlation;

class Tester extends Employee {
    String testingTool;
    
    Tester(String name, int id, double salary, String testingTool) {
        super(name, id, salary);
        this.testingTool = testingTool;
    }
    
    @Override
    void details() {
        super.details();
        System.out.println("Testing Tool: " + testingTool);
    }
    
    @Override
    void computeSalary() {
        salary *= 5;
    }
}