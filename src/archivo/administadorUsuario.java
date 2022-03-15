package archivo;

import java.util.ArrayList;

/**
 *
 * @author Jonatan
 */
public class administadorUsuario {
    private ArrayList<Usuario> listaUsuario = new ArrayList<>();
    private ArrayList<String[]> lista = new ArrayList<>();
    
    public administadorUsuario(int elementos,VerificadorArchivo e) {
        lista = e.getLista();
        crearUsuario();
    }
        
    public final void crearUsuario(){
        String aux[];
        for(int i=0; i<lista.size(); i++){
            aux = lista.get(i);
            Usuario usuariooo = new Usuario(aux[0],aux[1]);
            listaUsuario.add(usuariooo);
        }
    }
    
    public void verificarUsuarioContrasenia(String usuario, String contrasenia){
        if(verificarUsuario(usuario)){
            if(verificarContrasenia(contrasenia)){
                System.out.println("Correcto!");
            }else{
                 System.out.println("Contraseña incorrecta");
            }
        }else{
            System.out.println("No hay usuario");
        }
    }
    
    public boolean verificarUsuario(String Usuario){
       boolean x = false;
       for(Usuario usu : listaUsuario) {
            if(usu.getNombre().equals(Usuario)){
                x = true;
            }
        }
        return x;
    }
    
    public boolean verificarContrasenia(String contrasenia){
        boolean x = false;
        for (Usuario usu : listaUsuario) {
            if(usu.getContrasenia().equals(contrasenia)){
                x = true;
            }
        }
        return x;        
    }
    
    
    public boolean verificarUsuariobloqueado(String usuario){
        return false;
    }
    
    public void cambiarEstatusUsuario(String  usuario){
        
    }
    
    public void imprimir(){
        for(int i=0; i<lista.size(); i++){
            System.out.println(listaUsuario.get(i));
        }
    }
}

