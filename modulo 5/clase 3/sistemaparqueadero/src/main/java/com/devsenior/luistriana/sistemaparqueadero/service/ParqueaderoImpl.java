package com.devsenior.luistriana.sistemaparqueadero.service;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.devsenior.luistriana.sistemaparqueadero.model.Carro;

@Service
public class ParqueaderoImpl implements ServiceParqueadero {
    Set<Carro> carros;
    private final double tarifaPorHora = 4000;

    public ParqueaderoImpl() {
        this.carros = new HashSet<>();
    }

    

    @Override
    public void agregarCarro(Carro carro) {
        carros.add(carro);
    }

    @Override
    public List<Carro> obtenerTodosLosCarros() {
      return new ArrayList<>(carros);
    }

    @Override
    public Carro buscarCarroPorPlaca(String placa) {
        return carros.stream().filter(carro -> carro.getPlaca().equals(placa))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("placa incorrecta el carro no fue encontrado en el sistema"));

    }

    @Override
    public void eliminarCarro(String placa) {
        Carro carroEliminado = buscarCarroPorPlaca(placa);
        carros.remove(carroEliminado);
    }

    @Override
    public Carro actualizarTiempo(String placa, Carro carro) {
        Carro carroActualizar = buscarCarroPorPlaca(placa);
        Optional.ofNullable(carro.getTiempoDePago()).ifPresent(carroActualizar::setTiempoDePago);
        return carroActualizar;
    }

    @Override
    public Map<String, Object> calcularPago(String placa) {
        try {
        Carro carro = buscarCarroPorPlaca(placa);
        // funcion 1
        double totalAPagar = carro.getTiempoDePago() * tarifaPorHora;
        // funcion 2 
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("placa", carro.getPlaca());
        respuesta.put("horas usadas", carro.getTiempoDePago());
        respuesta.put("tarifa por hora", tarifaPorHora);
        respuesta.put("mensaje ", "el total a pagar por el uso del parqueadero es  "+totalAPagar);
        return respuesta;
        // funcion 3 
        } catch (RuntimeException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("mensaje", "carro con la placa "+ placa+" no fue encontrado");
            return error;
        }
    }

}
