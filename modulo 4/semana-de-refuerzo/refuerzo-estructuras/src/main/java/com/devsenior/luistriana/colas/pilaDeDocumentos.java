package com.devsenior.luistriana.colas;

import java.util.LinkedList;
import java.util.Queue;

public class pilaDeDocumentos {
    public static void main(String[] args) {

        Queue<String> cola = new LinkedList<>();

        /*metodo para agregar  */
        cola.offer("documento0.pdf");
        cola.offer("documento1.pdf");
        cola.offer("documento2.pdf");

        String doc1 = cola.poll();
        System.out.println(" documento 1 a imprimir "+doc1);

        String doc2 = cola.poll();
        System.out.println(" documento 2 a imprimir "+doc2);

        System.out.println(" cola de impresion despues de imprimir "+cola);

        String proximo = cola.peek();

        System.out.println(" el proximo en la cola es "+proximo);


        System.out.println(" la cola al final sin cambios "+cola);
        
    }
}
