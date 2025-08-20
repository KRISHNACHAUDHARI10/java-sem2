package Employee_mangement;

public class Main {
	 public static void main(String[] args) {
	        // Create employee objects for both departments
	        Employee prodEmp = new ProductionDepartment("John Doe", 50000);
	        Employee engEmp = new EngineeringDepartment("Jane Smith", 70000);

	        // Enroll employees in respective departments
	        prodEmp.enroll();
	        engEmp.enroll();

	        // Calculate and print the pay for each employee
	        prodEmp.calculatePay();
	        engEmp.calculatePay();

	        // Terminate employees from their respective departments
	        prodEmp.terminate();
	        engEmp.terminate();
	    }
}
