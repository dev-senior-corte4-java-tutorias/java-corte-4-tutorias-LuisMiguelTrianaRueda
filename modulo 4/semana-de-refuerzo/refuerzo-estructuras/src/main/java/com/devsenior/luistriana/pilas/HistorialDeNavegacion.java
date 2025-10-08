package com.devsenior.luistriana.pilas;

import java.util.Stack;

public class HistorialDeNavegacion {
    Stack<String> historial;

    // metodo constructor
    public HistorialDeNavegacion() {
        this.historial = new Stack<>();
    }

    public void añadirPestaña() {
        historial.push("google.com");
        historial.push("devsenior.com");
        historial.push("youtube.com");
        historial.push(" facebook.com");
        historial.push(" instagram");

    }

    public void retroceder() {
        if (historial.size() > 1) {
            String paginaDeLaQueSalimos = historial.pop();
            String paginaActual = historial.peek();

            System.out.println(" <- retrocediendo de:" + paginaDeLaQueSalimos);
            System.out.println("ahora estamos en " + paginaActual);

        }

        else if (historial.size() == 1) {

            String paginaDeLaQueSalimos = historial.pop();
            System.out.println("<-retrocendiendo a " + paginaDeLaQueSalimos);
            System.out.println(" el historial esta vacio ");
        }

        else {
            System.out.println(" no hay mas paginas en el historial para retroceder");
        }
    }
}
