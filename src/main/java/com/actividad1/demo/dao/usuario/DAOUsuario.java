package com.actividad1.demo.dao.usuario;

import com.actividad1.demo.entidades.Usuario;

import java.util.List;

public interface DAOUsuario {

    public List<Usuario> getUsuarios();
    public void guardaUsuario(Usuario usuario);
    public boolean comprobarLogin(String nombreUsuario, String password);
    public Usuario buscarPorNombre(String nombreUsuario);

}
