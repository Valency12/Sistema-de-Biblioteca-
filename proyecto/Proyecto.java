package proyecto;

import java.util.Scanner;

public class Proyecto {

    private Biblioteca biblioteca;
    private Scanner scanner;

    public Proyecto () {
        this.biblioteca = new Biblioteca();
        this.scanner = new Scanner(System.in);
    }

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

    private void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la categoría del libro: ");
        String categoria = scanner.nextLine();

        biblioteca.agregarLibro(titulo, autor, categoria);
    }

    private void registrarPrestamo() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el título del libro a prestar: ");
        String libro = scanner.nextLine();

        biblioteca.registrarPrestamo(nombre, libro);
    }

    private void registrarDevolucionUrgente() {
        System.out.print("Ingrese el título del libro devuelto: ");
        String libro = scanner.nextLine();

        biblioteca.registrarDevolucion(libro);
    }
    
     // Método main para ejecutar el sistema
    public static void main(String[] args) {
        Proyecto app = new Proyecto();
        app.mostrarMenu();
    }
}