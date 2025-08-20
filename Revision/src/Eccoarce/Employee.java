package Eccoarce;

public class Employee {
     
	 private String name;
     private int  conteact;
     private String addresh;
     private String email;
     private int password;
     
     public Employee( String name,int  conteact,String addresh, String email,int password) {
             	  this.name=name;
             	  this.conteact=conteact;
             	  this.addresh=addresh;
                 this.email=email;
                 this.password=password;
     }

  public String getname() {
	        return name;
  
  }
  public int getconteact() {
      return conteact;
}
  public String getaddresh() {
      return addresh;
}
  
  public String getemail() {
      return email;
}
  
  public int getpassword() {
	  return password;
  }
  




}
