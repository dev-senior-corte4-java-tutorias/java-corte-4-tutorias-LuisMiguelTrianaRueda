package com.devsenior.luistriana.sistemaparqueadero.service;

import java.util.List;
import java.util.Map;

import com.devsenior.luistriana.sistemaparqueadero.model.Carro;

public interface ServiceParqueadero {
void agregarCarro(Carro carro);

List<Carro> obtenerTodosLosCarros();

Carro buscarCarroPorPlaca(String placa);

void eliminarCarro(String placa);

 Carro actualizarTiempo(String placa, Carro carro);

 Map<String , Object> calcularPago(String placa);

}
