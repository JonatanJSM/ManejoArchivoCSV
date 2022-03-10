package archivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class VerificadorArchivo{
    
    public boolean verificarExitenciaArchivo(String ruta, String nombre) throws IOException{
        ruta += "\\"+nombre;
        boolean archivoExitente = true;
        File archivo = new File(ruta);
        if(!archivo.exists()){
            archivoExitente = false;
        }
        return archivoExitente;
    }

    public boolean verificarEstructuraArchivo(String ruta, String nombre) throws IOException{
        FileReader fr;
        String aux = "";
        ruta += "\\"+nombre;
        boolean archivoExitente = true;
        try{
            fr = new FileReader(ruta);
            String linea = "";
            BufferedReader buff = new BufferedReader(fr);
                while((linea = buff.readLine()) != null){
                    String[] datoslinea = linea.split(",");
                        aux = datoslinea[0];
                        aux = datoslinea[1];
                }
        }catch(ArrayIndexOutOfBoundsException a){
            archivoExitente = false;
        }
        return archivoExitente;
    }
    
    public boolean verificarArchivoVacio(String ruta, String nombre) throws IOException{
        FileReader fr;
        ruta += "\\"+nombre;
        fr = new FileReader(ruta);
        BufferedReader buff = new BufferedReader(fr);
        return buff.readLine() ==null;
    }
    
}