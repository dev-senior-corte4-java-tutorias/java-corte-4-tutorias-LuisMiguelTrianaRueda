package com.devsenior.luistriana.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.UUID;

import com.devsenior.luistriana.model.Canciones;
import com.devsenior.luistriana.model.Playlists;
import com.devsenior.luistriana.model.Usuarios;

public class bibliotecaMusical {

    private Map<String, Canciones> catalogoDeCanciones;

    private Map<String, Usuarios> registoUsuarios;

    private Map<String, Canciones> historialDeReproduccion;

    public bibliotecaMusical() {
        catalogoDeCanciones = new HashMap<>();
        registoUsuarios = new HashMap<>();
        // garantiza el orden de inserccion
        historialDeReproduccion = new LinkedHashMap<>();
    }

    // metodos crud para las canciones

    public void agregarCanciones(Canciones cancion) {
        if (catalogoDeCanciones.containsKey(cancion.getId())) {
            System.out.println(" la cancion ya existe ");
        } else {
            catalogoDeCanciones.put(cancion.getId(), cancion);
        }
    }

    // metodo para eliminar cancion

    public void eliminarCancion(String id) {
        if (catalogoDeCanciones.containsKey(id)) {
            catalogoDeCanciones.remove(id);
            System.out.println(" cancion eliminada con exito");
        }

        else {

            System.out.println(" la cancion no se encontro en la lista ");
        }
    }

    public Optional<Canciones> buscarCancion(String id) {
        if (catalogoDeCanciones.containsKey(id)) {
            Canciones cancionEncontrada = catalogoDeCanciones.get(id);
            return Optional.of(cancionEncontrada);
        }

        else {

            System.out.println(" la cancion no existe ");
            return Optional.empty();
        }
    }

    public void actualizarCancion(Canciones cancioneActualizar) {
        String id = cancioneActualizar.getId();

        if (catalogoDeCanciones.containsKey(id)) {
            catalogoDeCanciones.put(id, cancioneActualizar);
            System.out.println(" cancion con el id" + id + " actualizada correctamente");
        }

        else {
            System.out.println(" no se pudo actualizar la cancion ");
        }
    }

    // metodos crud para los usuarios.

    public void crearUsuario(Usuarios usuario) {
        if (registoUsuarios.containsKey(usuario.getUsername())) {
            System.out.println(" el usuario ya existe en la app ");
        }

        else {
            registoUsuarios.put(usuario.getUsername(), usuario);
            System.out.println(" el usuario ha sido creado correctamente ");
        }
    }

    public Optional<Usuarios> buscarUsuario(String username) {
        if (registoUsuarios.containsKey(username)) {
            Usuarios usuarioEncontrado = registoUsuarios.get(username);
            return Optional.of(usuarioEncontrado);
        } else {
            return Optional.empty();
        }
    }

    // eliminar usuario

    public void eliminarUsuario(String username) {
        if (registoUsuarios.containsKey(username)) {
            registoUsuarios.remove(username);
            System.out.println(" el usuario ha sido eliminado");
        } else {
            System.out.println(" el usuario no se encontro en la app ");
        }
    }
    // actualizar Usuario

    public void actualizarUsuario(Usuarios usuarionuevo) {
        String username = usuarionuevo.getUsername();

        if (registoUsuarios.containsKey(username)) {
            System.out.println(" usuario actualizado ");
        }

        else {
            System.out.println(" no se pudo actualizar el usuario ");
        }
    }

    // metodos en donde las entidades interactuan entre si

    // crear una playlists

    public void crearPlaylistsParaUsuario(String username, String nombrePlaylist) {
        if (registoUsuarios.containsKey(username)) {
            Usuarios usuarioEncontrado = registoUsuarios.get(username);

            String nuevaPlaylistsID = UUID.randomUUID().toString();

            Playlists nuevPlaylists = new Playlists(nuevaPlaylistsID, nombrePlaylist, new ArrayList<>());

            usuarioEncontrado.getMisPlaylists().put(nuevaPlaylistsID, nuevPlaylists);

            System.out.println(" playlists " + nombrePlaylist + " creada con exito ");
        }

        else {
            System.out.println(" no se pudo crear la playlists por que el usuairo no existe");
        }
    }

    // agregar una cancion a la playlists

    public void agregarCancionesAPlaylist(String username, String PlaylistsID, String idCancion) {

        if (registoUsuarios.containsKey(username)) {
            Usuarios usuario = registoUsuarios.get(username);

            Map<String, Playlists> playlistisDelUsuario = usuario.getMisPlaylists();

            Playlists playlists = playlistisDelUsuario.get(PlaylistsID);

            if (playlists == null) {
                System.out.println(" esta playlists con este id " + PlaylistsID + " no fue encontrada");
                return;
            }

            if (!catalogoDeCanciones.containsKey(idCancion)) {
                System.out.println(" esta cancion no existe en el catalogo general ");
                return;
            }

            // agregar cancion a la lista de la playlists

            playlists.getId_canciones().add(idCancion);
            System.out.println(" la cancion con el id " + idCancion
                    + " fue agregada con exito a la playlist con el nombre de " + playlists.getNombre());

        }

        else {

            System.out.println(" el usuario no fue encontrado ");
        }

    }

    public Playlists obtenerTodaPlaylist(String username, String PlaylistsId) {

        Optional<Usuarios> usuarioOptional = this.buscarUsuario(username);

        // verificar si el usuario fue encontrado

        if (usuarioOptional.isPresent()) {
            Usuarios usuario = usuarioOptional.get();

            Playlists playlist = usuario.getMisPlaylists().get(PlaylistsId);

            return playlist;

        } else {

            System.out.println(" usuario " + username + "no encontrado");

            return null;
        }
    }

    public void eliminarCancionPlaylist(String username, String PlaylistsID, String idcancion) {

        Optional<Usuarios> usuarOptional = this.buscarUsuario(username);

        if (usuarOptional.isPresent()) {
            Usuarios usuario = usuarOptional.get();

            Playlists playlists = usuario.getMisPlaylists().get(PlaylistsID);

            if (playlists != null) {

                boolean eliminada = playlists.getId_canciones().remove(idcancion);

                if (eliminada) {
                    System.out.println(" cancion elimnada de la playlists");
                } else {
                    System.out.println(" la cancion no estaba en la playlists");
                }

            }

            else {

                System.out.println(" la playlists no fue encontrada para este usuario");
            }

        }

        else {
            System.out.println(" el usuario no fue encontrado");
        }

    }

    public void reproducirCancion(String id) {
        Optional<Canciones> cancionOptional = this.buscarCancion(id);

        cancionOptional.ifPresent(cancion -> {
            System.out.println(" la cancion con el titulo " + cancion.getNombre() + " - " + cancion.getArtista()
                    + " se esta reproduciendo ");

            historialDeReproduccion.put(cancion.getId(), cancion);
        });

    }

    //         clave    valores 
    //     dato de retorno 
    public Map<String, List<Canciones>> obtenerCancionesOrdenadasPorTitulo() {
       
        


        TreeMap<String, List<Canciones>> cancionesPortitulo = new TreeMap<>();

        for (Canciones cancion : catalogoDeCanciones.values()) {
            String titulo = cancion.getNombre();

            cancionesPortitulo.putIfAbsent(titulo, new ArrayList<>());

            cancionesPortitulo.get(titulo).add(cancion);

        }

        return cancionesPortitulo;

    }

}
