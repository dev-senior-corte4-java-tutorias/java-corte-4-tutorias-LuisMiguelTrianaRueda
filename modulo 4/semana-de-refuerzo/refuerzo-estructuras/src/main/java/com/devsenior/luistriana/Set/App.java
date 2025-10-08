package com.devsenior.luistriana.Set;

public class App {
 
 public static void main(String[] args) {
    registroEstudiantes conjunto =  new registroEstudiantes();

    System.out.println("lista de estudiantes ");
    conjunto.agregarEstudiantes();

    System.out.println(" eliminar estudiante especifico");
    conjunto.eliminarEstudiante();

    System.out.println(" buscar estudiante ");
    conjunto.buscarEstudiante();
 }
}
