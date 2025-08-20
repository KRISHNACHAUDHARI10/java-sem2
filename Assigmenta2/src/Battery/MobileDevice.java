package Battery;

class MobileDevice {
    private int batteryPercentage;

    public MobileDevice(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public void checkBattery() throws LowBatteryException, InsufficientChargeException {
        if (batteryPercentage < 10) {
            throw new InsufficientChargeException("Battery is below 10%. Power saver mode activated.");
        } else if (batteryPercentage < 20) {
            throw new LowBatteryException("Battery is low (" + batteryPercentage + "%). Please charge your device.");
        } else {
            System.out.println("Battery level is sufficient: " + batteryPercentage + "%");
        }
    }

    public void enablePowerSaverMode() {
        System.out.println("Power saver mode is now ON.");
    }
}