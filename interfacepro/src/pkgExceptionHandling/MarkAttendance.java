package pkgExceptionHandling;

import java.time.LocalTime;

public class MarkAttendance {
  public void scanCard(int lecNbr)throws LateComerException{
	  LocalTime currentTime = LocalTime.now();
	  LocalTime tmpLocalTime=null;
	  if(lecNbr == 1)
	  {
		  tmpLocalTime =tmpLocalTime.of(9,20);
	  }
	  else if(lecNbr == 1)
	  {
		  tmpLocalTime =tmpLocalTime.of(10,20);
	  }
	  if((lecNbr==1 && currentTime.isAfter(tmpLocalTime))||
		 (lecNbr==2 && currentTime.isAfter(tmpLocalTime)) ||
		 (lecNbr==3 && currentTime.isAfter(tmpLocalTime)))
{
			 throw new  LateComerException(tmpLocalTime.toString());
}
	  
 
  }
  
  
}
