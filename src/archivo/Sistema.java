package archivo;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Sistema{
    VerificadorArchivo verificadorArchivo = new VerificadorArchivo();
    
    public Sistema(String ruta, String nombre) throws IOException {
        boolean aux = verificarArchivoUsuario(ruta, nombre);
        if(aux){
            aux = verificarArchivoVacio(ruta,nombre);
            if (!aux){
                aux = verificarEstructuraArchivo(ruta,nombre);
                if(aux){
                    mostrarInterfazUsuario();
                }else{
                   alertaArchivoMalEstructurado(); 
                }
                //probando
            }else{
                alertaArchivoUsuarioVacio();
            }
        }
        else{
            alertaArchivoUsuarioNoexiste();
        }
    }

    public boolean verificarArchivoUsuario(String ruta, String nombre) throws IOException{
        return verificadorArchivo.verificarExitenciaArchivo(ruta, nombre);
    }

    private void mostrarInterfazUsuario(){
        System.out.println("Existe :D");
    }

    public void verificarUsuarioContrasena(){}

    public void mostrarMeu(){}
    
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
    
    public boolean verificarArchivoVacio(String ruta, String nombre) throws IOException{
        return verificadorArchivo.verificarArchivoVacio(ruta, nombre);
    }
    
    public boolean verificarEstructuraArchivo(String ruta, String nombre) throws IOException{
        return verificadorArchivo.verificarEstructuraArchivo(ruta, nombre);
    }
    
}