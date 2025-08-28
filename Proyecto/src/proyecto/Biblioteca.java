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
    }

    public void agregarLibro(String titulo, String autor, String categoria) {
        Libro libro = new Libro(titulo, autor, categoria);
        catalogoLibros.insertar(libro);
        System.out.println("✅ Libro agregado al catálogo: " + libro);
    }

    public void verCatalogo() {
        catalogoLibros.mostrar();
    }

    public void registrarPrestamo(String nombreUsuario, String idUsuario, String tituloLibro) {
        Libro libro = new Libro(tituloLibro, "", ""); // se busca en catálogo
        if (catalogoLibros.buscar(libro)) {
            Usuario usuario = new Usuario(nombreUsuario, idUsuario);
            Prestamo prestamo = new Prestamo(usuario, libro);
            solicitudesPrestamo.enqueue(prestamo);
            System.out.println("📚 Solicitud registrada: " + prestamo);
        } else {
            System.out.println("❌ El libro \"" + tituloLibro + "\" no se encuentra en el catálogo.");
        }
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
        Libro libro = new Libro(tituloLibro, "Autor desconocido", "Desconocida");
        devolucionesUrgentes.push(libro);
        System.out.println("⚠️ Devolución urgente registrada: " + libro);
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
        System.out.println("\n--- Catálogo ---");
        catalogoLibros.mostrar();

        System.out.println("\n--- Solicitudes de préstamo ---");
        solicitudesPrestamo.mostrar();

        System.out.println("\n--- Devoluciones urgentes ---");
        devolucionesUrgentes.mostrar();
    }
}
