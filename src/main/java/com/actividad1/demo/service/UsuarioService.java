package com.actividad1.demo.service;

import com.actividad1.demo.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    Usuario usuarioPatata = new Usuario("Patata123", "patata@gmail.com", "patatapass");
    Usuario usuarioLechuga = new Usuario("Lechuga987", "lechuga@gmail.com", "lechugapass");

    List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        usuarios.add(usuarioPatata);
        usuarios.add(usuarioLechuga);
    }

    public void obtenerUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
