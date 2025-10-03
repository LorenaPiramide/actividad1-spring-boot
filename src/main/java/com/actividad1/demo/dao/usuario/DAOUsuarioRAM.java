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
}
