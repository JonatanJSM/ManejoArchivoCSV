package archivo;

import java.io.IOException;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws IOException {
       // Sistema sistemaUno = new Sistema("C:\\Users\\Jonatan\\Documents\\UADY 2022_JonatanSantana\\Nueva carpeta","archivo.txt");
      //  Sistema sistemaUno = new Sistema("C:\\Users\\Jonatan\\Documents\\UADY 2022_JonatanSantana\\Nueva carpeta\\archivo","archivomodificado.txt");
             String secretKey = "SomosProgramadores";
      administadorUsuario mMain = new administadorUsuario();
         String cadenaAEncriptar = "Jonatan";
         String cadenaEncriptada = mMain.ecode(secretKey, cadenaAEncriptar);
         System.out.print(cadenaEncriptada);
    }
}
