package Encapsulation;

public class type {
	private int id;
	private String name;
	private String addresh;
	
	
	public int getid() {
		return id;
	}
	public String getname() {
		return name;
	}
	public String getaddresh() {
		return addresh;
	}
	public  void setid(int id) {
		this.id= id;
}
	public  void setname(String name) {
		this.name=name;
	}
	public void setaddresh(String addresh) {
		this.addresh=addresh;
	}
   public static void main(String[] args) {
	  	  
	  type  obj = new type();
	  obj.setid(1);
	  obj.setname("krishna");
	  obj.setaddresh("mumbaid");
     System.out.print(obj.getname());		
	}
}




