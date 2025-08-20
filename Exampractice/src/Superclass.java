public class Superclass {
    String name;
    int age;
    int number;
    
    
Superclass(String name,int age,int number){
    	 this.name=name;
    	 this.age=age;
    	 this.number=number;
 }
    
public String getname() {
    	  return name;
}
public int getage() {
    	return age;
}
public  int getnumber() {
    	return number;
}
void work() {
    	System.out.println("hy i am method overloding"); 
    }
}
