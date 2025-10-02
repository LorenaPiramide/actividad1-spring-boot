package com.actividad1.demo.controller;

import com.actividad1.demo.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    Usuario usuarioPatata = new Usuario(1, "Patata123", "patatapass");
    Usuario usuarioLechuga = new Usuario(1, "Lechuga987", "lechugapass");

    List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {
        usuarios.add(usuarioPatata);
        usuarios.add(usuarioLechuga);
    }

    @RequestMapping("/login")
    String login() {
        return "login.html";
    }

    @RequestMapping("/nuevo_usuario")
    String nuevoUsuario() {
        return "nuevo_usuario.html";
    }

    @RequestMapping("/perfil_usuario")
    String perfilUsuario() {
        return "perfil_usuario.html";
    }
}
