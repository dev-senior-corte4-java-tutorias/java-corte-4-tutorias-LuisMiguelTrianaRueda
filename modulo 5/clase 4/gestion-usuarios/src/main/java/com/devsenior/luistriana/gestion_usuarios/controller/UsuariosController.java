package com.devsenior.luistriana.gestion_usuarios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.luistriana.gestion_usuarios.model.Usuario;
import com.devsenior.luistriana.gestion_usuarios.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

@Tag(name = "usuarios", description = "api para la gestion de usuarios de un programa educativo")
@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    private final UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // crear un usuario -> solo lo puede hacer el admin
    @Operation(summary = "crear un nuevo usuario", description = "permite crear un usuario nuevo en el sistema solo pueden hacer alas personas con rol administrador")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos (validación fallida)", content = @Content),
            @ApiResponse(responseCode = "403", description = "Acceso denegado - Solo administradores pueden crear usuarios", content = @Content)
    })
    @PostMapping
    public Usuario crearUsuario(@Valid @RequestBody Usuario usuario) {

        Usuario usuarioActual = null;
        usuarioService.crearUsuario(usuario, usuarioActual);
        return usuario;
    }

    @Operation(summary = "ver todos los usuarios del sistema solo lo puede hacer el rol administrador", description = "retorna una lista de todos los usuarios que hay en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "lista de usuarios obtenidos exitosamente ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))

    })
    @GetMapping
    public List<Usuario> vertodosLosUsuarios() {
        Usuario usuarioActual = null;
        return usuarioService.verTodoslosUsuarios(usuarioActual);
    }

    // ver un usuario por Id
    @Operation(summary = "ve usuario por Id ", description = " permite ver un usuario en especifico que tiene ese mismo campo en el atributo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "lista el usuario con ese Id exitosamente ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))

    })
    @GetMapping("/{id}")
    public Usuario verUsuarioPorId(@PathVariable Integer id) {
        Usuario usuarioActual = null;
        return usuarioService.verUsuarioPorId(id, usuarioActual);
    }

    @Operation(summary = "actualiza un usuario ", description = " permite actualizar completamente un usuario en especifico segun su Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "actualiza el usuario en todos sus campos exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))

    })
    // actualizar usuario por id -> admin
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioActual = null;
        return usuarioService.actualizarUsuarios(id, usuario, usuarioActual);

    }

    @Operation(summary = " actualizacion de perfil ", description = " permite actualizar el mismo perfil del usuario lo pueden hacer personas con rol estandar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "actualiza el perfil de un usuario exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))

    })
    // actualizar mi perfil
    @PutMapping("mi-perfil/{id}")
    public Usuario actualizarMiPerfil(@PathVariable Integer id, @RequestBody Usuario asuario) {
        Usuario usuarioActual = null;
        return usuarioService.actualizarMiUsuarios(id, usuarioActual, usuarioActual);

    }

    @Operation(summary = "permite eliminar un usuario ", description = "elimina completamente los datos de un usuario en especifico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "elimina completamente un usuario ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class)))

    })
    // eliminar un usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        Usuario usuarioActual = null;
        usuarioService.eliminarUsuario(id, usuarioActual);
    }
}
