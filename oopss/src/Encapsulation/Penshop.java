package Encapsulation;

public class Penshop {
  public static void main(String[] args) {
	 Pen obj =  new Pen();
	 System.out.println(obj.getpentip() );
	 obj.setpentip(15);
	 System.out.println(obj.getpentip() );
	 
  }
}
 


class Pen {
	 private String  color;
	 private  int tip=5;
	 
	public  int  getpentip() {
		 return this.tip;
	 }
	public  void setpentip(int tfefdip) {
		this.tip = tfefdip; 
	 }
	 
}
 