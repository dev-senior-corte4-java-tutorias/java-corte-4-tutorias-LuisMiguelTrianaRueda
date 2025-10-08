package com.devsenior.luistriana.ejerciciosbasicos.treeSet;

import java.util.Iterator;
import java.util.TreeSet;



public class ConcursoDeFotografia {
 public static void main(String[] args) {
        // 1. Creación: El TreeSet ordenará las fotos por puntuación automáticamente.
        TreeSet<Foto> concurso = new TreeSet<>();
        concurso.add(new Foto("Carla", 85));
        concurso.add(new Foto("Bruno", 92));
        concurso.add(new Foto("Ana", 68));
        concurso.add(new Foto("David", 98));

        System.out.println("Concursantes (ordenados por puntaje): " + concurso);
        
        // 2. Obtener extremos: Ver la mejor y peor foto al instante.
        System.out.println("Foto con menor puntaje: " + concurso.first());
        System.out.println("Foto con mayor puntaje: " + concurso.last());

        // 3. Crear subconjuntos: Filtrar finalistas y menciones.
        System.out.println("Finalistas (90 o más): " + concurso.tailSet(new Foto("", 90)));
        System.out.println("Menciones (menos de 70): " + concurso.headSet(new Foto("", 70)));
        
        // 4. Eliminar: Se descalifica a un participante.
        concurso.remove(new Foto("Carla", 85));

        // 5. Iterar en orden inverso: Anunciar ganadores de mayor a menor.
        System.out.println("\n---  GANADORES  ---");
        Iterator<Foto> iterador = concurso.descendingIterator();
        int puesto = 1;
        while (iterador.hasNext()) {
            System.out.println(puesto++ + "° lugar: " + iterador.next());
        }
    }
}
