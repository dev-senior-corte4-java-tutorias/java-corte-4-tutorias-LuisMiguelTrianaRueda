package com.devsenior.luistriana.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
 private String nombre;
 private String direcciones;
 private String horarios;

 public String getNombre() {
    return nombre;
 }

 public String getDirecciones() {
    return direcciones;
 }

 public void setDirecciones(String direcciones) {
    this.direcciones = direcciones;
 }

 public String getHorarios() {
    return horarios;
 }

 public void setHorarios(String horarios) {
    this.horarios = horarios;
 }

 public City(String nombre, String direcciones, String horarios) {
   this.nombre = nombre;
   this.direcciones = direcciones;
   this.horarios = horarios;
 }

 @Override
 public int hashCode() {
   // comparando por los objetos por el nombre 
   return Objects.hash(nombre);
 }

 @Override
 public boolean equals(Object obj) {
   if (this == obj)
      return true;
   if (obj == null)
      return false;
   if (getClass() != obj.getClass())
      return false;
   City other = (City) obj;
   if (nombre == null) {
      if (other.nombre != null)
         return false;
   } else if (!nombre.equals(other.nombre))
      return false;
   if (direcciones == null) {
      if (other.direcciones != null)
         return false;
   } else if (!direcciones.equals(other.direcciones))
      return false;
   if (horarios == null) {
      if (other.horarios != null)
         return false;
   } else if (!horarios.equals(other.horarios))
      return false;
   return true;
 }

 
}
