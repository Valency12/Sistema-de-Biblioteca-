package proyecto;

import java.util.Scanner;

/**
 * Clase principal que actúa como punto de entrada y controlador del sistema de biblioteca.
 * Implementa la interfaz de usuario en consola y coordina las operaciones del sistema.
 * Sigue el patrón MVC (Modelo-Vista-Controlador) donde:
 * - Modelo: {@link Biblioteca}
 * - Vista: Interfaz de consola
 * - Controlador: Esta clase
 */
public class Proyecto {

    private Biblioteca biblioteca;
    private Scanner scanner;

    /**
     * Constructor que inicializa el sistema de biblioteca.
     * Crea una nueva instancia de {@link Biblioteca} y prepara el scanner para entrada de usuario.
     * El sistema se inicia con datos predeterminados definidos en el constructor de Biblioteca.
     */
    public Proyecto() {
        this.biblioteca = new Biblioteca();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal del sistema y gestiona la interacción con el usuario.
     * Presenta un menú interactivo con 7 opciones y procesa la selección del usuario
     * en un bucle hasta que se elige la opción de salir (0).
     * 
     * El método utiliza un patrón do-while para garantizar que el menú se muestre
     * al menos una vez y continúe mostrándose hasta que el usuario decida salir.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1. Agregar libro al catálogo");
            System.out.println("2. Ver catálogo de libros");
            System.out.println("3. Registrar solicitud de préstamo");
            System.out.println("4. Atender préstamo");
            System.out.println("5. Registrar devolución urgente");
            System.out.println("6. Procesar devolución urgente");
            System.out.println("7. Ver todas las tareas pendientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    biblioteca.verCatalogo();
                    break;
                case 3:
                    registrarPrestamo();
                    break;
                case 4:
                    biblioteca.atenderPrestamo();
                    break;
                case 5:
                    registrarDevolucionUrgente();
                    break;
                case 6:
                    biblioteca.procesarDevolucion();
                    break;
                case 7:
                    biblioteca.verTodasLasTareas();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    /**
     * Maneja la interacción para agregar un nuevo libro al catálogo.
     * Solicita al usuario el título, autor y categoría del libro, luego delega
     */
    private void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la categoría del libro: ");
        String categoria = scanner.nextLine();

        biblioteca.agregarLibro(titulo, autor, categoria);
    }

    /**
     * Maneja la interacción para registrar una nueva solicitud de préstamo.
     * Solicita al usuario el nombre del solicitante y el título del libro,
     * luego delega la operación a la clase {@link Biblioteca}.
     */
    private void registrarPrestamo() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el título del libro a prestar: ");
        String libro = scanner.nextLine();

        biblioteca.registrarPrestamo(nombre, libro);
    }

    /**
     * Maneja la interacción para registrar una devolución urgente.
     * Solicita al usuario el título del libro devuelto y delega
     * la operación a la clase {@link Biblioteca}.
     */
    private void registrarDevolucionUrgente() {
        System.out.print("Ingrese el título del libro devuelto: ");
        String libro = scanner.nextLine();

        biblioteca.registrarDevolucion(libro);
    }
    
    /**
     * Punto de entrada principal del sistema de biblioteca.
     * Crea una instancia de la aplicación y inicia el menú principal.
     */
    public static void main(String[] args) {
        Proyecto app = new Proyecto();
        app.mostrarMenu();
    }
}