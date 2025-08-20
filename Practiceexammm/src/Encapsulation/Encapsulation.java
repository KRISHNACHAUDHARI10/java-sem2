package Encapsulation;

public class Encapsulation {
	private int id;
	private String name;
	private String addresh;
	
  public void setid(int id) {   
	   System.out.print(id);
  }
  public void setname(String name) {
	  System.out.print(name);
  }
  public void setaddresh(String addresh) {
	  System.out.print(addresh);
  }
	
  public int getid() {
	  return id;
  }
  public String  getname() {
	  return name;
  }

  public String  getaddresh() {
	  return addresh;
  }
  
  
public static void main(String[] args) {
	   
	 Encapsulation obj = new  Encapsulation();
	 obj.setid(1);
	 obj.setname("krishna");
    obj.setaddresh("gujrat");
//   System.out.println(obj.getid());
//   System.out.println(obj.getname());
//   System.out.println(obj.getaddresh());  
}
   
}
