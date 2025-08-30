package proyecto.estructuras;

import java.util.NoSuchElementException;

/**
 * Implementación de una estructura de datos Cola (FIFO - First In, First Out) usando nodos enlazados.
 * Una cola es una colección de elementos que sigue el principio "primero en entrar, primero en salir".
 */
public class Cola<T> {
    private Nodo<T> frente, fin;

    /**
     * Clase interna que representa un nodo de la cola.
     * Cada nodo contiene un dato y una referencia al siguiente nodo en la cola.
     */
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        /**
         * Construye un nuevo nodo con el dato especificado.
         * El siguiente nodo se inicializa como null.
         */
        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    /**
     * Construye una cola vacía.
     * Inicializa tanto el frente como el fin de la cola como null.
     */
    public Cola() {
        frente = fin = null;
    }

    /**
     * Agrega un elemento al final de la cola (operación ENQUEUE).
     * Complejidad: O(1) - tiempo constante.
     */
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

    /**
     * Remueve y retorna el elemento al frente de la cola (operación DEQUEUE).
     * Complejidad: O(1) - tiempo constante.
     */
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

    /**
     * Retorna el elemento al frente de la cola sin removerlo (operación PEEK/FRONT).
     * Complejidad: O(1) - tiempo constante.
     */
    public T front() {
        if (estaVacia()) {
            throw new NoSuchElementException("Cola vacía");
        }
        return frente.dato;
    }

    /**
     * Verifica si la cola está vacía.
     * Complejidad: O(1) - tiempo constante.
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Muestra por consola todos los elementos de la cola con un encabezado descriptivo.
     * Los elementos se muestran en orden desde el frente hasta el fin de la cola.
     * Útil para depuración y visualización del contenido completo.
     */
    public void mostrar() {
        Nodo<T> actual = frente;
        System.out.println("Contenido de la cola:");
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
    }

    /**
     * Muestra por consola todos los elementos de la cola sin encabezado adicional.
     * Similar al método {@link #mostrar()} pero sin la línea "Contenido de la cola:".
     * Útil cuando el contexto de visualización ya proporciona el encabezado apropiado.
     */
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