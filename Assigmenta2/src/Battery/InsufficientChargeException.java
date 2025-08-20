package Battery;


//Custom Exception for Insufficient Charge
class InsufficientChargeException extends Exception {
 public InsufficientChargeException(String message) {
     super(message);
 }
}
