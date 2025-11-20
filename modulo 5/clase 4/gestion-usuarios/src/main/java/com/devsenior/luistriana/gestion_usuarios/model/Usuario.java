package com.devsenior.luistriana.gestion_usuarios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "modelo que representa un usuario en el sistema")
public class Usuario {
    @Schema(description = "nombre de usuario unico para el login ", example = "jperez", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "el nombre de usuario no puede ser nulo ni vacio o que solo contenga espacios")
    private String nombreUsuario;

    @Schema(description = "identificador unico del usuario ", example = "1", requiredMode = RequiredMode.REQUIRED)
    @NotNull(message = " el id es obligatorio")
    @Positive(message = " el id debe ser un numeor positivo")
    private Integer id;

    @Schema(description = "el nombre completo del usuario ", example = "juan perez", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = " el nombre completo completo del usuario no puede ser null ni vacio o que solo tenga espacios")
    private String nombreCompleto;

    @Schema(description = "la contraseña del usuario debe tener minimo 10 caracteres usando #,&@@ ", example = "jperez###", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = " la contraseña del usuario no puede ser null ni vacio o que solo tenga espacios")
    private String contraseña;


    @Schema ( description =  "el rol del usuario del sistema", example = "ADMINISTRADOR", requiredMode =  RequiredMode.REQUIRED)
    private RolUsuario rol;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, Integer id, String nombreCompleto, String contraseña, RolUsuario rol) {
        this.nombreUsuario = nombreUsuario;
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    // hashCode()
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    // EQUALS
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Usuario usuario = (Usuario) obj;
        return id != null ? id.equals(usuario.id) : usuario.id == null;
    }

}
