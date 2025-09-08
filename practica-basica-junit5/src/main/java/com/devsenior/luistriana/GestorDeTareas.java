package com.devsenior.luistriana;

public class GestorDeTareas {
   private String tarea;
   private String descripcion;
   private int fecha;
   private boolean completada;

   public GestorDeTareas(String tarea, String descripcion, int fecha, boolean completada) {
      this.tarea = tarea;
      this.descripcion = descripcion;
      this.fecha = fecha;
      this.completada = false;
   }

   public String getTarea() {
      return tarea;
   }

   public void setTarea(String tarea) {
      this.tarea = tarea;
   }

   public String getDescripcion() {
      return descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public int getFecha() {
      return fecha;
   }

   public void setFecha(int fecha) {
      this.fecha = fecha;
   }

   @Override
   public String toString() {
      return "GestorDeTareas [tarea=" + tarea + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
   }

   public boolean isCompletada() {
      return completada;
   }

   public void setCompletada(boolean completada) {
      this.completada = completada;
   }

}
