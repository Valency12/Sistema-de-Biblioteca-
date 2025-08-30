package proyecto.modelos;

/**
 * Clase que representa un usuario del sistema de biblioteca.
 * Contiene información básica de identificación del usuario.
 */
public class Usuario {
    private String nombre;
    private String id;

    /**
     * Crea una nueva instancia de Usuario con los datos especificados.
     */
    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el identificador del usuario.
     */
    public String getId() {
        return id;
    }

    /**
     * Retorna una representación en String del usuario.
     * Formato: Nombre (ID: identificador)
     */
    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}