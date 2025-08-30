package proyecto.estructuras;

import java.util.EmptyStackException;

/**
 * Implementación de una estructura de datos Pila (LIFO) usando nodos enlazados.
 * Una pila sigue el principio "último en entrar, primero en salir".
 * 
 * @param <T> el tipo de elementos que contendrá la pila
 */
public class Pila<T> {
    private Nodo<T> cima;

    /**
     * Clase interna que representa un nodo de la pila.
     */
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        /**
         * Construye un nuevo nodo con el dato especificado.
         */
        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    /**
     * Construye una pila vacía.
     */
    public Pila() {
        cima = null;
    }

    /**
     * Agrega un elemento a la cima de la pila.
     */
    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    /**
     * Remueve y retorna el elemento de la cima de la pila.
     * @throws EmptyStackException si la pila está vacía
     */
    public T pop() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    /**
     * Retorna el elemento de la cima de la pila sin removerlo.
     * @throws EmptyStackException si la pila está vacía
     */
    public T peek() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return cima.dato;
    }

    /**
     * Verifica si la pila está vacía.
     */
    public boolean estaVacia() {
        return cima == null;
    }

    /**
     * Muestra todos los elementos de la pila con un encabezado descriptivo.
     */
    public void mostrar() {
        Nodo<T> actual = cima;
        System.out.println("Contenido de la pila:");
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
    }

    /**
     * Muestra todos los elementos de la pila sin encabezado adicional.
     */
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