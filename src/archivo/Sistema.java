package archivo;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Sistema{
    private VerificadorArchivo verificadorArchivo;
    
    public Sistema(String ruta, String nombre) throws IOException {
        verificadorArchivo = new VerificadorArchivo();
        boolean aux = verificarArchivoUsuario(ruta, nombre);
        if(aux){
            aux = verificarArchivoVacio(ruta,nombre);
            if (!aux){
                aux = verificarEstructuraArchivo(ruta,nombre);
                if(aux){
                    mostrarInterfazUsuario();
                    administadorUsuario adminUsuario = new administadorUsuario(2,verificadorArchivo);
                    adminUsuario.verificarUsuarioContrasenia();
                }else{
                   alertaArchivoMalEstructurado(); 
                }
            }else{
                alertaArchivoUsuarioVacio();
            }
        }
        else{
            alertaArchivoUsuarioNoexiste();
        }
    }

    private boolean verificarArchivoUsuario(String ruta, String nombre) throws IOException{
        return verificadorArchivo.verificarExitenciaArchivo(ruta, nombre);
    }

    private void mostrarInterfazUsuario(){
        System.out.println("Existe :D");
    }

    public void verificarUsuarioContrasena(){}

    public void mostrarMeu(){
        System.out.println("Hola, se ha ingresado");
    }
    
    private void alertaArchivoUsuarioNoexiste(){
        JOptionPane.showMessageDialog(null, "Error, no se encontro el archivo");
        System.exit(0);
    }
    
    private void alertaArchivoUsuarioVacio(){
        JOptionPane.showMessageDialog(null, "El archivo está vacio");
        System.exit(0);
    }
    
    private void alertaArchivoMalEstructurado(){
        JOptionPane.showMessageDialog(null, "El archivo está mal estructurado");
        System.exit(0);
    }
    
    public void ingresarUusarioContrasenia(){}
    
    private boolean verificarArchivoVacio(String ruta, String nombre) throws IOException{
        return verificadorArchivo.verificarArchivoVacio(ruta, nombre);
    }
    
    private boolean verificarEstructuraArchivo(String ruta, String nombre) throws IOException{
        try {
            return verificadorArchivo.verificarEstructuraArchivo(2, ",",ruta,nombre);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en los elementos");
             System.exit(0);
            return false;
        }
    }    
}