package pkgExceptionHandling;

public class LateComerException {
    
	/** 
     this is custom exception classs 
     */
	
	private String tmstp;
	
	LateComerException(String tm) {
	
		tmstp = tm;
   
	
	}
	

	public String toString() {
	
    	return ("this is LateComerException the in time is :" + tmstp + "you are late"); 

    }
    


}
