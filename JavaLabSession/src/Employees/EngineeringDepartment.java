package Employees;

import java.util.Scanner;

public class EngineeringDepartment implements Employee{
	private   String   name;
	private   String    postion;
	private   int       salary;
	
	
	
public void enroll() {
	  Scanner  scanner = new Scanner(System.in);	
	  
	  System.out.print("type your name");
	  name = scanner.nextLine();
	  System.out.print("type your postion :(engineer/manager) :");
	  postion = scanner.nextLine();
	  System.out.println("user name is"+name+"user postion is "+ postion);
}
	
	public void terminate() {
		System.out.print(name+ "you are terminated");
	}
	
	public void calculatepay() {
		if(postion.equalsIgnoreCase("engineer")) {		
			 salary =5000;
		}else if(postion.equalsIgnoreCase("manger"))
		{
			salary =7000;
		}
		else {
			salary = 3000;
		}
	System.out.print(name+ "your salary is "+salary);
	}
		
}
	
