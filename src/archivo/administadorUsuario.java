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
            
    public final void crearUsuario(){
        String aux[];
        for(int i=0; i<lista.size(); i++){
            aux = lista.get(i);
            listaUsuario.add(new Usuario(aux[0],aux[1]));
        }
    }
    
    public void verificarUsuarioContrasenia(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresar usuario: ");
        String usuario = teclado.nextLine();
     
        if(verificarUsuario(usuario)){
            if(!listaUsuario.get(contador).verificarEstado()){
                System.out.println("Ingresar contraseña: "+listaUsuario.get(contador).getNombre());
                String contrasenia = teclado.nextLine();
                while(!verificarContrasenia(contrasenia) && !listaUsuario.get(contador).verificarEstado()){
                    System.out.println("Ingresar contraseña: "+listaUsuario.get(contador).getNombre());
                    contrasenia = teclado.nextLine();
                }
            }else{
                System.out.println("Está bloqueado");
            }
        }else{
            System.out.println("No hay usuario");
        }
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
        if(listaUsuario.get(contador).verificarContrasenia(contrasenia)){
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

