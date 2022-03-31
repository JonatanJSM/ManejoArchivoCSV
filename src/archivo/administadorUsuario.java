package archivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
        String cadenaEncriptada = Encriptaciones.encriptar(cadenaAEncriptar);
        if(listaUsuario.get(contador).verificarContrasenia(cadenaEncriptada)){
            x = true;
        }
        return x;        
    }
        
}

