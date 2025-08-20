package Construcoter;

public class Copyconstructore {
  public static void main(String[] args) {
	   Student s1 = new Student();
	   s1.name="krishna";
	   s1.roll = 20;
	   s1.password = "abcd";
	   s1.marks[0] =100;
	   s1.marks[1]=85;
	   s1.marks[2]=45;
	   Student s2 = new Student(s1);
	   s2.password="xyz";
	   
	   for(int i=0; i<3; i++) {
		     System.out.println(s2.marks[i]);
		     }
	   
	     
  }
}
class Student{
	String name;
	int roll;
	String  password;
	int marks[]; 

	Student(Student s1){
	    marks = new int[3];
		this.name =name;
	}
	Student(){
		
	}
	
}