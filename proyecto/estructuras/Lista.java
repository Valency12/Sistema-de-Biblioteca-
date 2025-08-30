package proyecto.estructuras;

/**
 * Implementación de una lista simplemente enlazada para almacenar elementos.
 * Una lista permite almacenar y gestionar una colección de elementos de manera secuencial.
 * 
 * @param <T> el tipo de elementos que contendrá la lista
 */
public class Lista<T> {
    public Nodo<T> cabeza;

    /**
     * Clase que representa un nodo de la lista enlazada.
     */
    public static class Nodo<T> {
        public T dato;
        public Nodo<T> siguiente;

        /**
         * Crea un nuevo nodo con el dato especificado.
         */
        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    /**
     * Construye una lista vacía.
     */
    public Lista() {
        cabeza = null;
    }

    /**
     * Obtiene el primer nodo de la lista.
     */
    public Nodo<T> getCabeza() {
        return cabeza;
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     */
    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado de la lista.
     * @return true si el elemento fue encontrado y eliminado, false en caso contrario
     */
    public boolean eliminar(T dato) {
        if (cabeza == null) return false;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            return true;
        }
        return false;
    }

    /**
     * Busca un elemento en la lista.
     * @return true si el elemento está en la lista, false en caso contrario
     */
    public boolean buscar(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Muestra todos los elementos de la lista.
     */
    public void mostrar() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
    }

    /**
     * Muestra el contenido de la lista sin formato adicional.
     * Incluye mensaje de vacío si la lista no contiene elementos.
     */
    public void mostrarContenido() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
        if (cabeza == null) {
            System.out.println("(Vacío)");
        }
    }
}