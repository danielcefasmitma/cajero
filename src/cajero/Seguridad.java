package cajero;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Clase Seguridad para cifrar y descifrar datos utilizando el algoritmo AES.
 */
public class Seguridad {

    private static final String ALGORITMO= "AES";
    
    private static final String CLAVE_SECRETA = "miclavesecreta12";

    /**
     * Obtiene la clave secreta para el cifrado y descifrado.
     * @return La clave secreta como un objeto SecretKey.
     */
    private static SecretKey getSecretKey() {
        byte[] keyBytes = CLAVE_SECRETA.getBytes();
        return new SecretKeySpec(keyBytes, ALGORITMO);
    }

    /**
     * Cifra los datos proporcionados utilizando el algoritmo AES.
     * 
     * @param data Los datos a cifrar.
     * @return Los datos cifrados en formato Base64.
     */
    public static String cifrar(String data) {
        byte[] encryptedBytes = null;
        try {
            SecretKey secretKey = getSecretKey();
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptedBytes = cipher.doFinal(data.getBytes());

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    /**
     * Descifra los datos proporcionados utilizando el algoritmo AES.
     * 
     * @param encryptedData Los datos cifrados en formato Base64.
     * @return Los datos descifrados como una cadena de texto.
     */
    public static String descifrar(String encryptedData) {
        byte[] decryptedBytes = null;
        try {
            SecretKey secretKey = getSecretKey();
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            decryptedBytes = cipher.doFinal(decodedBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return new String(decryptedBytes);
    }
}
