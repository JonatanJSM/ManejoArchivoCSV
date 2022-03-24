package archivo;

import java.util.Date;

/**
 *
 * @author Jonatan
 */
public class Usuario {
    private String nombre;
    private String contrasenia;
    private boolean estado = false;
    private int intentos = 0;
    private long tiempoBloqueo = 0;
    //false  = no bloqueado
    // true = bloqueado
    public Usuario(String nombre, String contrasenia) {
        this.estado = false;
        this.intentos = 0;
        this.tiempoBloqueo = 0;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public Usuario(String nombre, String contrasenia, boolean estado, int intentos, long tiempoBloqueo) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.intentos = intentos;
        this.tiempoBloqueo = tiempoBloqueo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public long getTiempoBloqueo() {
        return tiempoBloqueo;
    }
    
    

    @Override
    public String toString() {
        return  nombre+","+contrasenia+","+estado+","+intentos+","+tiempoBloqueo;
    }
        
    public boolean verificarContrasenia(String contrasenia){
        if(this.contrasenia.equals(contrasenia)){
            System.out.println("Correcto");
            intentos = 0;
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
            Date fecha = new Date();
            tiempoBloqueo = fecha.getTime();
            this.estado = true;
        }
    }
    
    public boolean verificarEstado(){
         if(estado == false){
             return false;
         }else{
             if(verificarTiempoRestanteBloque()==false){
                 //Se desbloquea
                 estado = false;
                 intentos = 0;
                 return false;
             }else{
                 return true;
             }
         }
    }
    
    public boolean verificarTiempoRestanteBloque(){
        Date fecha = new Date();
        long x = fecha.getTime() - tiempoBloqueo;
        if(x<60000){
            //600000 10 minutos
            //60000  1 minuto
            //Aun bloqueado
            //System.out.print("aquí");
            return true;
        }else{
            //System.out.print("o aquí");
            return false;
        }
    }
        
}
