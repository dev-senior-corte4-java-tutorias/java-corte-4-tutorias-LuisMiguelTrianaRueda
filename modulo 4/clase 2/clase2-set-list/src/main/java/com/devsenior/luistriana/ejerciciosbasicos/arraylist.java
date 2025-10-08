package com.devsenior.luistriana.ejerciciosbasicos;

import java.util.ArrayList;
import java.util.List;

public class arraylist {
 public static void main(String[] args) {
        // 1. Creación: Ana inicia su lista de tareas.
        List<String> tareas = new ArrayList<>();
        System.out.println("¿La lista está vacía al inicio? " + tareas.isEmpty());

        // 2. Añadir: Agrega sus pendientes.
        tareas.add("Planificar reunión"); // Posición 0
        tareas.add("Revisar reporte");    // Posición 1
        tareas.add("Enviar correos");     // Posición 2
        System.out.println("Tareas iniciales: " + tareas);

        // 3. Tamaño y Acceso: Revisa cuántas tareas tiene y cuál es la segunda.
        System.out.println("Número de tareas: " + tareas.size());
        System.out.println("La segunda tarea es: " + tareas.get(1));

        // 4. Actualizar: Cambia la prioridad de la primera tarea.
        tareas.set(0, "¡URGENTE! Planificar reunión con cliente");
        System.out.println("Lista actualizada: " + tareas);

        // 5. Verificar: Confirma si una tarea existe.
        System.out.println("¿Necesito 'Enviar correos'? " + tareas.contains("Enviar correos"));
        
        // 6. Eliminar: Completa la tarea actualizada y la quita de la lista.
        String tareaCompleta = tareas.remove(0);
        System.out.println("Tarea completada y eliminada: '" + tareaCompleta + "'");

        // 7. Iterar: Revisa las tareas pendientes al final del día.
        System.out.println("\n--- Tareas restantes ---");
        for (String tarea : tareas) {
            System.out.println("- " + tarea);
        }
    }
}
