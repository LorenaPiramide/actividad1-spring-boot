package com.actividad1.demo.dao.post;

import com.actividad1.demo.entidades.Usuario;

import java.util.List;

public interface DAOPost {
    public List<Usuario> getLikes();
    public List<Usuario> getRepost();
    public int mostrarNumeroLikes(List<Usuario> usuariosLikes);
    public int mostrarNumeroReposts(List<Usuario> usuariosReposts);
}
