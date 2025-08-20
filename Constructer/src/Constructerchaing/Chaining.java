package Constructerchaing;
 
public class Chaining {
	
	String empName;
	int empId;
	String desgnation;
	
	public Chaining(String empName,int empID){
		this.empName= empName;
		this.empId= empId;
		System.out.println("emp name  :" + empName +"Emp id :"+empId);
	}
	
 public Chaining(String empdesgnation){
		
		this.empId=empId;
		desgnation = empdesgnation;
		System.out.println("desgnation" +desgnation + "");
	
	} 
public static void main(String[] args) {
	
	
	   Chaining e=new Chaining("xyz",31);
	   Chaining e1=new Chaining(" engineer");
   
   }  
}
