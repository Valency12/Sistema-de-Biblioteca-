package proyecto.estructuras;

public class Lista<T> {
    public Nodo<T> cabeza;

    public static class Nodo<T> {
        public T dato;
        public Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public Lista() {
        cabeza = null;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    // INSERTAR al final
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

    // ELIMINAR un elemento
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

    // BUSCAR un elemento
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

    // MOSTRAR lista completa
    public void mostrar() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
    }

    // Nuevo método para mostrar contenido sin el encabezado
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