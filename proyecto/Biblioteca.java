package proyecto;

import proyecto.estructuras.Pila;
import proyecto.estructuras.Cola;
import proyecto.estructuras.Lista;
import proyecto.modelos.Libro;
import proyecto.modelos.Prestamo;
import proyecto.modelos.Usuario;

/**
 * Clase principal que representa el sistema de gestión de una biblioteca.
 * Utiliza tres estructuras de datos fundamentales para administrar:
 * - Lista: Catálogo de libros disponibles
 * - Cola: Solicitudes de préstamo en orden FIFO
 * - Pila: Devoluciones urgentes en orden LIFO
 */
public class Biblioteca {

    private Pila<Libro> devolucionesUrgentes;
    private Cola<Prestamo> solicitudesPrestamo;
    private Lista<Libro> catalogoLibros;

    /**
     * Constructor que inicializa el sistema de biblioteca con datos predeterminados.
     * Crea las tres estructuras de datos y popula el sistema con:
     * - 5 libros en el catálogo
     * - 1 solicitud de préstamo en la cola
     * - 1 devolución urgente en la pila
     */
    public Biblioteca() {
        devolucionesUrgentes = new Pila<>();
        solicitudesPrestamo = new Cola<>();
        catalogoLibros = new Lista<>();
        
        // Agregar libros iniciales al catálogo
        agregarLibroInicial("Cien Anios de Soledad", "Gabriel García Marquez", "Romance");
        agregarLibroInicial("Cuentos de los hermanos grimm", "Hermanos Grimm", "terror");
        agregarLibroInicial("Viaje al centro de la Luna", "Julio Verne", "Ciencia Ficcion");
        agregarLibroInicial("Cuentos de Barro", "Salarrue", "Realismo");
        agregarLibroInicial("Viaje al centro de la Tierra", "Julio Verne", "Ciencia Ficcion");
        
        // Agregar solicitud de préstamo inicial
        Libro libroBarro = buscarLibroPorTitulo("Cuentos de Barro");
        if (libroBarro != null) {
            Usuario usuario = new Usuario("Hashim Madrid", "Cuentos de Barro");
            Prestamo prestamo = new Prestamo(usuario, libroBarro);
            solicitudesPrestamo.enqueue(prestamo);
        }
        
        // Agregar devolución urgente inicial
        Libro libroTierra = buscarLibroPorTitulo("Viaje al centro de la Tierra");
        if (libroTierra != null) {
            devolucionesUrgentes.push(libroTierra);
        }
    }
    
    /**
     * Método privado para agregar libros al catálogo durante la inicialización.
     */
    private void agregarLibroInicial(String titulo, String autor, String categoria) {
        Libro libro = new Libro(titulo, autor, categoria);
        catalogoLibros.insertar(libro);
    }

    /**
     * Agrega un nuevo libro al catálogo de la biblioteca.
     * El libro se inserta en la lista del catálogo y se muestra un mensaje de confirmación.
     */
    public void agregarLibro(String titulo, String autor, String categoria) {
        Libro libro = new Libro(titulo, autor, categoria);
        catalogoLibros.insertar(libro);
        System.out.println("✅ Libro agregado al catálogo: " + libro);
    }

    /**
     * Muestra por consola todo el catálogo de libros disponibles.
     * Utiliza el método mostrar() de la lista para imprimir todos los elementos.
     */
    public void verCatalogo() {
        catalogoLibros.mostrar();
    }

    /**
     * Registra una nueva solicitud de préstamo de libro.
     * Busca el libro en el catálogo y si existe, crea una solicitud que se encola
     * para su posterior atención en orden FIFO.
     */
    public void registrarPrestamo(String nombreUsuario, String tituloLibro) {
        // Buscar el libro real en el catálogo
        Libro libroEncontrado = buscarLibroPorTitulo(tituloLibro);
        if (libroEncontrado != null) {
            Usuario usuario = new Usuario(nombreUsuario, tituloLibro);
            Prestamo prestamo = new Prestamo(usuario, libroEncontrado);
            solicitudesPrestamo.enqueue(prestamo);
            System.out.println("📚 Solicitud registrada: " + prestamo);
        } else {
            System.out.println("❌ El libro \"" + tituloLibro + "\" no se encuentra en el catálogo.");
        }
    }

    /**
     * Busca un libro en el catálogo por su título (case-insensitive).
     * Realiza una búsqueda lineal recorriendo todos los nodos de la lista.
     * Complejidad: O(n) donde n es el número de libros en el catálogo.
     */
    private Libro buscarLibroPorTitulo(String titulo) {
        // Implementar búsqueda manual en la lista
        proyecto.estructuras.Lista.Nodo<Libro> actual = catalogoLibros.getCabeza();
        while (actual != null) {
            if (actual.dato.getTitulo().equalsIgnoreCase(titulo)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    /**
     * Atiende la siguiente solicitud de préstamo en la cola.
     * Remueve la solicitud más antigua (FIFO) y muestra información del préstamo atendido.
     * Si no hay solicitudes pendientes, muestra un mensaje informativo.
     */
    public void atenderPrestamo() {
        if (solicitudesPrestamo.estaVacia()) {
            System.out.println("No hay solicitudes de préstamo pendientes.");
        } else {
            Prestamo prestamo = solicitudesPrestamo.dequeue();
            System.out.println("✅ Atendiendo préstamo: " + prestamo);
        }
    }

    /**
     * Registra una devolución urgente de libro.
     * Busca el libro en el catálogo para obtener sus datos completos y lo apila
     * para procesamiento inmediato (LIFO). Si no encuentra el libro, usa valores por defecto.
     */
    public void registrarDevolucion(String tituloLibro) {
        // Buscar el libro real en el catálogo para obtener autor y categoría
        Libro libroEncontrado = buscarLibroPorTitulo(tituloLibro);
        if (libroEncontrado != null) {
            devolucionesUrgentes.push(libroEncontrado);
            System.out.println("⚠️ Devolución urgente registrada: " + libroEncontrado);
        } else {
            // Si no se encuentra, usar valores por defecto
            Libro libro = new Libro(tituloLibro, "Autor desconocido", "Desconocida");
            devolucionesUrgentes.push(libro);
            System.out.println("⚠️ Devolución urgente registrada: " + libro);
        }
    }

    /**
     * Procesa la última devolución urgente registrada.
     * Remueve el libro de la cima de la pila (LIFO) y muestra información del procesamiento.
     * Si no hay devoluciones pendientes, muestra un mensaje informativo.
     */
    public void procesarDevolucion() {
        if (devolucionesUrgentes.estaVacia()) {
            System.out.println("No hay devoluciones urgentes pendientes.");
        } else {
            Libro libro = devolucionesUrgentes.pop();
            System.out.println("✅ Procesada devolución urgente: " + libro);
        }
    }

    /**
     * Muestra un reporte completo de todas las tareas pendientes en el sistema.
     * Incluye:
     * - Catálogo completo de libros
     * - Solicitudes de préstamo pendientes
     * - Devoluciones urgentes por procesar
     */
    public void verTodasLasTareas() {
        System.out.println("\n===== TAREAS PENDIENTES =====");
        System.out.println("\n-- Catálogo --");
        System.out.println("Contenido de la lista:");
        catalogoLibros.mostrarContenido();

        System.out.println("\n-- Solicitudes de préstamo --");
        System.out.println("Contenido de la cola:");
        solicitudesPrestamo.mostrarContenido();

        System.out.println("\n-- Devoluciones urgentes --");
        System.out.println("Contenido de la pila:");
        devolucionesUrgentes.mostrarContenido();
    }
}