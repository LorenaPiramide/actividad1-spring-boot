package com.actividad1.demo.dao.usuario;

import com.actividad1.demo.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DAOUsuarioRAM implements DAOUsuario {

    public List<Usuario> usuarios;

    public DAOUsuarioRAM() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    @Override
    public void guardaUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    @Override
    public Usuario buscarPorNombre(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean comprobarLogin(String nombreUsuario, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
