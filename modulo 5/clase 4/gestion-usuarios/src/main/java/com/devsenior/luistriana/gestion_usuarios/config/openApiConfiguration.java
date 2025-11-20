package com.devsenior.luistriana.gestion_usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class openApiConfiguration {

    /* para que spring boot lo pueda gestionar */
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .addServersItem(new Server().url("http://localhost:8080"))
                .info(new Info()
                        .title("API de gestion de usuarios")
                        .version("1.0.0 ")
                        .description(
                                """
                                        API rest para la gestion de usuario de un sistema generico e educativo
                                        **funcionalidades principales como:**
                                        - CRUD completo de usuarios (crear, leer, actualizar, eliminar)
                                        - gestion de roles
                                        - validaciones basada en permisos dependiendo el rol del usuario
                                        - filtrado para consultar informacion especifica de un usuario


                                        **roles disponibles**
                                        - ADMINISTRADOR -> acceso completo a todas las operaciones
                                        - ESTANDAR -> acceso parcial a operaciones de su propio perfil

                                        **NOTA** proyecto educativo que se va a ir  construyendo con el paso de los modulos en la academia dev senior
                                        """)
                        .contact(new Contact().name("estudiante dev senior").email("estudiante.devseniorcode.com")
                                .url("https://github.com"))
                        .license(new License().name("proyecto de devseniorcode.com"))
                );

    }
}
