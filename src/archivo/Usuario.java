package archivo;

import java.util.Date;

/**
 *
 * @author Jonatan
 */
public class Usuario {
    private String nombre;
    private String contrasenia;
    private String estado;
    private int intentos;
    private long tiempoBloqueo;
    //NB no bloqueado, SB bloqueado
    public Usuario(String nombre, String contrasenia) {
        this.estado = "NB";
        this.intentos = 0;
        this.tiempoBloqueo = 0;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrasenia=" + contrasenia + '}';
    }
    
    public boolean verificarContrasenia(String contrasenia){
        if(this.contrasenia.equals(contrasenia)){
            return true;
        }else{
            intentos++;
            if(!(intentos<3)){
                estado = "SB";
            }
            return false;
        }
    }
    
    public String verificarEstado(){
         if(estado.equals("NB")){
             return "NB";
         }else{
             if(verificarTiempoRestanteBloque()){
                 //Se desbloquea
                 estado = "NB";
                 return "NB";
             }else{
                 return "SB";
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
