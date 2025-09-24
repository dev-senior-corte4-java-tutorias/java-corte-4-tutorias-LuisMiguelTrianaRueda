package com.devsenior.luistriana.ejerciciosbasicos.treeSet;

public class Foto implements Comparable<Foto> {

    String autor;
    int puntuacion;

    public Foto(String autor, int puntuacion) {
        this.autor = autor;
        this.puntuacion = puntuacion;
    }

    @Override
    public int compareTo(Foto otra) {
        return Integer.compare(this.puntuacion, otra.puntuacion);
    }

    @Override
    public String toString() {
        return "['" + autor + "' : " + puntuacion + "pts]";
    }
}