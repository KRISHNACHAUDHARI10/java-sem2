package pkgstructre;

public class EmployeeDemo {
  public static void main(String[] args) {
	   Developer obj1=new Developer("krishna",1,50000,"java");
	    Manger obj2=new Manger("rahul",2,4000,"gobva");
	    
	   System.out.print("name "+obj1.name+"id" +obj1.employeid+"salary" +obj1.salary);
	   obj1.work();
	   System.out.print("name "+obj2.name+"id" +obj2.employeid+"salary" +obj2.salary);
	   obj2.work();
  }
}
