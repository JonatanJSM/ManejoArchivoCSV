package archivo;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author jonatan
 */
public class Encriptaciones {
    
    private Encriptaciones(){

    } 

    static String LLAVE = "SomosProgramadores";


    //Clave para encriptar / desencriptar
    public static SecretKeySpec crearClave(String llave){

        try{
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena =md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;

        }catch (Exception e){
            return null;
        }
    }

    //Encriptar
    public static String encriptar(String encriptarCadena){

        try{
            SecretKeySpec secretKeySpec = crearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte [] cadena = encriptarCadena.getBytes("UTF-8");
            byte [] encriptada = cipher.doFinal(cadena);
            String cadenaEncriptada = Base64.getEncoder().encodeToString(encriptada);
            return cadenaEncriptada;


        }catch (Exception e){
            return "";
        }
    }
    
}