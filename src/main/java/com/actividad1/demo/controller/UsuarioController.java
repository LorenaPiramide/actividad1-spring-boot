package com.actividad1.demo.controller;

import com.actividad1.demo.dao.DAOFactory;
import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    String guardaUsuario(Usuario usuario, Model model) {
        if (DAOFactory.getInstance().getDaoUsuario().existeUsuario(usuario.getNombreUsuario())) {
            model.addAttribute("error", "Nombre de usuario no disponible. Vuelve a intentarlo");
            return "nuevo_usuario";
        }
        DAOFactory.getInstance().getDaoUsuario().guardaUsuario(usuario);
        return "redirect:/login";
    }

    // Muestra los usuarios pero creo que no hace falta
//    @GetMapping("/usuarios")
//    String getUsuarios() {
//        DAOFactory daoFactory = DAOFactory.getInstance();
//        List<Usuario> usuarios = daoFactory.getDaoUsuario().getUsuarios();
//        System.out.println(usuarios);
//        return "usuarios";
//    }

    @PostMapping("/login")
    String loginUsuario(Usuario usuario, Model model) {
        boolean valido = DAOFactory.getInstance().getDaoUsuario().comprobarLogin(usuario.getNombreUsuario(), usuario.getPassword());

        if (valido) {
            Usuario usuarioGuardado = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(usuario.getNombreUsuario());

            model.addAttribute("usuario", usuarioGuardado);

            return "perfil_usuario";
        } else {
            return "login";
        }
    }

    @RequestMapping("/perfil_usuario")
    String perfilUsuario(Usuario usuario, Model model) {
        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPostPorUsuario(usuario);

        model.addAttribute("posts", posts);
        return "perfil_usuario";
    }

}
