package com.actividad1.demo.dao.post;

import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;

import java.util.List;

public interface DAOPost {

    void addPost(Post post);
    void repost(Post post, Usuario usuario);
    List<Post> getPostPorUsuario(Usuario usuario);
    int getRepostNumber(Post post);
}
