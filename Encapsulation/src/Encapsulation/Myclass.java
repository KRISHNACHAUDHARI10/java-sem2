package Encapsulation;

public class Myclass {
    private String name;
    private int age;
    private  int salary;
    
    
  
     //  encapsulation 
    public  String getname() {
    	return name;
    	
    }
    public int getage() {
    	return age;
    }
    public int getsalary() {
    	return salary;
    	
    }
    public  void setname(String name) {
        this.name= name;
    }
    
    public  void setage(int age) {
        this.age= age;
    }
    public  void setsalary(int salary) {
        this.salary= salary;
    }   
    
    
    public  void setsalary(String salary) {
        
    }
    public static void main(String[] args) {
    	Myclass obj  = new Myclass();
    	obj.setname("krishna");
    	obj.setage(50);
    	obj.setsalary(50000);
    	
    	
    	System.out.print(obj.getname());
      	System.out.print(obj.getage());
      	System.out.print(obj.getsalary());
    	
    	
    	
    }
    
    
 

}
