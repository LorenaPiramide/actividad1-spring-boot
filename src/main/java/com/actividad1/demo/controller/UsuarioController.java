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

    // todo, modificación en comprobarLogin()
    @PostMapping("/login")
    String loginUsuario(@RequestParam String nombreUsuario, @RequestParam String password, Model model) {
        //Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().getUsuarioActual();
        if (DAOFactory.getInstance().getDaoUsuario().comprobarLogin(nombreUsuario, password)) {
            Usuario usuario = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario); // Obtener usuario y sacar el nombre
            //todo, con esto vale??
            model.addAttribute("usuarioActual", usuario);
            return "perfil_usuario";
//            model.addAttribute("usuarioActual", usuarioActual);
//            if (DAOFactory.getInstance().getDaoUsuario().comprobarLogin(usuarioActual.getNombreUsuario(), usuarioActual.getPassword())) {
//                return "perfil_usuario";
//            }
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

    // Muestra los usuarios pero creo que no hace falta
//    @GetMapping("/usuarios")
//    String getUsuarios() {
//        DAOFactory daoFactory = DAOFactory.getInstance();
//        List<Usuario> usuarios = daoFactory.getDaoUsuario().getUsuarios();
//        System.out.println(usuarios);
//        return "usuarios";
//    }

    @GetMapping("/logout")
    String logout(){
        return "redirect:/login";
    }

    // todo, he modificado esto también porque idk
    @RequestMapping("/perfil")
    String verPerfil(@RequestParam String nombreUsuario, Model model) {

        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);
        model.addAttribute("usuarioActual", usuarioActual);

        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPostPorUsuario(usuarioActual);

        model.addAttribute("posts", posts);

        return "perfil_usuario";
    }

}
