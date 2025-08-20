package Polo;

class Apartment{
 void sam() {
	 System.out.print("hello world surat");
     }
 }
class Room extends Apartment{
    @Override
 	void sam() {
		  System.out.print("hello world");
	}	 
}
public class OOverloding {
   public static void main(String[] args) {
	  Apartment obj =new Apartment();
      obj.sam();
      
  }

}
