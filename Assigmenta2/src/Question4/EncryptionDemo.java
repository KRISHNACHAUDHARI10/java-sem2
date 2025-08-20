package Question4;

public class EncryptionDemo {
	 public static void main(String[] args) {
	        String text = "Hello, Encryption!";

	        // AES Encryption
	        AES aes = new AES();
	        String aesEncrypted = aes.encrypt(text);
	        String aesDecrypted = aes.decrypt(aesEncrypted);
	        System.out.println("before encrypt  :- " +"Hello, Encryption!");
	        System.out.println("After  encrypt  :- " + aesEncrypted);
	        System.out.println("AES Decrypted: " + aesDecrypted);

	        // RSA Encryption
	        RSA rsa = new RSA();
	        String rsaEncrypted = rsa.encrypt(text);
	        String rsaDecrypted = rsa.decrypt(rsaEncrypted);
	        System.out.println("RSA Encrypted: " + rsaEncrypted);
	        System.out.println("RSA Decrypted: " + rsaDecrypted);
	    }
}
