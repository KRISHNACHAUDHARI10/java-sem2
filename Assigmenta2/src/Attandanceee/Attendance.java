package Attandanceee;

import java.util.Scanner;

import java.util.ArrayList;
public class Attendance{
	 
	public static void main(String[] args) {
	
   ArrayList<String> DivisionA = new ArrayList<>();
   ArrayList<String> DivisionB = new ArrayList<>();
   

   DivisionA.add("Student s1");
   DivisionA.add("Student s2");
   DivisionA.add("Student s3");
   DivisionA.add("Student s4");
   DivisionA.add("Student s5");
   
   
   DivisionB.add("Student b1");
   DivisionB.add("Student b2");
   DivisionB.add("Student b3");
   DivisionB.add("Student b4");
   DivisionB.add("Student b5");
   
   ArrayList<String> Consolited = new ArrayList<>();
   
   Consolited.addAll(DivisionA);
   Consolited.addAll(DivisionB);
   
	System.out.print("this is consolited list of the student");
	   
	for(String Student : Consolited) {
		
		System.out.println(Student);
	}
	
	
} 
	
}
