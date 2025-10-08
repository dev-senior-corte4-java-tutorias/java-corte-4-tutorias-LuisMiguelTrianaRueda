package com.devsenior.luistriana.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class playlists {
    List<String> canciones;

    public playlists() {
        this.canciones = new ArrayList<>();
    }

    public void agregarCanciones() {
        // el metodo add es para agregar y pertenece a la interfaz list que implementa
        // ArrayList
        canciones.add("cancion 1");
        canciones.add("cancion 2");
        canciones.add(" cancion 3 ");
        canciones.add(" cancion 4");
    }

    public void mostrarCanciones() {
        for (String c : canciones) {
            System.out.println(c);
        }
        
    }

    public void deleteCancion() {
        // remove elimna un objeto de la Arraylist segun su INDICE
        canciones.remove(0);
        for (String c : canciones) {
            System.out.println(c);
        }
    }

    public void tamañoLista() {
        // size nos trae el tamaño de la lista
        System.out.println(" el tamaño de la lista de canciones es " + canciones.size());
    }
}
