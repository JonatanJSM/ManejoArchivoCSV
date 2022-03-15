package archivo;

/**
 *
 * @author Jonatan
 */
public class Usuario {
    private String nombre;
    private String contrasenia;
    
    public Usuario(String nombre, String contrasenia) {
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
    
}
