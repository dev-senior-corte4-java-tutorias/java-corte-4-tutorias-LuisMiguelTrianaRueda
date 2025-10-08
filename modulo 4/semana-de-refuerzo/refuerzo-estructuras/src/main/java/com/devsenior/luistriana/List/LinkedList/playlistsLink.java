package com.devsenior.luistriana.List.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class playlistsLink {
    List<String> canciones;

    public playlistsLink() {
        this.canciones = new LinkedList<>();
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

    public void añadirAlPrincipio() {
        canciones.addFirst("cancion 0 ");
    }

    public void añadirAlFinal() {
        canciones.addLast("cancion N");
    }

}
