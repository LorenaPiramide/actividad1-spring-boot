package com.actividad1.demo.controller;

import com.actividad1.demo.dao.DAOFactory;
import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/crear_post")
    String crearPost(@RequestParam String nombreUsuario, Model model) {
        Usuario usuario = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);
        model.addAttribute("usuario", usuario);
        return "crear_post";
    }

    @PostMapping("/post/crear")
    String guardaPost(@RequestParam String texto, @RequestParam String nombreUsuario, Model model) {
        Usuario usuario = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);
        Post post = new Post(texto, usuario);
        post.setFecha(LocalDateTime.now());
        DAOFactory.getInstance().getDaoPost().addPost(post);

        model.addAttribute("usuario", usuario);

        return "perfil_usuario";
    }

    @GetMapping("/inicio")
    String getPosts(Model model) {
        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPosts();

        model.addAttribute("posts", posts);
        return "inicio";
    }
}
