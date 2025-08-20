package compney;

import java.util.Scanner;

public class ProductionDepartment {
	private String name;
	private String postion;
	private int salary;
	
	
	//involke methods
	
	public void enroll() {
		Scanner sc= new Scanner(System.in);
		System.out.println("type your name");
		name = sc.nextLine();
		
		System.out.print("type your postion: - (worker,helpar)");
		postion = sc.nextLine();

	 System.out.println("your name :- " +name+"your postion is" +postion);
	}
	//invoke terminate
	
	public void terminate() {
		System.out.print("your are terminated");
	}
	
	public void calculatepay() {
		if(postion.equalsIgnoreCase("worker")) {
			salary = 3000;
		}
		else if(postion.equalsIgnoreCase("helpar")) {
			salary= 2000;
		}
		else {
			salary= 1000;
		}
		System.out.println("your salary "+salary);
	}
}
