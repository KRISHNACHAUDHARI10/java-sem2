package Employees;
import java.util.Scanner;
class ProductionDepartment implements Employee{
	private   String name;
	private  String   postion;
	private  int  salary;
	
	public  ProductionDepartment() {
		//default
	}
	
public void enroll() {
	  Scanner  scanner = new Scanner(System.in);	
	  
	  System.out.print("type your name");
	  name = scanner.nextLine();
	  System.out.print("type your postion :(Worker/supervicer) :");
	  postion = scanner.nextLine();
	  
	  
	  System.out.println("user name is"+name+"user postion is "+ postion);
}
	
	public void terminate() {
		System.out.print(name+ "you are terminated");
	}
	
	public void calculatepay() {
		if(postion.equalsIgnoreCase("worker")) {		
			 salary =3000;
		}else if(postion.equalsIgnoreCase("supervicer"))
		{
			salary =5000;
		}
		else {
			salary = 2000;
		}
	System.out.print(name+ "your salary is "+salary);
	}
		
}