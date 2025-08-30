package proyecto.estructuras;

import java.util.EmptyStackException;

public class Pila<T> {
    private Nodo<T> cima;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public Pila() {
        cima = null;
    }

    // Operación PUSH
    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    // Operación POP
    public T pop() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    // Operación PEEK
    public T peek() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return cima.dato;
    }

    // Verificar si está vacía
    public boolean estaVacia() {
        return cima == null;
    }

    // Mostrar todos los elementos (para depuración)
    public void mostrar() {
        Nodo<T> actual = cima;
        System.out.println("Contenido de la pila:");
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
    }

    // Nuevo método para mostrar contenido sin el encabezado
    public void mostrarContenido() {
        Nodo<T> actual = cima;
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
        if (cima == null) {
            System.out.println("(Vacío)");
        }
    }
}