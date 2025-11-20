package com.devsenior.luistriana.gestion_usuarios.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Roles disponibles para los usuarios del sistema")
public enum RolUsuario {

    /*
     es para darle una descricpcion en este caso a un ROl de nuestro programa 
     */
    @Schema(description = "usuario con permisos totales ")
    ADMINISTRADOR,
    @Schema(description = "usuario con permismo limitados")
    ESTANDAR
}
