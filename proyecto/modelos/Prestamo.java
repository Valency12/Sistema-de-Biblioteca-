package proyecto.modelos;

/**
 * Clase que representa una solicitud de préstamo en el sistema de biblioteca.
 * Relaciona un usuario con el libro que desea solicitar.
 */
public class Prestamo {
    private Usuario usuario;
    private Libro libro;

    /**
     * Crea una nueva instancia de Préstamo con el usuario y libro especificados.
     */
    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
    }

    /**
     * Obtiene el usuario que solicita el préstamo.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Obtiene el libro solicitado en el préstamo.
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Retorna una representación en String del préstamo.
     * Formato: Usuario solicitó Libro
     */
    @Override
    public String toString() {
        return usuario + " solicitó " + libro;
    }
}