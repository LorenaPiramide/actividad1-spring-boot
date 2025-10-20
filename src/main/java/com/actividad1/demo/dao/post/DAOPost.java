package com.actividad1.demo.dao.post;

import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;

import java.util.List;

// PostService
public interface DAOPost {

    void addPost(String texto, String fecha);
    List<Post> getPostPorUsuario(Usuario usuario);
    List<Post> getPosts();
    List<Post> ordenarAscendente();
    List<Post> ordenarDescendente();
    List<Post> filtrarPorUsuario(String usuario);
    List<Post> filtrarPorContenido(String contenido);
    List<Post> filtrarPorFecha(String fecha);

    void darLike(String nombreUsuario, int postId);
    void quitarLike(String nombreUsuario, int postId);
    boolean usuarioDioLike(String nombreUsuario, int postId);
    int getNumeroLikes(int postId);

    void repostear(String nombreUsuario, int postId);
    boolean usuarioReposteado(String nombreUsuario, int postId);
    int getNumeroReposts(int postId);
}
