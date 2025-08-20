package Encapsulation;


public class Question1 {
	private String name;
	private  int age;
	private  int roll_no;
	
	
public String getname() {
    return name;
}
	
public int getage() {
		return age;
	
}
	
public void setname(String name) {
		this.name=name;
		

}
	

public void setage(int age) {

	this.age=age;
	
}
	
  public static void main(String[ ] args) {
       Question1 obj1 =new  Question1();
	   obj1.setname("KRISHNA");
	   obj1.setage(20);
	   obj1.getname();
	   obj1.getage();
	   System.out.println(obj1.getname());
	   System.out.println(obj1.getage());
     
  }
  
}