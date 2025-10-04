package com.actividad1.demo.controller;

import com.actividad1.demo.dao.DAOFactory;
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
    String guardaUsuario(Usuario usuario) {
        DAOFactory.getInstance().getDaoUsuario().guardaUsuario(usuario);
        return "redirect:/login";
    }

    // todo este creo que no hace falta
    @GetMapping("/usuarios")
    String getUsuarios() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Usuario> usuarios = daoFactory.getDaoUsuario().getUsuarios();
        System.out.println(usuarios);
        return "usuarios";
    }

    @PostMapping("/login")
    String loginUsuario(Usuario usuario, Model model) {
        System.out.println("Usuario: " + usuario.getNombreUsuario() + "/" + usuario.getPassword());
        boolean valido = DAOFactory.getInstance().getDaoUsuario().comprobarLogin(usuario.getNombreUsuario(), usuario.getPassword());

        if (valido) {
            Usuario usuarioGuardado = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(usuario.getNombreUsuario());

            model.addAttribute("usuario", usuarioGuardado);

            return "perfil_usuario";
        } else {
            System.out.println("No funciona");
            return "login";
        }
    }

    @RequestMapping("/perfil_usuario")
    String perfilUsuario() {
        return "perfil_usuario";
    }

    // Hacer método para mostrar los repost y los post propios del usuario

    // Método de login y redirigir al perfil si es correcto
}
