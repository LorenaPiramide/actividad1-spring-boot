package com.actividad1.demo.controller;

import com.actividad1.demo.dao.DAOFactory;
import com.actividad1.demo.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @RequestMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/nuevo_usuario")
    String nuevoUsuario() {
        return "nuevo_usuario";
    }

    @PostMapping("/usuarios/registro")
    String guardaUsuario(Usuario usuario) {
        DAOFactory.getInstance().getDaoUsuario().guardaUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios")
    String getUsuarios() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Usuario> usuarios = daoFactory.getDaoUsuario().getUsuarios();
        System.out.println(usuarios);
        return "usuarios";
    }

    @RequestMapping("/perfil_usuario")
    String perfilUsuario() {
        return "perfil_usuario";
    }
}
