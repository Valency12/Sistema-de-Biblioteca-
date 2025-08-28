
package proyecto.modelos;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    @Override
    public String toString() {
        return usuario + " solicitó " + libro;
    }
}