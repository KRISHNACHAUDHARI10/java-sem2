class Subclass extends Superclass {
    String dname;
  
 Subclass(String name,int age,int number,String dname){
    	super(name,age,number);
    	this.dname=dname;
 }
 public  String dname(){
	  return dname;
 }
 public void work() {
	 System.out.println("hello world");
 }
	
 }
 
 
 
 