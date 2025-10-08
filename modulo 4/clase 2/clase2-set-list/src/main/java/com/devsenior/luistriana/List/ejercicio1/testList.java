package com.devsenior.luistriana.List.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class testList {
 public static void main(String[] args) {
        int cantidadDatos = 200_000;

        // --- Prueba con ArrayList ---
        List<Integer> arrayList = new ArrayList<>();
        long inicioArrayList = System.nanoTime(); // Inicia el cronómetro

        for (int i = 0; i < cantidadDatos; i++) {
            arrayList.add(0, i); // Peor caso: Siempre insertamos en la primera posición
        }

        long finArrayList = System.nanoTime(); // Detiene el cronómetro
        double tiempoArrayList = (finArrayList - inicioArrayList) / 1_000_000_000.0; // Convierte a segundos

        System.out.println("--- ArrayList ---");
        System.out.printf("Tiempo para insertar %d elementos al INICIO: %.4f segundos.%n", cantidadDatos, tiempoArrayList);
        System.out.println("Fue lento porque en cada inserción tuvo que desplazar todos los elementos existentes.");

        System.out.println("\n---------------------------------------------\n");

        // --- Prueba con LinkedList ---
        List<Integer> linkedList = new LinkedList<>();
        long inicioLinkedList = System.nanoTime(); // Inicia el cronómetro

        for (int i = 0; i < cantidadDatos; i++) {
            linkedList.add(0, i); // Caso eficiente: Solo actualiza las conexiones del primer nodo.
        }

        long finLinkedList = System.nanoTime(); // Detiene el cronómetro
        double tiempoLinkedList = (finLinkedList - inicioLinkedList) / 1_000_000_000.0; // Convierte a segundos

        System.out.println("--- LinkedList ---");
        System.out.printf("Tiempo para insertar %d elementos al INICIO: %.4f segundos.%n", cantidadDatos, tiempoLinkedList);
        System.out.println("Fue extremadamente rápido porque solo reasigna las referencias del primer y nuevo elemento.");
    }
}
