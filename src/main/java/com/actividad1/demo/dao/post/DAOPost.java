package com.actividad1.demo.dao.post;

import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;

import java.util.List;

// PostService
public interface DAOPost {

    void addPost(String texto, String fecha);
    //void repost(Post post, Usuario usuario);
    List<Post> getPostPorUsuario(Usuario usuario);
    //int getNumeroReposts(Post post);
    List<Post> getPosts();
    List<Post> ordenarAscendente();
    List<Post> ordenarDescendente();
    List<Post> filtrarPorUsuario(String usuario);
    List<Post> filtrarPorContenido(String contenido);
    List<Post> filtrarPorFecha(String fecha);
}
