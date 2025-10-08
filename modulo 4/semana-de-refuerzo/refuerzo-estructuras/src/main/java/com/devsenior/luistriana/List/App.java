package com.devsenior.luistriana.List;

import com.devsenior.luistriana.List.ArrayList.playlists;
import com.devsenior.luistriana.List.LinkedList.playlistsLink;

public class App {
    public static void main(String[] args) {
        playlists lista = new playlists();

        System.out.println(" lista de canciones con Arraylist");
        lista.agregarCanciones();

        System.out.println(" las canciones a mostrar son ");
        lista.mostrarCanciones();

        System.out.println(" se elimina la cancion con el indice cero (osea la 1 )");
        lista.deleteCancion();

        System.out.println(" LINKED LIST");
        playlistsLink listaLink = new playlistsLink();


        System.out.println(" cancion añadida al principio ");
        listaLink.añadirAlPrincipio();

        System.out.println(" cancion añadir al final ");
        listaLink.añadirAlFinal();


        System.out.println(" MOSTRAR TODAS LAS CANCIONES ");
        listaLink.mostrarCanciones();
        
    }
}
