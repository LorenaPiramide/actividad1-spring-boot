package com.actividad1.demo.model;

import java.util.List;

public class Post {
    private int id;
    private String texto;
    private Usuario usuario;

    List<Usuario> likes;
    List<Usuario> reposts;

    public Post(int id, String texto, Usuario usuario) {
        this.id = id;
        this.texto = texto;
        this.usuario = usuario;
    }

    public void darLike(Usuario usuario) {
        if (!likes.contains(usuario)) {
            likes.add(usuario);
        }
    }

    public void darRepost(Usuario usuario) {
        if (!reposts.contains(usuario)) {
            reposts.add(usuario);
        }
    }

    public int contarNumeroLikes() {
        return likes.size();
    }

    public int contrarNumeroReposts() {
        return reposts.size();
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "\nTexto: " + texto + "\nUsuario: " + usuario;
    }
}
