package com.devsenior.luistriana.model;

import java.util.List;

public class Playlists {
 private String id;
 private String nombre;
 private List<String> id_canciones;
 public String getId() {
    return id;
 }
 public void setId(String id) {
    this.id = id;
 }
 public String getNombre() {
    return nombre;
 }
 public void setNombre(String nombre) {
    this.nombre = nombre;
 }
 public List<String> getId_canciones() {
    return id_canciones;
 }
 public void setId_canciones(List<String> id_canciones) {
    this.id_canciones = id_canciones;
 }
 public Playlists(String id, String nombre, List<String> id_canciones) {
    this.id = id;
    this.nombre = nombre;
    this.id_canciones = id_canciones;
 }
 @Override
 public String toString() {
    return "Playlists [id=" + id + ", nombre=" + nombre + ", id_canciones=" + id_canciones + "]";
 }
 
 
}
