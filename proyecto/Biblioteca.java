package proyecto;

import proyecto.estructuras.Pila;
import proyecto.estructuras.Cola;
import proyecto.estructuras.Lista;
import proyecto.modelos.Libro;
import proyecto.modelos.Prestamo;
import proyecto.modelos.Usuario;

public class Biblioteca {

    private Pila<Libro> devolucionesUrgentes;
    private Cola<Prestamo> solicitudesPrestamo;
    private Lista<Libro> catalogoLibros;

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
    
    private void agregarLibroInicial(String titulo, String autor, String categoria) {
        Libro libro = new Libro(titulo, autor, categoria);
        catalogoLibros.insertar(libro);
    }

    public void agregarLibro(String titulo, String autor, String categoria) {
        Libro libro = new Libro(titulo, autor, categoria);
        catalogoLibros.insertar(libro);
        System.out.println("✅ Libro agregado al catálogo: " + libro);
    }

    public void verCatalogo() {
        catalogoLibros.mostrar();
    }

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

    public void atenderPrestamo() {
        if (solicitudesPrestamo.estaVacia()) {
            System.out.println("No hay solicitudes de préstamo pendientes.");
        } else {
            Prestamo prestamo = solicitudesPrestamo.dequeue();
            System.out.println("✅ Atendiendo préstamo: " + prestamo);
        }
    }

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

    public void procesarDevolucion() {
        if (devolucionesUrgentes.estaVacia()) {
            System.out.println("No hay devoluciones urgentes pendientes.");
        } else {
            Libro libro = devolucionesUrgentes.pop();
            System.out.println("✅ Procesada devolución urgente: " + libro);
        }
    }

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