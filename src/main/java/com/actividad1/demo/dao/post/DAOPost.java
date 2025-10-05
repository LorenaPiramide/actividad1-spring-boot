package com.actividad1.demo.dao.post;

import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;

import java.util.List;

public interface DAOPost {
//    public List<Usuario> getLikes();

    public void addPost(Post post);
    public void repost(Post post, Usuario usuario);

    public void showPosts();
    public void showUserPosts(Usuario usuario);


    public int getRepostNumber(Post post);
}
