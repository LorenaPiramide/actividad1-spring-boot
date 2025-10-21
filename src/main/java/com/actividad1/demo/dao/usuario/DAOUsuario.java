package com.actividad1.demo.dao.usuario;

import com.actividad1.demo.entidades.Usuario;

import java.util.List;

public interface DAOUsuario {

    List<Usuario> getUsuarios();
    void guardaUsuario(Usuario usuario);
    boolean comprobarLogin(String nombreUsuario, String password);
    boolean existeUsuario(String nombreUsuario);
    Usuario obtenerUsuarioPorNombre(String nombreUsuario);
}
