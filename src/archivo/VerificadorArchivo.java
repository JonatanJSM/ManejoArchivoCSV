package archivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class VerificadorArchivo{
    private ArrayList<String[]> lista = new ArrayList<>();

    public ArrayList<String[]> getLista() {
        return lista;
    }
    
    public void imprimri (){
        String aux[];
        aux = lista.get(0);
        System.out.println("probando"+aux[1]);
    }   
    
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
        String arregloaux[] = new String[elementos];
        boolean archivoExitente = true;
        try{
            fr = new FileReader(ruta);
            String linea;
            BufferedReader buff = new BufferedReader(fr);
                while((linea = buff.readLine()) != null){
                    String[] datoslinea = linea.split(seperadorString);
                    int i = 0; int j = 0;
                    while(i<datoslinea.length){
                        aux = datoslinea[i];
                        arregloaux[i] = datoslinea[i];
                        System.out.println("E "+i+arregloaux[i]);
                        if(!aux.equals("")){
                            j++;
                        }
                        i++;
                    }
                    lista.add(arregloaux);
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