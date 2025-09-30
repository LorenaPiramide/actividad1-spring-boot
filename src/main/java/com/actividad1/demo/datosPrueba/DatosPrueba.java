package com.actividad1.demo.datosPrueba;

import com.actividad1.demo.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatosPrueba {
    Usuario usuarioPatata = new Usuario(1, "Patata123", "patatapass");
    Usuario usuarioLechuga = new Usuario(1, "Lechuga987", "lechugapass");

    List<Usuario> usuarios = new ArrayList<>();

    public DatosPrueba() {
        usuarios.add(usuarioPatata);
        usuarios.add(usuarioLechuga);
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
