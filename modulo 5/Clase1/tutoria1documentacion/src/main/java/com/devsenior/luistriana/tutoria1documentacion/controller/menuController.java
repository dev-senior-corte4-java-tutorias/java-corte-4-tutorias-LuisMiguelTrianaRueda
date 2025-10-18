package com.devsenior.luistriana.tutoria1documentacion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import com.devsenior.luistriana.tutoria1documentacion.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/menu")
public class menuController {

    @Autowired // inyeccion de dependencias
    private MenuService menuservice;

    @GetMapping("/bienvenida")
    public Map<String, String> bienvenida(

            @RequestParam String nombre,
            @RequestParam(required = false, defaultValue = "spring boot") String curso) {

        return menuservice.saludoDeBienvenida(nombre, curso);

    }

    @GetMapping("/introduccion")
    public Map<String, String> verIntroduccion() {
        return menuservice.introduccionSpringboot();

    }

    @GetMapping("/concepto/{concepto}")
    public Map<String, String> verConcepto(@PathVariable String concepto) {

        return menuservice.conceptoSpringboot(concepto);
    }

    @GetMapping("/starter/{starter}")
    public Map<String, String> verStarter(@PathVariable String starter) {
        return menuservice.startersSpringboot(starter);
    }

    @PostMapping("/starter/comentario")
    public Map<String, String> agregarComentarioStarter(@RequestBody Map<String, String> datos) {

        // separamos del requestBody
        String starter = datos.get("starter");
        String comentario = datos.get("comentario");

        // llamda al service

        String resultado = menuservice.comentariosPorStarter(starter, comentario);

        // 

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", resultado);
        respuesta.put("starter", starter);

        return respuesta;
    }

}
