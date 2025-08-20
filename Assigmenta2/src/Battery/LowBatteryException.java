package Battery;

//Custom Exception for Low Battery
class LowBatteryException extends Exception {
 public LowBatteryException(String message) {
     super(message);
 }
}
