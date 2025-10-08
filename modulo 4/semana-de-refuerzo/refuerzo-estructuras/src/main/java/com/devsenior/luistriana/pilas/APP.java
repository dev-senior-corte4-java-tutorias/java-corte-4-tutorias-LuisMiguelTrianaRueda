package com.devsenior.luistriana.pilas;

public class APP {
    public static void main(String[] args) {
        HistorialDeNavegacion historial = new HistorialDeNavegacion();

        System.out.println(" añadiendo pestañas al historial ");
        historial.añadirPestaña();

        System.out.println("\n retrocediendo en el historial ");

        historial.retroceder();
        historial.retroceder();
        historial.retroceder();
        historial.retroceder();
        historial.retroceder();
        historial.retroceder();
    }
 


}
