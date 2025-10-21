package com.actividad1.demo.controller;

import com.actividad1.demo.dao.DAOFactory;
import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    // Get → Recibir datos. No se puede pasar un body
    @GetMapping("/crear_post")
    String crearPost(@RequestParam String nombreUsuario, Model model) {
        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);
        model.addAttribute("usuarioActual", usuarioActual);
        return "crear_post";
    }

    // Post → Creación de datos, formularios, etc. Se le puede pasar un body
    @PostMapping("/post/crear")
    String guardaPost(@RequestParam String nombreUsuario, @RequestParam String texto, Model model) {
        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);
        if (usuarioActual == null) {
            return "redirect:/login";
        }
        DAOFactory.getInstance().getDaoPost().addPost(texto, usuarioActual.getNombreUsuario());

//        todo, no sé si funciona
        model.addAttribute("usuarioActual", usuarioActual);
        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPostPorUsuario(usuarioActual);
        model.addAttribute("posts", posts);

        return "perfil_usuario";
    }

    @GetMapping("/inicio")
    String getPosts(@RequestParam String nombreUsuario, Model model) {
        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPosts();
        model.addAttribute("posts", posts);

        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);

        model.addAttribute("usuarioActual", usuarioActual);

        return "inicio";
    }

    @PostMapping("/repost")
    String repostear(@RequestParam String nombreUsuario, @RequestParam int postId, Model model) {
        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);

        if (!DAOFactory.getInstance().getDaoPost().usuarioReposteado(nombreUsuario, postId)) {
            DAOFactory.getInstance().getDaoPost().repostear(nombreUsuario, postId);
        }

        // todo hace falta?
        model.addAttribute("usuarioActual", usuarioActual);
        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPosts();
        model.addAttribute("posts", posts);

        return "inicio";
    }

    @PostMapping("/like")
    String darLike(@RequestParam String nombreUsuario, @RequestParam int postId, Model model) {

        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);

        if (DAOFactory.getInstance().getDaoPost().usuarioDioLike(nombreUsuario, postId)) {
            DAOFactory.getInstance().getDaoPost().quitarLike(nombreUsuario, postId);
        } else {
            DAOFactory.getInstance().getDaoPost().darLike(nombreUsuario, postId);
        }

        //todo, esto hace falta??
        model.addAttribute("usuarioActual", usuarioActual);
        //todo no sé si esto hace falta...
        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPosts();
        model.addAttribute("posts", posts);

        return "inicio";
    }

    @GetMapping("/filtrar")
    String filtrar(@RequestParam String nombreUsuario, @RequestParam String texto, @RequestParam String fecha, Model model) {

        List<Post> postFiltrados = DAOFactory.getInstance().getDaoPost().getPosts();

        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            postFiltrados = DAOFactory.getInstance().getDaoPost().filtrarPorUsuario(nombreUsuario.trim());
        } else if (texto != null && !texto.trim().isEmpty()) {
            postFiltrados = DAOFactory.getInstance().getDaoPost().filtrarPorContenido(texto.trim());
        } else if (fecha != null && !fecha.trim().isEmpty()) {
            postFiltrados = DAOFactory.getInstance().getDaoPost().filtrarPorFecha(fecha.trim());
        }

        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);
        model.addAttribute("usuarioActual", usuarioActual);
        model.addAttribute("posts", postFiltrados);

        return "inicio";
    }

    @GetMapping("/ascendente")
    String ascendente(@RequestParam String nombreUsuario, Model model) {

        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);
        model.addAttribute("usuarioActual", usuarioActual);

        List<Post> posts = DAOFactory.getInstance().getDaoPost().ordenarAscendente();
        model.addAttribute("posts", posts);

        return "inicio";
    }

    @GetMapping("/descendente")
    String descendente(@RequestParam String nombreUsuario, Model model) {

        Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario);
        model.addAttribute("usuarioActual", usuarioActual);

        List<Post> posts = DAOFactory.getInstance().getDaoPost().ordenarDescendente();
        model.addAttribute("posts", posts);

        return "inicio";
    }
}
