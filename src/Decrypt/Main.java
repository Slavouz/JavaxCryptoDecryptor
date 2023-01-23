package Decrypt;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author davinky
 */
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class Main {       
    
    // AES CBC Decryptor
    
    public static void main(String[] args) throws Exception {
        String b64Cipher = "92ts89G64rplnUpPRtNeFxX7sn6QRxGZaZi9Nx626GvcQPpLxGpKLbdr3zktre41njjngAdQqgHfnND602AY0KK0f/klZcDTE6bbtnstGg/Z9xUlslmFKMDSMRo8I87Thr2lRh5gGh11Ba/sRrDQ1tHd1PCWzqSK8CeCaTwBXAxWpb4Ie1RLIkpBGRCjRWZFdILF/fGYLYdajZWPtZqL2q88cOXAs93W0McmJo7Lu4/MqIO2dpIBYqmA9Kb/ITbp";
        byte[] cipherBytes = Base64.decodeBase64(b64Cipher);
        byte[] iv = "bVKDklQXQovG9vQOU8XUGg==".getBytes(StandardCharsets.US_ASCII);
        iv = Base64.decodeBase64(iv);
        byte[] keyBytes = "SezOLyAsKO9AphwT6QO/SA==".getBytes(StandardCharsets.US_ASCII);
        keyBytes = Base64.decodeBase64(keyBytes);
        
        SecretKey aesKey = new SecretKeySpec(keyBytes, "AES");
        
        Cipher cipher = Cipher.getInstance("AES/CBC/NOPADDING");
        cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));
        
        byte[] result = cipher.doFinal(cipherBytes);
//        System.out.println(Hex.encodeHex(result));
        String res = Hex.encodeHexString(result);
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < res.length(); i+= 2) {
            String str = res.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        System.out.println(output.toString());
    }
    
}
