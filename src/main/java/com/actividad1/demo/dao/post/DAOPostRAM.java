package com.actividad1.demo.dao.post;

import com.actividad1.demo.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DAOPostRAM implements DAOPost {

    public List<Usuario> usuariosLikes;
    public List<Usuario> usuariosReposts;

    public DAOPostRAM() {
        this.usuariosLikes = new ArrayList<>();
        this.usuariosReposts = new ArrayList<>();
    }

    @Override
    public List<Usuario> getLikes() {
        return this.usuariosLikes;
    }

    @Override
    public List<Usuario> getRepost() {
        return this.usuariosReposts;
    }

    @Override
    public int mostrarNumeroLikes(List<Usuario> usuariosLikes) {
        return usuariosLikes.size();
    }

    @Override
    public int mostrarNumeroReposts(List<Usuario> usuariosReposts) {
        return usuariosReposts.size();
    }
}
