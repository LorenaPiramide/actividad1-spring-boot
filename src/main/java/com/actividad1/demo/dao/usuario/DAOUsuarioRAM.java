package com.actividad1.demo.dao.usuario;

import com.actividad1.demo.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DAOUsuarioRAM implements DAOUsuario {

    public Usuario usuarioActual;
    public List<Usuario> usuarios;

    public DAOUsuarioRAM() {
        Usuario usuario = new Usuario("a", "12");
        Usuario usuario1 = new Usuario("b", "12");
        this.usuarios = new ArrayList<>();
        this.usuarios.add(usuario);
        this.usuarios.add(usuario1);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    @Override
    public void guardaUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

//    @Override
//    public Usuario buscarPorNombre(String nombreUsuario) {
//        for (Usuario usuario : usuarios) {
//            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
//                return usuario;
//            }
//        }
//        return null;
//    }

    @Override
    public boolean existeUsuario(String nombreUsuario) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario obtenerUsuarioPorNombre() {
        return usuarioActual;
    }

    @Override
    public boolean comprobarLogin(String nombreUsuario, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getPassword().equals(password)) {
                usuarioActual = usuario;
                return true;
            }
        }
        return false;
    }
}
