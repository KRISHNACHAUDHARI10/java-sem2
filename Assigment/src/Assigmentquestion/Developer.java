package Assigmentquestion;


public class Developer extends Employee {
    
	private String programmingLanguage;

    // Constructor
    public Developer(String name, int employeeId, double salary, String programmingLanguage) {
        super(name, employeeId, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Getter
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    // Override work method
    
    @Override	
    public void work() {
        System.out.println(getName() + " is developing in " + programmingLanguage + ".");
     }
       
    

}
