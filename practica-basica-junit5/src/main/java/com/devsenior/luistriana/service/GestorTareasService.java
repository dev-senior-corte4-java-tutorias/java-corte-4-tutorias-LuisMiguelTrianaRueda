package com.devsenior.luistriana.service;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.luistriana.GestorDeTareas;
import com.devsenior.luistriana.exceptions.tareaDuplicadaException;

public class GestorTareasService {
    private List< GestorDeTareas> tareas;

    public GestorTareasService() {   
        this.tareas = new ArrayList<>();
    }


     public void lista(){
        tareas.add( new GestorDeTareas("sacar al perro ", " sacar al perro al parque ", 3, false));
        tareas.add( new GestorDeTareas(" ir a la eps ", " ir a la eps a reclamar el acetaminofen ", 4, false ));
     }
    // agregar una nueva tarea

    public GestorDeTareas addtarea(GestorDeTareas nuevatarea) {
    if(tareas.contains(nuevatarea)){
        throw new tareaDuplicadaException("la tarea que se esta intentando agregar ya esta en la lista ");
    }

    tareas.add(nuevatarea);
    System.out.println("tarea agregada con exito");
    return nuevatarea;

    }

    // devuelve todas las tareas de la lista
    public int getNumeroDeTareas(){
        return tareas.size();
    }

    public void limpiarTareas(){
        /*
         * 
         * 
         */
    }

    public String generarReporte(){
        return "reporte generado con "+tareas.size()+" tareas";
    }

}
