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

    // Get → Recibir datos. No se puede pasar un body
    @GetMapping("/crear_post")
    String crearPost(@RequestParam String nombreUsuario, Model model) {
        Usuario usuario = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);
        model.addAttribute("usuario", usuario);
        return "crear_post";
    }

    // Post → Creación de datos, formularios, etc. Se le puede pasar un body
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
    String getPosts(@RequestParam(required = false) String nombreUsuario, Model model) {
        List<Post> posts = DAOFactory.getInstance().getDaoPost().getPosts();
        model.addAttribute("posts", posts);
        System.out.println("nombreusuario: "+nombreUsuario);
        if (nombreUsuario != null) {
            Usuario usuario = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);
            if (usuario != null) {
                model.addAttribute("usuario", usuario);
            }
        }
        return "inicio";
    }

    @PostMapping("/repost")
    String repostear(@RequestParam int postId, @RequestParam String nombreUsuario) {
        Post postOriginal = null;

        for (Post post : DAOFactory.getInstance().getDaoPost().getPosts()) {
            if (post.getId() == postId) {
                postOriginal = post;
                break;
            }
        }

        if (postOriginal == null) {
            return "redirect:/inicio"; // ?nombreUsuario=" + nombreUsuario;
        }

        Usuario usuarioRepost = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);

        DAOFactory.getInstance().getDaoPost().repost(postOriginal, usuarioRepost);

        return "redirect:/inicio"; // ?nombreUsuario=" + nombreUsuario;
    }

    @PostMapping("/like")
    String darLike(@RequestParam String nombreUsuario, @RequestParam int postId) {
        Post post = null;
        for (Post p : DAOFactory.getInstance().getDaoPost().getPosts()) {
            if (p.getId() == postId) {
                post = p;
                break;
            }
        }

        if (post == null) {
            return "redirect:/inicio"; // ?nombreUsuario=" + nombreUsuario;
        }

        Usuario usuario = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);
        if (usuario == null) {
            return "redirect:/login";
        }

        post.addLike(nombreUsuario);

        return "redirect:/inicio"; //?nombreUsuario=" + nombreUsuario;
    }

//    @GetMapping("/filtro")
//    String filtrarPorUsuario(@RequestParam String nombreUsuario, Model model) {
//        Usuario usuarioBuscado = DAOFactory.getInstance().getDaoUsuario().buscarPorNombre(nombreUsuario);
//        List<Post> postsPorUsuario = DAOFactory.getInstance().getDaoPost().getPostPorUsuario(usuarioBuscado);
//
//    }

    @GetMapping("/ascendente")
    String ascendente(Model model) {
        List<Post> posts = DAOFactory.getInstance().getDaoPost().ordenarAscendente();
        model.addAttribute("posts", posts);

        return "inicio";
    }

    @GetMapping("/descendente")
    String descendente(Model model) {
        List<Post> posts = DAOFactory.getInstance().getDaoPost().ordenarDescendente();
        model.addAttribute("posts", posts);

        return "inicio";
    }
}
