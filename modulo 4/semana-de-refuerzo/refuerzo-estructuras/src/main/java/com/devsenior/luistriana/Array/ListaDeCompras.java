package com.devsenior.luistriana.Array;

public class ListaDeCompras {
    String[] compras;

    public ListaDeCompras() {
        compras = new String[6];
    }

    public void comprasHechas() {
        compras[0] = " manzanas";
        compras[1] = " peras";
        compras[2] = "pescados";
        compras[3] = "queso";
        compras[4] = "dulces";
        compras [5] = " carne";

        for (String c : compras) {
            System.out.println(c);
        }

    }

    public static void main(String[] args) {
        ListaDeCompras compra = new ListaDeCompras();

        compra.comprasHechas();
    }
}
