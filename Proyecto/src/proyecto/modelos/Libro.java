/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelos;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private String categoria;

    public Libro(String titulo, String autor, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "\"" + titulo + "\" de " + autor + " [" + categoria + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // mismo objeto
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo.toLowerCase(), libro.titulo.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo.toLowerCase());
    }
}

