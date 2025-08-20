package Employee_mangement;

public class EngineeringDepartment implements Employee{
    
	private String name;
    private double payScale;

    // Constructor to initialize employee details
    public EngineeringDepartment(String name, double payScale) {
        this.name = name;
        this.payScale = payScale;
    }

    // Overriding the enroll method
    @Override
    public void enroll() {
        System.out.println("Employee " + name + " has been enrolled in the Engineering Department.");
    }

    // Overriding the terminate method
    @Override
    public void terminate() {
        System.out.println("Employee " + name + " has been terminated from the Engineering Department.");
    }

    // Overriding the calculatePay method
    @Override
    public void calculatePay() {
        System.out.println("The total salary of " + name + " from Engineering Department is: " + payScale);

    }

}




