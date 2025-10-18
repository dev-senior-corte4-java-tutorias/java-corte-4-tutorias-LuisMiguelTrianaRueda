package com.devsenior.luistriana.tutoria1documentacion.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service // manejame esta clase como un servicio para mas adelante hacer inyeccion de
         // dependencias en el controlador
public class MenuService {

    private Map<String, List<String>> comentariosPorStarter = new HashMap<>();

    public Map<String, String> saludoDeBienvenida(String nombre, String curso) {

        Map<String, String> saludo = new HashMap<>();

        saludo.put(" mensaje ", " hola " + nombre + " bienvenido al curso de " + curso);
        return saludo;
    }

    // introduccion a spring boot
    public Map<String, String> introduccionSpringboot() {

        Map<String, String> introduccion = new HashMap<>();

        introduccion.put(" introduccion",
                "bienvenido a este modulo de spring boot en donde conoceran sus mejoras en el desarrollo de software en java");

        return introduccion;
    }

    // concepto de spring boot
    public Map<String, String> conceptoSpringboot(String concepto) {

        Map<String, String> respuesta = new HashMap<>();

        switch (concepto.trim().toLowerCase()) {
            case "ioc":

                respuesta.put("concepto", "inversion de control");
                respuesta.put("explicacion", "es un principio donde el framework controla el flujo de la aplicacion"
                        + " no el programa, Spring crea y gestion los objetos por ti");

                break;

            case "bean":

                respuesta.put("concepto", "bean");
                respuesta.put("explicacion", "un bean es un objeto gestionado por spring boot el contenedor de"
                        + "spring se encarga de crear, configurar y destruir estos objetos");
                break;

            case "mvc":
                respuesta.put("concepto", "MVC - modelo vista controllador");
                respuesta.put("explicacion", " es un patron de arquitectura que separa las aplicacion en 3 capas");

                break;

            case "rest":
                respuesta.put("concepto", "REST -> representational state transfer");
                respuesta.put("explicacion", "es un estilo de arquitectura para crear apis web usando HTTP");
                break;

            default:
                respuesta.put("error ", "concepto no fue encontrado");

                break;
        }

        return respuesta;

    }

    // comentario por starter

    public String comentariosPorStarter(String starter, String comentario) {

        Map<String, String> info = startersSpringboot(starter);

        if (info.containsKey("no encontrado")) {

            return "starter no fue encontrado";
        } else {

            if (!comentariosPorStarter.containsKey(starter)) {
                comentariosPorStarter.put(starter, new ArrayList<>());

            }
            comentariosPorStarter.get(starter).add(comentario);
            return "comentario fue agregado exitosamente";
        }

    }

    public Map<String, String> startersSpringboot(String starter) {

        Map<String, String> info = new HashMap<>();

        switch (starter.trim().toLowerCase()) {
            case "web":
                info.put("starter", "spring-boot-starter-web");
                info.put("proposito", "para crear aplicaciones web y Apis Rest");
                info.put(" incluye", "spring MVC tomcat embebido, Jackson para los JSON");

                break;
            case "devtools":
                info.put("starter", "spring-boot-starter-devtools");
                info.put("proposito", "herramienta de desarrollo para mejorar la productividad");
                info.put("uso", "reinicia automaticamente la apalicacion apenas detecta un cambio");

            default:
                info.put(" no encontrado", "la opcion que se envio no esta en el sistema");
                break;
        }

        return info;

    }

    public Map<String, String> glosarioDePalabras(String palabra) {
        Map<String, String> definicion = new HashMap<>();

        switch (palabra.trim().toLowerCase()) {
            case "controller":
                definicion.put("termino ", "@controller/ @RestController");
                definicion.put("definicion",
                        "anotacion que marca una clase como controlador que maneja peticiones http");

                break;
            case "service":
                definicion.put("termino", "@service");
                definicion.put("defincion", "anota una clase como un servicio que contiene logica de negocio");
                break;
            default:
                definicion.put("error", " palabra no encontrada en el glosario");
                break;
        }

        return definicion;

    }
 
}
