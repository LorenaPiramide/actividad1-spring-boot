package com.actividad1.demo.controller;

import com.actividad1.demo.model.Post;
import com.actividad1.demo.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PostController {
    List<Post> posts = new ArrayList<>();
    public UsuarioController usuarioController;

    public PostController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;

        Usuario lechuga = usuarioController.usuarios.get(0);
        posts.add(new Post(1, "Este es el primer post de Lechuga", lechuga));
    }
}
