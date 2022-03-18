package archivo;

import java.util.Date;

/**
 *
 * @author Jonatan
 */
public class Usuario {
    private String nombre;
    private String contrasenia;
    private boolean estado;
    private int intentos;
    private long tiempoBloqueo;
    //false  = no bloqueado
    // true = bloqueado
    public Usuario(String nombre, String contrasenia) {
        this.estado = false;
        this.intentos = 0;
        this.tiempoBloqueo = 0;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrasenia=" + contrasenia + '}';
    }
    
    public boolean verificarContrasenia(String contrasenia){
        if(this.contrasenia.equals(contrasenia)){
            System.out.println("Correcto");
            return true;
        }else{
            bloquearUsuario();
            return false;
        }
    }
    
    public void bloquearUsuario(){
        intentos++;
        System.out.println("inCorrecto");
        if(!(intentos<3)){
            System.out.println("Se bloqueo el usuario");
            this.estado = true;
        }
    }
    
    public boolean verificarEstado(){
         if(estado){
             return true;
         }else{
             if(verificarTiempoRestanteBloque()){
                 //Se desbloquea
                 estado = false;
                 return false;
             }else{
                 return true;
             }
         }
    }
    
    public boolean verificarTiempoRestanteBloque(){
        Date fecha = new Date();
        long x = fecha.getTime() - tiempoBloqueo;
        if(x<600000){
            //Aun bloqueado
            return false;
        }else{
            return true;
        }
    }
        
}
