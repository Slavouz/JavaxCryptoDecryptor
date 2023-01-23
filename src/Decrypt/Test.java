package Decrypt;

/**
 *
 * @author davinky
 */
import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Security.setProperty("crypto.policy", "unlimited");
        System.out.println("Max AES key length = " + Cipher.getMaxAllowedKeyLength("AES"));
    }   
}
