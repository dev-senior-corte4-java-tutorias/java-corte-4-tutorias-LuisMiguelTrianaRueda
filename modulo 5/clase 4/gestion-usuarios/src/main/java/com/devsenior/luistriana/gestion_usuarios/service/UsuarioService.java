package com.devsenior.luistriana.gestion_usuarios.service;

import java.util.List;

import com.devsenior.luistriana.gestion_usuarios.model.Usuario;

public interface UsuarioService {
 // actualizar usuarios solo lo puede hacer el rol admin 
Usuario actualizarUsuarios(Integer id, Usuario usuario, Usuario usuarioActual);

// actualizar el mimso rol osea estandar o un administrador 
Usuario actualizarMiUsuarios(Integer id, Usuario usuario, Usuario usuarioActual);

// solo lo puede hacer el administrador 
void crearUsuario (Usuario usuario, Usuario usuarioActual);

// solo el admin 
List<Usuario> verTodoslosUsuarios(Usuario usuarioActual);

// eliminar un Usuario solo el administrador 
void eliminarUsuario(Integer id, Usuario usuarioActual);


// ver usuarios por id 
Usuario verUsuarioPorId(Integer id, Usuario usuarioActual);

}
