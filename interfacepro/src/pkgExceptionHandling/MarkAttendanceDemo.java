package pkgExceptionHandling;

public class MarkAttendanceDemo {
  public static void main(String[] args) {
	 MarkAttendance mkAttobj=new 	 MarkAttendance ();
	 try {
		 mkAttobj.scanCard();
	 }
	 catch(LateComerException lce) {
		 System.out.print(lce);
	 }
  } 
}
