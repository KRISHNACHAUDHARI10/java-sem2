package Battery;

public class MobileCompney {
	
	    public static void main(String[] args) {
	        // Simulate different battery levels
	        MobileDevice phone = new MobileDevice(9);

	        try {
	            phone.checkBattery();
	        } catch (InsufficientChargeException e) {
	            System.out.println("Exception: " + e.getMessage());
	            phone.enablePowerSaverMode();
	        } catch (LowBatteryException e) {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    
	}

}
