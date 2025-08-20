package Employees;

public class Main {
    public static void main(String[] args) {
       ProductionDepartment  objproduction = new ProductionDepartment();
       objproduction.enroll();
       objproduction.calculatepay();
       objproduction.terminate();
       
      
       
       
       EngineeringDepartment objEngineer = new EngineeringDepartment();
       objEngineer.enroll();
       objEngineer.calculatepay();
       objEngineer.terminate();
       }
}
