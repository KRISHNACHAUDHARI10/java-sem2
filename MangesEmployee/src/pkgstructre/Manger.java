package pkgstructre;

class Manger extends Employee {
	   String Department;

	    public Manger(String name,int employeid,int salary,String Department) {
	        super(name,employeid, salary);
	        this.Department = Department;
	    }
	    
	    public void work() {
	    	System.out.println("i am mangerr");
	    }
}
