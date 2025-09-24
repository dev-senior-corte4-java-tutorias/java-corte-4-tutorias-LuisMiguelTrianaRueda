package com.devsenior.luistriana.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class testSet {
 public static void main(String[] args) {
        int cantidadDatos = 5_000_000;

        // --- Prueba con HashSet ---
        Set<Integer> hashSet = new HashSet<>();
        long inicioHashSet = System.nanoTime();

        for (int i = 0; i < cantidadDatos; i++) {
            hashSet.add(i);
        }

        long finHashSet = System.nanoTime();
        double tiempoHashSet = (finHashSet - inicioHashSet) / 1_000_000_000.0;
        System.out.println("--- HashSet (el más rápido) ---");
        System.out.printf("Tiempo para insertar %d elementos: %.4f segundos.%n", cantidadDatos, tiempoHashSet);
        System.out.println("Solo calcula el hash y guarda. No le importa el orden.");

        System.out.println("\n---------------------------------------------\n");

        // --- Prueba con LinkedHashSet ---
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        long inicioLinked = System.nanoTime();

        for (int i = 0; i < cantidadDatos; i++) {
            linkedHashSet.add(i);
        }

        long finLinked = System.nanoTime();
        double tiempoLinked = (finLinked - inicioLinked) / 1_000_000_000.0;
        System.out.println("--- LinkedHashSet (un poco más lento) ---");
        System.out.printf("Tiempo para insertar %d elementos: %.4f segundos.%n", cantidadDatos, tiempoLinked);
        System.out.println("Calcula el hash y además mantiene punteros para recordar el orden de inserción.");

        System.out.println("\n---------------------------------------------\n");

        // --- Prueba con TreeSet ---
        Set<Integer> treeSet = new TreeSet<>();
        long inicioTreeSet = System.nanoTime();

        for (int i = 0; i < cantidadDatos; i++) {
            treeSet.add(i);
        }

        long finTreeSet = System.nanoTime();
        double tiempoTreeSet = (finTreeSet - inicioTreeSet) / 1_000_000_000.0;
        System.out.println("--- TreeSet (el más lento) ---");
        System.out.printf("Tiempo para insertar %d elementos: %.4f segundos.%n", cantidadDatos, tiempoTreeSet);
        System.out.println("En cada inserción, debe rebalancear el árbol para mantener todo ordenado. Es el que más trabaja.");
    }
}
