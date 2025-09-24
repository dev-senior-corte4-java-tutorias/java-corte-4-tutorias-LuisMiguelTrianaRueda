package com.devsenior.luistriana.ejerciciosbasicos;

import java.util.LinkedHashSet;
import java.util.Set;

public class linkedHashSet {
 public static void main(String[] args) {
        // 1. Creación: Se inicia el seguimiento del tutorial.
        Set<String> pasosCompletados = new LinkedHashSet<>();

        // 2. Adición en orden: El usuario completa los primeros pasos.
        pasosCompletados.add("1. Crear Perfil");
        pasosCompletados.add("2. Subir Foto");
        System.out.println("Progreso actual: " + pasosCompletados);
        
        // 3. Intento de duplicado: El usuario repite un paso.
        // LinkedHashSet lo ignora y, crucialmente, MANTIENE el orden original.
        pasosCompletados.add("1. Crear Perfil");
        System.out.println("Progreso sin cambios: " + pasosCompletados);
        
        // 4. Verificación: El sistema confirma que un paso clave se hizo.
        if (pasosCompletados.contains("2. Subir Foto")) {
            System.out.println("¡Bien hecho! Ya tienes una foto de perfil.");
        }
        
        // 5. Iteración ordenada: Se muestra el resumen al usuario.
        // La principal ventaja es que el orden está garantizado.
        System.out.println("\n--- Resumen de tu Progreso ---");
        for (String paso : pasosCompletados) {
            System.out.println("✅ " + paso);
        }
    }
}
