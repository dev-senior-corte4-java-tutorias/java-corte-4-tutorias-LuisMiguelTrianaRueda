package com.devsenior.luistriana.model;

public class Canciones {
    private double duracion;
    private String genero;
    private String nombre;
    private String artista;
    private String id;
    
    public Canciones(double duracion, String genero, String nombre, String artista, String id) {
        this.duracion = duracion;
        this.genero = genero;
        this.nombre = nombre;
        this.artista = artista;
        this.id = id;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Canciones [duracion=" + duracion + ", genero=" + genero + ", nombre=" + nombre + ", artista=" + artista
                + ", id=" + id + "]";
    }


    
}
