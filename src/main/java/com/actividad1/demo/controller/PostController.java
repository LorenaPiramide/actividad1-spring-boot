package com.actividad1.demo.controller;

import com.actividad1.demo.dao.DAOFactory;
import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @GetMapping("/crear_post")
    // Por el RequestParam necesitamos luego poner @{/crear_post(nombreUsuario=${usuario.nombreUsuario})}
    // le pasamos al mét0do la variable nombreUsuario para que la pueda leer con thymeleaf
    String crearPost(@RequestParam String nombreUsuario, Model model) {
        Usuario usuario = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);
        model.addAttribute("usuario", usuario);
        return "crear_post";
    }

    @PostMapping("/post/crear")
    String guardaPost(Post post) {
        DAOFactory.getInstance().getDaoPost().addPost(post);
        return "perfil_usuario";
    }

}
