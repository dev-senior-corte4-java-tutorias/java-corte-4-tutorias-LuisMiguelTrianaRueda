package com.devsenior.luistriana.Set;

import java.util.HashSet;
import java.util.Set;

public class registroEstudiantes {
    private Set<String> conjuntoDeEstudiantes;

    public registroEstudiantes() {
        conjuntoDeEstudiantes = new HashSet<>();
    }

    public void agregarEstudiantes() {
        conjuntoDeEstudiantes.add("juan manuel");
        conjuntoDeEstudiantes.add("jose ventura");
        conjuntoDeEstudiantes.add("edwin cante");
        conjuntoDeEstudiantes.add("santiago");
        conjuntoDeEstudiantes.add("santiago");
        conjuntoDeEstudiantes.add("victor david");

        for (String c : conjuntoDeEstudiantes) {
            System.out.println(c);
        }
    }

    public void eliminarEstudiante() {
        conjuntoDeEstudiantes.remove("juan manuel");
        conjuntoDeEstudiantes.remove("edwin cante");

        for (String cd : conjuntoDeEstudiantes) {
            System.out.println(cd);
        }
    }

    public void buscarEstudiante() {
        conjuntoDeEstudiantes.contains("victor david");
    }
}
