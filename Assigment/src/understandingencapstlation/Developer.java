package understandingencapstlation;

//Derived class: Developer
class Developer extends Employee {
 String programmingLanguage;
 
 Developer(String name, int id, double salary, String programmingLanguage) {
     super(name, id, salary);
     this.programmingLanguage = programmingLanguage;
 }
 
 @Override
 void details() {
     super.details();
     System.out.println("Programming Language: " + programmingLanguage);
 }
 
 @Override
 void computeSalary() {
     salary *= 6;
 }
}