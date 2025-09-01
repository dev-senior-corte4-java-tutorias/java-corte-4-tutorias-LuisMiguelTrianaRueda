package com.devsenior.tutorias.luistriana.excepctions;

public class ProductoExistente extends RuntimeException  {

    public ProductoExistente(String message){
        super(message);
    }
}
