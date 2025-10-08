package com.devsenior.luistriana;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.devsenior.luistriana.exceptions.AsientoInvalidoException;
import com.devsenior.luistriana.exceptions.AsientoLibreException;
import com.devsenior.luistriana.exceptions.AsientoOcupadoException;
import com.devsenior.luistriana.model.EstadoAsiento;
import com.devsenior.luistriana.service.Teatro;

 // Define el paquete donde se encuentra esta clase, separando la interfaz de usuario (ui) de la lógica de negocio.

/**
 * La clase Menu es la responsable de toda la interacción con el usuario.
 * Funciona como la "capa de presentación" de la aplicación.
 */
public class Menu {
    // Atributos privados de la clase.
    private Teatro teatro;      // Una instancia de la clase Teatro para acceder a la lógica del backend.
    private Scanner scanner;    // Una instancia de Scanner para leer lo que el usuario escribe.

    /**
     * Constructor de la clase Menu.
     * Se ejecuta al crear un nuevo objeto Menu.
     */
    public Menu() {
        // 1. Inicializa el objeto 'teatro', creando la sala con sus asientos.
        this.teatro = new Teatro();
        // 2. Inicializa el objeto 'scanner' para que esté listo para leer la entrada del usuario.
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método principal que controla el flujo de la aplicación.
     * Contiene el bucle que mantiene el programa corriendo hasta que el usuario decide salir.
     */
    public void ejecutar() {
        int opcion = 0; // Variable para almacenar la opción seleccionada por el usuario.

        // El bucle 'while' se repetirá mientras la opción sea diferente de 5 (la opción de salida).
        while (opcion != 5) {
            mostrarMenu(); // Llama al método que imprime las opciones en pantalla.
            
            // El bloque 'try-catch' maneja posibles errores, como que el usuario ingrese texto en lugar de un número.
            try {
                opcion = scanner.nextInt();   // Lee el número entero que el usuario introduce.
                scanner.nextLine();           // Limpia el buffer de entrada para evitar problemas con lecturas futuras.

                // 'switch' evalúa la opción elegida y ejecuta el caso correspondiente.
                switch (opcion) {
                    case 1:
                        mostrarMapaAsientos(); // Muestra el estado actual de todos los asientos.
                        break;
                    case 2:
                        gestionarReserva();    // Inicia el proceso para reservar un asiento.
                        break;
                    case 3:
                        gestionarCancelacion();// Inicia el proceso para cancelar una reserva.
                        break;
                    case 4:
                        mostrarEstadisticas(); // Muestra las estadísticas de ocupación.
                        break;
                    case 5:
                        System.out.println("Gracias por utilizar el sistema. ¡Hasta pronto!"); // Mensaje de despedida.
                        break;
                    default:
                        // Si el usuario introduce un número que no es una opción válida.
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                // Si el usuario introduce algo que no es un número (ej. "hola").
                System.out.println("Error: Debe ingresar un número.");
                scanner.nextLine(); // Es crucial limpiar el buffer después de un error.
                opcion = 0;         // Resetea la opción para que el bucle continúe.
            }
        }
        scanner.close(); // Cierra el scanner para liberar recursos cuando el programa termina.
    }

    /**
     * Simplemente imprime el menú de opciones en la consola.
     */
    private void mostrarMenu() {
        System.out.println("\n--- Sistema de Reservas de Teatro ---");
        System.out.println("1. Ver mapa de asientos");
        System.out.println("2. Reservar un asiento");
        System.out.println("3. Cancelar una reserva");
        System.out.println("4. Ver estadísticas de ocupación");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Dibuja una representación visual de la sala de teatro en la consola.
     */
    private void mostrarMapaAsientos() {
        System.out.println("\n--- Mapa de Asientos (L=Libre, X=Ocupado) ---");
        // 1. Pide al backend (Teatro) el estado actual de todos los asientos.
        EstadoAsiento[][] estado = teatro.obtenerEstadoAsientos();

        // 2. Imprime los números de las columnas para guiar al usuario.
        System.out.print("   ");
        for (int j = 0; j < estado[0].length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("---".repeat(estado[0].length + 1));

        // 3. Recorre la matriz fila por fila.
        for (int i = 0; i < estado.length; i++) {
            System.out.printf("%2d| ", i); // Imprime el número de la fila.
            // 4. Recorre cada asiento (columna) de la fila actual.
            for (int j = 0; j < estado[i].length; j++) {
                // Decide qué símbolo mostrar: 'L' para LIBRE, 'X' para OCUPADO.
                char simbolo = (estado[i][j] == EstadoAsiento.LIBRE) ? 'L' : 'X';
                System.out.print(simbolo + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila.
        }
    }

    /**
     * Gestiona el proceso de solicitar al usuario la fila y columna para una nueva reserva.
     */
    private void gestionarReserva() {
        try {
            // 1. Pide y lee el número de fila.
            System.out.print("Ingrese el número de fila para reservar: ");
            int fila = scanner.nextInt();
            // 2. Pide y lee el número de columna.
            System.out.print("Ingrese el número de columna para reservar: ");
            int columna = scanner.nextInt();

            // 3. Llama al método del backend para que intente realizar la reserva.
            teatro.reservarAsiento(fila, columna);
            System.out.println("¡Reserva realizada con éxito!");

        } catch (InputMismatchException e) {
            // Captura el error si el usuario no ingresa números.
            System.out.println("Error: Fila y columna deben ser números.");
            scanner.nextLine(); // Limpiar buffer.
        } catch (AsientoOcupadoException | AsientoInvalidoException e) {
            // Captura los errores de negocio que puede lanzar el backend (ej. asiento ya ocupado).
            System.out.println("Error al reservar: " + e.getMessage());
        }
    }

    /**
     * Gestiona el proceso de solicitar al usuario la fila y columna para cancelar una reserva.
     */
    private void gestionarCancelacion() {
        try {
            // 1. Pide y lee el número de fila.
            System.out.print("Ingrese el número de fila para cancelar: ");
            int fila = scanner.nextInt();
            // 2. Pide y lee el número de columna.
            System.out.print("Ingrese el número de columna para cancelar: ");
            int columna = scanner.nextInt();

            // 3. Llama al método del backend para que intente cancelar la reserva.
            teatro.cancelarReserva(fila, columna);
            System.out.println("¡Cancelación realizada con éxito!");

        } catch (InputMismatchException e) {
            // Captura el error si el usuario no ingresa números.
            System.out.println("Error: Fila y columna deben ser números.");
            scanner.nextLine(); // Limpiar buffer.
        } catch (AsientoLibreException | AsientoInvalidoException e) {
            // Captura los errores de negocio (ej. el asiento ya estaba libre).
            System.out.println("Error al cancelar: " + e.getMessage());
        }
    }

    /**
     * Pide las estadísticas al backend y las muestra en pantalla.
     */
    private void mostrarEstadisticas() {
        // 1. Llama al método del backend que calcula todo.
        String estadisticas = teatro.calcularEstadisticas();
        // 2. Imprime el resultado directamente en la consola.
        System.out.println(estadisticas);
    }
}
