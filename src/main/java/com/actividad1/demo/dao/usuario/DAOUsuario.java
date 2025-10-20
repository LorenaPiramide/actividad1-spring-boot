package com.actividad1.demo.dao.usuario;

import com.actividad1.demo.entidades.Usuario;

import java.util.List;

// UsuarioService
public interface DAOUsuario {

    List<Usuario> getUsuarios();
    void guardaUsuario(Usuario usuario);
    boolean comprobarLogin(String nombreUsuario, String password);
    //Usuario buscarPorNombre(String nombreUsuario);
    boolean existeUsuario(String nombreUsuario);
    Usuario obtenerUsuarioPorNombre(String nombreUsuario);
}
