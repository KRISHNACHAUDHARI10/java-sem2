package Encapsulation;

public class Question2 {
	
	private String name;
	private int age;
	  
   public String  getname(){
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
   public static void main(String[] args) {
   Question2  obj1 =new  Question2();
      obj1.setname("krishbna");
      obj1.setage(14);
      System.out.print(obj1.getname());
      System.out.print(obj1.getage());
    }
}
