package com.devsenior.tutorias.luistriana.model;

public class Productos {
    private String nombre;
    private String descripcion;
    private int id;
    private double precio;
    private int stock;

    // metodo constructor.
    public Productos(String nombre, String descripcion,int id, double precio, int stock){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.precio= precio;
        this.stock= stock;
        
    }
 // GETTER Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
 // MOSTRAR LA INFORMACION DEL OBJETO 
    @Override
    public String toString() {
        return "Productos [nombre=" + nombre + ", descripcion=" + descripcion + ", id=" + id + ", precio=" + precio
                + ", stock=" + stock + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + id;
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + stock;
        return result;
    }
    // METODO PARA COMPARAR OBJETOS MEDIANTE SU ATRIBUTO ID 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Productos other = (Productos) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        if (stock != other.stock)
            return false;
        return true;
    }

    
}
