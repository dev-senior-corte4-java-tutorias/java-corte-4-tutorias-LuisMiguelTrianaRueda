package com.devsenior.luistriana.ejerciciosbasicos;

import java.util.HashSet;
import java.util.Set;

public class hashset {
 public static void main(String[] args) {
        // 1. Creación y adición: Se carga la lista de invitados VIP.
        Set<String> invitadosVIP = new HashSet<>();
        invitadosVIP.add("ID-A45");
        invitadosVIP.add("ID-B91");
        invitadosVIP.add("ID-C38");

        // 2. Intento de duplicado: Se intenta agregar un ID repetido (será ignorado).
        boolean noSeAgrego = !invitadosVIP.add("ID-A45");
        System.out.println("¿Se ignoró el duplicado? " + noSeAgrego);
        System.out.println("Invitados registrados: " + invitadosVIP);

        // 3. Verificación rápida: Llega un invitado y se verifica su acceso.
        boolean tieneAcceso = invitadosVIP.contains("ID-B91");
        System.out.println("¿El invitado ID-B91 tiene acceso? " + tieneAcceso);
        
        // 4. Eliminación: Un invitado se retira.
        invitadosVIP.remove("ID-C38");
        System.out.println("¿Sigue el invitado ID-C38? " + invitadosVIP.contains("ID-C38"));

        // 5. Tamaño: El guardia revisa cuánta gente queda.
        System.out.println("Número actual de invitados VIP: " + invitadosVIP.size());

        // 6. Limpieza: El evento termina y se resetea la lista.
        invitadosVIP.clear();
        System.out.println("¿Quedan invitados para mañana? " + !invitadosVIP.isEmpty());
    }
}
