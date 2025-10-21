package com.actividad1.demo.controller;

import com.actividad1.demo.dao.DAOFactory;
import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {

    @RequestMapping("/login")
    String login() {
        return "login";
    }

    @PostMapping("/login")
    String loginUsuario(@RequestParam String nombreUsuario, @RequestParam String password, Model model) {
        if (DAOFactory.getInstance().getDaoUsuario().comprobarLogin(nombreUsuario, password)) {
            Usuario usuario = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);
            model.addAttribute("usuarioActual", usuario);
            return "inicio";
        } else {
            model.addAttribute("Error", "Nombre de usuario o contraseña incorrectos.");
            return "login";
        }
    }

    @GetMapping("/nuevo_usuario")
    String nuevoUsuario() {
        return "nuevo_usuario";
    }

    @PostMapping("/usuarios/registro")
    String guardaUsuario(Usuario usuario, Model model) {
        if (DAOFactory.getInstance().getDaoUsuario().existeUsuario(usuario.getNombreUsuario())) {
            model.addAttribute("error", "El nombre de usuario ya existe.");
            return "nuevo_usuario";
        }
        DAOFactory.getInstance().getDaoUsuario().guardaUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    String logout(){
        return "redirect:/login";
    }

    @PostMapping("/perfil")
    String verPerfil(@RequestParam String nombreUsuario, Model model) {

        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);
        model.addAttribute("usuarioActual", usuarioActual);

        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPostPorUsuario(usuarioActual);

        model.addAttribute("posts", posts);

        return "perfil_usuario";
    }
}
