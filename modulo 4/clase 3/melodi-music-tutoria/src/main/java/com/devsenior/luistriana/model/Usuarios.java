package com.devsenior.luistriana.model;

import java.util.Map;

public class Usuarios {
     private String username;

     private Map<String, Playlists> misPlaylists;

     public Usuarios(String username, Map<String, Playlists> misPlaylists) {
        this.username = username;
        this.misPlaylists = misPlaylists;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public Map<String, Playlists> getMisPlaylists() {
         return misPlaylists;
     }

     public void setMisPlaylists(Map<String, Playlists> misPlaylists) {
         this.misPlaylists = misPlaylists;
     }

     @Override
     public String toString() {
        return "Usuarios [username=" + username + ", misPlaylists=" + misPlaylists + "]";
     }

     
}
