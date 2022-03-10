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

        public boolean verificarEstructuraArchivo(int elementos, String seperadorString,String ruta, String nombre) throws IOException, Exception{
        FileReader fr;
        ruta += "\\"+nombre;
        String aux;
        boolean archivoExitente = true;
        int i = 0; int j = 0;
        try{
            fr = new FileReader(ruta);
            String linea;
            BufferedReader buff = new BufferedReader(fr);
                while((linea = buff.readLine()) != null){
                    String[] datoslinea = linea.split(seperadorString);
                    while(i<datoslinea.length){
                        aux = datoslinea[i];
                        if(!aux.equals("")){
                            j++;
                        }
                        i++;
                    }
                    if(j != elementos){              
                        throw new Exception("mal");
                    }
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