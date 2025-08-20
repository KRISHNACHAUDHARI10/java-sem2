package Assigmentquestion;



public class Tester extends Employee {
    private String testingTool;

    // Constructor
    public Tester(String name,int  employeeId, double salary, String testingTool ) {
    	
        super(name, employeeId, salary);
        this.testingTool = testingTool;
        
    }

    // Getter
    public String getTestingTool() {
        return testingTool;
    }

    // Override work method
    @Override
    public void work() {
        System.out.println(getName() + " is testing using " + testingTool + ".");
    }
}






