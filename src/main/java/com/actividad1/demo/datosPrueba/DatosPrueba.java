package com.actividad1.demo.datosPrueba;

import com.actividad1.demo.model.Post;
import com.actividad1.demo.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatosPrueba {
    Usuario usuarioPatata = new Usuario(1, "Patata123", "patatapass");
    Usuario usuarioLechuga = new Usuario(1, "Lechuga987", "lechugapass");

    List<Usuario> usuarios = new ArrayList<>();

    Post postLechuga1 = new Post(1, "Este es el primer post de Lechuga", usuarioLechuga);
    Post postPatata1 = new Post(2, "Este es el primer y único post de Patata", usuarioPatata);
    Post getPostLechuga2 = new Post(3, "Este es el segundo post de Lechuga", usuarioLechuga);

    List<Post> posts = new ArrayList<>();

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
