package com.devsenior.luistriana;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.devsenior.luistriana.service.GestorTareasService;

public class GestorTareasTest {
    /*
     * instancia de nuestro service
     */
    private GestorTareasService gestor;

    /*
     * se ejecuta antes del todo
     */
    @BeforeAll

    static void setUpAll() {
        System.out.println(" conectando a la base de datos...");

    }

    /*
     * se ejecuta antes de cada prueba
     */
    @BeforeEach

    void setUp() {
        System.out.println(" -> inicializando un nuevo GestorTareasService");
        // creamos un objeto nuevo por cada prueba

        gestor = new GestorTareasService();

    }

    // mensaje de finalización DESPUES DE CADA prueba
    @AfterEach

    void tearDown() {
        System.out.println(" prueba finalizada ");
    }

    // Mision 2: desconectar de la BD (se ejecuta UNA sola vez despues de todo )

    @AfterAll
    static void tearDownAll() {
        System.out.println(" cerrando conexion con la base de datos");
    }

    /*
     * NARRATIVA NUMERO 2
     */
    @Test
    @DisplayName("deberia añadir una tarea correctamente a la lista")
    void deberiaAñadirTareaCorrectamente() {
        // PREPRAR LOS DATOS CON LOS QUE VAMOS A TRABAJAR
        GestorDeTareas nuevTarea = new GestorDeTareas(" aprender Junit ", " practicar con ejercicios", 1, false);
        // VAMOS A EJECUTAR UNA ACCION QUE SE QUIERE PROBAR
        gestor.addtarea(nuevTarea);

        /*
         * verificacion de la expcecion personalizada
         */

        // VERIFICAR
        assertEquals(1, gestor.getNumeroDeTareas(), "el numero de tareas deberia ser 1 despues de añadir una");
        assertFalse(gestor.getNumeroDeTareas() == 0, "la lista de tareas no deberia estar vacia");
    }

    @Test
    @DisplayName(" una tarea nueva no deberia estar completa por defecto ")

    void tareaNuevaNoDeberiaEstarCompletada() {
        GestorDeTareas nuevTarea = new GestorDeTareas("comprar pan", " ir a la panaderia ", 6, false);

        GestorDeTareas tareaAgregada = gestor.addtarea(nuevTarea);

        assertFalse(tareaAgregada.isCompletada(),
                "una tarea recien creada debe tener el estado 'completado' en false ");
    }

    @Test
    @DisplayName(" deberia eliminar todas las tareas de la lista")
    @Disabled(" funcionalidad de limpiarTareas aun en desarrollo")

    void deberiaLimpiarTodasLasTareas() {
        gestor.addtarea(new GestorDeTareas("tarea 1", "...", 0, false));
        gestor.addtarea(new GestorDeTareas(" tarea 2", "...", 0, false));

        gestor.limpiarTareas();

        assertEquals(0, gestor.getNumeroDeTareas());

    }

    @Test
    @DisplayName("deberia generar un reporte de productividad solo en el entorno de CI")
    void deberiaGenerarReporteEnCI() {
        Assumptions.assumeTrue("CI".equals(System.getProperty("ENV")),
                "prueba de reportes omitida: no se esta ejecutando en el entorno de CI");

        String reporte = gestor.generarReporte();
        assertFalse(reporte.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tarea 1", "Tarea 2", "Tarea 3"})
    @DisplayName("Debería añadir múltiples tareas correctamente")
    void deberiaAñadirMultiplesTareasCorrectamente(String tituloTarea) {
        // PREPARAR LOS DATOS
        GestorDeTareas nuevaTarea = new GestorDeTareas(tituloTarea, "Descripción de " + tituloTarea, 1, false);
        
        // EJECUTAR LA ACCIÓN
        gestor.addtarea(nuevaTarea);

        // VERIFICAR
        assertEquals(1, gestor.getNumeroDeTareas(), "El número de tareas debería ser 1 después de añadir una.");
    }

}
