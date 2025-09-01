package com.devsenior.tutorias.luistriana.model;

public class cuenta {
    private String numeroCuenta;
    private double saldo;
    private String nombre;

    public cuenta(String numeroCuenta, double saldo, String nombre) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.nombre = nombre;
    }

    // obtener el numero de cuenta

    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    public double getSaldo(){
        return saldo;
    }

    public String getNombre() {
        return nombre;
    }


    public void depositar(double monto){
        saldo+= monto;
    }
    
    public boolean retirar(double monto){
        if(monto<=saldo){
            saldo-= monto;
            return true;
        }
        
        return false;
    }

}
