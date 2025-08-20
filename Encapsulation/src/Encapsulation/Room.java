package Encapsulation;

public class Room {
	
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
	public void setid(int id) {
		this.id=id;
	}
	public void setname(String name) {
		this.name= name; 
	}
	public void setaddresh(String  addresh) {
		  this.addresh=addresh;  
	}
public static void main(String[] args) {
    Room obj =new Room();
   obj.setid(1);
   obj.setname("krishna");
   obj.setaddresh("mumbai");
  System.out.println(obj.getid());
  System.out.println(obj.getname());
  System.out.println(obj.getaddresh());
  }
}
