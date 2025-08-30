package proyecto.estructuras;

import java.util.NoSuchElementException;

public class Cola<T> {
    private Nodo<T> frente, fin;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public Cola() {
        frente = fin = null;
    }

    // ENQUEUE
    public void enqueue(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (fin != null) {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        if (frente == null) {
            frente = fin;
        }
    }

    // DEQUEUE
    public T dequeue() {
        if (estaVacia()) {
            throw new NoSuchElementException("Cola vacía");
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return dato;
    }

    // FRONT
    public T front() {
        if (estaVacia()) {
            throw new NoSuchElementException("Cola vacía");
        }
        return frente.dato;
    }

    // Verificar si está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Mostrar elementos
    public void mostrar() {
        Nodo<T> actual = frente;
        System.out.println("Contenido de la cola:");
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
    }

    // Nuevo método para mostrar contenido sin el encabezado
    public void mostrarContenido() {
        Nodo<T> actual = frente;
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
        if (frente == null) {
            System.out.println("(Vacío)");
        }
    }
}