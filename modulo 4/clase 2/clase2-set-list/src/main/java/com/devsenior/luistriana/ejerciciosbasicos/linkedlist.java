package com.devsenior.luistriana.ejerciciosbasicos;

import java.util.LinkedList;

public class linkedlist {
  public static void main(String[] args) {
        // 1. Creación: Se inicia la línea de producción del horno.
        LinkedList<String> lineaHorno = new LinkedList<>();

        // 2. Añadir al final: Llegan las masas del día.
        lineaHorno.addLast("Masa de Trigo");
        lineaHorno.addLast("Masa Multigrano");
        System.out.println("Línea actual: " + lineaHorno);

        // 3. Añadir al principio: Llega un pedido urgente.
        lineaHorno.addFirst("Masa de Centeno (URGENTE)");
        System.out.println("Línea con urgencia: " + lineaHorno);

        // 4. Consultar sin remover: El jefe revisa los extremos.
        System.out.println("Próxima en hornear: " + lineaHorno.peekFirst());
        System.out.println("Última en la cola: " + lineaHorno.peekLast());

        // 5. Remover del principio: Un horno se libera y toma la primera masa.
        String masaParaHornear = lineaHorno.removeFirst();
        System.out.println("Entra al horno: '" + masaParaHornear + "'");
        System.out.println("Línea después de hornear: " + lineaHorno);

        // 6. Remover un elemento específico: Se detecta una masa quemada.
        lineaHorno.addLast("Masa Quemada"); // Simulación
        System.out.println("Línea con problema: " + lineaHorno);
        lineaHorno.remove("Masa Quemada");
        System.out.println("Línea después de retirar problema: " + lineaHorno);
    }
}
