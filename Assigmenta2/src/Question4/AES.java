package Question4;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
class AES implements Encryptable {
    private SecretKey secretKey;

    // Constructor to generate AES key
    public AES() {
        try {
        	KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(256); // Set AES key size to 256 bits
            secretKey = keygen.generateKey(); // Generate the key
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
}

    // AES Encryption
    public String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // AES Decryption
    public String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}