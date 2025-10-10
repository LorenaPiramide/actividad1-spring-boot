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
        // todo, arreglar esto, que es lo que peta, si no pongo el ?nombre=" + usuario.getNombreUsuario();
        if (DAOFactory.getInstance().getDaoUsuario().comprobarLogin(usuario.getNombreUsuario(), usuario.getPassword())) {
            return "redirect:/inicio"; // ?nombre=" + usuario.getNombreUsuario();
        }
        return "login";
    }

    @GetMapping("/logout")
    String logout(){
        return "redirect:/login";
    }

    @RequestMapping("/perfil")
    String verPerfil(@RequestParam String nombreUsuario, Model model) {
        Usuario usuario = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);
        if (usuario == null) {
            return "login";
        }
        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPostPorUsuario(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("posts", posts);
        return "perfil_usuario";
    }

}
