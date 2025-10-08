package com.devsenior.luistriana.maps;

import java.util.HashMap;
import java.util.Map;

public class directorioTelefonico {
    Map<String, Long> agendaDeContactos;

    public directorioTelefonico() {
        this.agendaDeContactos = new HashMap<>();
    }

    public void agregarContactos() {
        // registro uno
        agendaDeContactos.put("nombre1", 1234567899L);
        // registro dos
        agendaDeContactos.put("carolina", 3456789L);
        agendaDeContactos.put("jose ventura", 123456789L);
        agendaDeContactos.put("luis", 4567899L);

        for (Map.Entry<String, Long> par : agendaDeContactos.entrySet()) {
            String nombre = par.getKey();

            Long numero = par.getValue();

            System.out.println(" contacto " + nombre + " tiene el numero " + numero);
        }

    }

    public void buscarContacto(String name) {
        if (agendaDeContactos.containsKey("luis")) {

            System.out.println("el contacto si esta presente en la lista de contactos  ");
        }

        else {
            System.out.println(" el contacto no se encuentra presente en la agenda de contactos ");
        }
    }

    public void elimnarContacto(String name) {
        Long numeroEliminado = agendaDeContactos.remove(name);

        if (numeroEliminado != null) {
            System.out.println(" el contacto fue eliminado ");
        }

        else {
            System.out.println("no se pudo eliminar el contacto");
        }
    }

}
