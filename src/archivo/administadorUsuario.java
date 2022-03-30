package archivo;

import org.apache.commons.codec.binary.Base64;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonatan
 */
public class administadorUsuario {
    private ArrayList<Usuario> listaUsuario = new ArrayList<>();
    private ArrayList<String[]> lista = new ArrayList<>();
    int contador;
    
    public administadorUsuario(VerificadorArchivo e) {
        lista = e.getLista();
        crearUsuario();
    }

    public administadorUsuario() {
       
    }
            
    public final void crearUsuario(){
        String aux[];
        for(int i=0; i<lista.size(); i++){
            aux = lista.get(i);
            listaUsuario.add(new Usuario(aux[0],aux[1],Boolean.parseBoolean(aux[2]),Integer.parseInt(aux[3]),Long.parseLong(aux[4])));
        }
    }
    
    public boolean verificarUsuarioContrasenia() throws IOException{
        boolean x = false;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresar usuario: ");
        String usuario = teclado.nextLine();
     
        if(verificarUsuario(usuario)){
            if(listaUsuario.get(contador).verificarEstado() == false){
                System.out.println("Ingresar contraseña: "+listaUsuario.get(contador).getNombre());
                String contrasenia = teclado.nextLine();
                while(!verificarContrasenia(contrasenia) && !listaUsuario.get(contador).verificarEstado()){
                    System.out.println("Ingresar contraseña: "+listaUsuario.get(contador).getNombre());
                    contrasenia = teclado.nextLine();
                }
                if(verificarContrasenia(contrasenia)){
                    x = true;
                }
                VerificadorArchivo.actualizarDatosdeUsuarios(listaUsuario);
            }else{
                System.out.println("Está bloqueado");
                System.out.println("Bloqueado el: " +new Date(listaUsuario.get(contador).getTiempoBloqueo()));
            }
        }else{
            //System.out.println("Incorrecto");
        }
        return x;
    }
    
    public boolean verificarUsuario(String Usuario){
        contador = 0;
        int i=0;
       boolean x = false;
       for(Usuario usu : listaUsuario) {
            if(usu.getNombre().equals(Usuario)){
                x = true;
                contador = i;
            }
            i++;
        }
       
        return x;
    }
    
    public boolean verificarContrasenia(String contrasenia){
        boolean x = false;
        String secretKey = "SomosProgramadores";
        String cadenaAEncriptar = contrasenia;
        String cadenaEncriptada = ecode(secretKey, cadenaAEncriptar);
        if(listaUsuario.get(contador).verificarContrasenia(cadenaEncriptada)){
            x = true;
        }
        return x;        
    }
    
    public String ecode(String secretKey, String cadena) {
        String encriptacion = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo salió mal");
        }
        return encriptacion;
    }
        
}

