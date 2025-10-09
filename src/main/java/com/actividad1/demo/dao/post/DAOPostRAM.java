package com.actividad1.demo.dao.post;

import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAOPostRAM implements DAOPost {
    private int idIndex = 0;
    public List<Usuario> usuariosReposts;
    public List<Post> posts;

    public DAOPostRAM() {
        this.usuariosReposts = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    @Override
    public void addPost(Post post) {
        post.setId(idIndex);
        idIndex++;
        this.posts.add(post);
    }

    @Override
    public void repost(Post postOriginal, Usuario usuarioRepost) {
        Post repost = new Post(postOriginal.getTexto(), usuarioRepost, true);

        repost.setFecha(LocalDateTime.now());

        this.addPost(repost);
    }

    @Override
    public List<Post> getPostPorUsuario(Usuario usuario) {
        List<Post> postUSuario = new ArrayList<>();
        for (Post post : this.posts) {
            if (post.getUsuario().getNombreUsuario().equals(usuario.getNombreUsuario())) {
                postUSuario.add(post);
            }
        }
        return postUSuario;
    }

    @Override
    public int getNumeroReposts(Post post) {
        int mostrarNumeroReposts = 0;
        for (Post p : this.posts) {
            if (p.getRepost()) {
                mostrarNumeroReposts++;
            }
        }
        return mostrarNumeroReposts;
    }

    @Override
    public List<Post> getPosts() {
        return this.posts;
    }

}
