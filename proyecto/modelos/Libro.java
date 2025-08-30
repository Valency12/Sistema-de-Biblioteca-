package proyecto.modelos;

import java.util.Objects;

/**
 * Clase que representa un libro en el sistema de biblioteca.
 * Contiene información sobre el título, autor y categoría de un libro.
 */
public class Libro {
    private String titulo;
    private String autor;
    private String categoria;

    /**
     * Crea una nueva instancia de Libro con los datos especificados.
     */
    public Libro(String titulo, String autor, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    /**
     * Obtiene el título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene la categoría del libro.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Retorna una representación en String del libro.
     * Formato: "Título" de Autor [Categoría]
     */
    @Override
    public String toString() {
        return "\"" + titulo + "\" de " + autor + " [" + categoria + "]";
    }

    /**
     * Compara este libro con otro objeto para determinar igualdad.
     * Dos libros se consideran iguales si tienen el mismo título (ignorando mayúsculas/minúsculas).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // mismo objeto
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo.toLowerCase(), libro.titulo.toLowerCase());
    }

    /**
     * Retorna el código hash del libro basado en su título.
     */
    @Override
    public int hashCode() {
        return Objects.hash(titulo.toLowerCase());
    }
}