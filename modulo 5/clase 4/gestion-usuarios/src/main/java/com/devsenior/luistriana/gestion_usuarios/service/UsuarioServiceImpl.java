package com.devsenior.luistriana.gestion_usuarios.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.devsenior.luistriana.gestion_usuarios.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    Set<Usuario> usuarios;

    public UsuarioServiceImpl() {
        this.usuarios = new HashSet<>();
    }

    @Override
    public Usuario actualizarUsuarios(Integer id, Usuario usuario, Usuario usuarioActual) {
        validarEsAdmin(usuarioActual, "actualizar usuario");
        Usuario usuarioExistente = buscarUsuarioPorId(id);
        usuarios.remove(usuarioExistente);
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario actualizarMiUsuarios(Integer id, Usuario usuario, Usuario usuarioActual) {
        validarEsMismoUsuario(usuarioActual, id);
        Usuario usuarioExistente = buscarUsuarioPorId(id);
        usuarios.remove(usuarioExistente);
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public void crearUsuario(Usuario usuario, Usuario usuarioActual) {
        validarEsAdmin(usuarioActual, "crear usuarios");
        usuarios.add(usuario);

    }

    @Override
    public List<Usuario> verTodoslosUsuarios(Usuario usuarioActual) {
        validarEsAdmin(usuarioActual, "ver todos los usuarios");
        return new ArrayList<>(usuarios);
    }

    @Override
    public void eliminarUsuario(Integer id, Usuario usuarioActual) {
        validarEsAdmin(usuarioActual, "eliminar usuario");
        Usuario usuarioEliminado = buscarUsuarioPorId(id);
        usuarios.remove(usuarioEliminado);
    }

    @Override
    public Usuario verUsuarioPorId(Integer id, Usuario usuarioActual) {
        validarEsAdmin(usuarioActual, "ver usuario por ID");
        return buscarUsuarioPorId(id);
    }

    /// *
    /// operaciones de logica de negocio
    ///
    /// */
    // metodos para validar segun roles
    private void validarEsAdmin(Usuario usuario, String operacion) {

    }

    // metodo para validar si es el mismo usuario
    private void validarEsMismoUsuario(Usuario usuarioActual, Integer idObjetivo) {

    }

    // metodo para buscar por id

    /* auto boxing es el proceso de convertir un pequeño a un grande (int a Integer)
    y el unboxing  es el proceso contrario de un grande a un pequeño (Integer a un Int)
     */
    private Usuario buscarUsuarioPorId(Integer id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id)) // auto boxing INT A un Integer
                .findFirst() // unboxing INT 
                .orElseThrow(() -> new RuntimeException("el usuario con id " + id + " no fue encontrado"));

    }

}
