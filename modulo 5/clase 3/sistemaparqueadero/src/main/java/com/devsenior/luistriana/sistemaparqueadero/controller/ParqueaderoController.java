package com.devsenior.luistriana.sistemaparqueadero.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.luistriana.sistemaparqueadero.model.Carro;
import com.devsenior.luistriana.sistemaparqueadero.service.ServiceParqueadero;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/parqueadero")
public class ParqueaderoController {
    private final ServiceParqueadero carros;

    public ParqueaderoController(ServiceParqueadero carros) {
        this.carros = carros;
    }

    // ver todos los carros
    @GetMapping("/vercarros")
    public List<Carro> verCarros() {
        return carros.obtenerTodosLosCarros();
    }

    // agregar un nuevo carro
    @PostMapping("/carro")
    public Carro agregarCarro(@RequestBody Carro carro) {

        carros.agregarCarro(carro);
        return carro;

    }

    // eliminar un carro
    @DeleteMapping("/carro/{placa}")
    public void eliminarCarro(@PathVariable String placa) {
        carros.eliminarCarro(placa);
    }

    // actualizar el tiempo de un carro
    @PatchMapping("/carro/{placa}")
    public void actualizarTiempo(@PathVariable String placa, @RequestBody Carro carro) {
        carros.actualizarTiempo(placa, carro);

    }

    // calcular el tiempo de uso del parqueadero
    @GetMapping("/carro/tiempo/{placa}")
    public Map<String, Object> calcularPago(@PathVariable String placa) {
        return carros.calcularPago(placa);
    }

}
