package archivo;

import java.util.ArrayList;

/**
 *
 * @author Jonatan
 */
public class administadorUsuario {
    private ArrayList<Usuario> listaUsuario = new ArrayList<>();
    
    public administadorUsuario(int elementos,VerificadorArchivo e) {
        String aux[];
        for(int i=0; i<e.getLista().size(); i++){
            aux = e.getLista().get(i);
            Usuario usuariooo = new Usuario(aux[0],aux[1]);
            listaUsuario.add(usuariooo);
        }
    }
    
    public void imprimir(){
        for(int i=0; i<listaUsuario.size(); i++){
            System.out.println(listaUsuario.get(i));
        }
    }
    
    public void verificarUsuarioContrasenia(String usuario, String contrasenia){
        
    }
    
    public void crearUsuario(String lista[]){
        
    }
    
    public boolean verificarUsuario(String Usuario){
        return false;
    }
    
    public boolean verificarUsuariobloqueado(String usuario){
        return false;
    }
    
    public boolean verificarContrasenia(String contrasenia){
        return false;
        
    }
    
    public void cambiarEstatusUsuario(String  usuario){
        
    }
}

