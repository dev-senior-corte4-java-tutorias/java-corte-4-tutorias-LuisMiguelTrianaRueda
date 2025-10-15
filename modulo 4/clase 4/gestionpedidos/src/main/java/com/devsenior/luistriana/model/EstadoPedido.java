package com.devsenior.luistriana.model;

public enum EstadoPedido {

    EN_BODEGA("el pedido ha salido del centro de distribucion"),
    SALIDA_DE_ORIGEN("el pedido ha salido de la ciudad de envio"),
    EN_TRANSITO("el pedido esta en camino a la ciudad de destino"),
    LLEGADA_A_DESTINO("el pedido ha llegado a la ciudad de destino"),
    EN_REPARTO("el pedido esta en el camion del repartidor"),
    ENTREGADO("el pedido ha sido entregado exitosamente"),
    EN_DEVOLUCION("el pedido ha sido devuelto"),
    DEVULTO("el pedido fue devuelto a la bodega de origen");

    private final String descripcion;

    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
