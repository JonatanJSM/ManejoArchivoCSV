package archivo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jonatan
 */
public class administadorUsuario {
    private ArrayList<Usuario> listaUsuario = new ArrayList<>();
    private ArrayList<String[]> lista = new ArrayList<>();
    int contador;
    
    public administadorUsuario(int elementos,VerificadorArchivo e) {
        lista = e.getLista();
        crearUsuario();
    }
    
    
    
    
    public void imprimir(){
        for(int i=0; i<lista.size(); i++){
            System.out.println(listaUsuario.get(i));
        }
    }
        
    public final void crearUsuario(){
        String aux[];
        for(int i=0; i<lista.size(); i++){
            aux = lista.get(i);
            Usuario usuariooo = new Usuario(aux[0],aux[1]);
            listaUsuario.add(usuariooo);
        }
    }
    
    public boolean verificarUsuarioContrasenia(){
        boolean x = false;
        Scanner teclado = new Scanner(System.in);
        String usuario = teclado.nextLine();
        String contrasenia = teclado.nextLine();
        if(verificarUsuario(usuario)){
            if(verificarContrasenia(contrasenia)){
                System.out.println("Correcto!");
                x = true;
            }else{
                 System.out.println("Contraseña incorrecta");
            }
        }else{
            System.out.println("No hay usuario");
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
        if(listaUsuario.get(contador).getContrasenia().equals(contrasenia)){
            x = true;
        }
        return x;        
    }
    
    
    public boolean verificarUsuariobloqueado(String usuario){
        return false;
    }
    
    public void cambiarEstatusUsuario(String  usuario){
        
    }
    
}

