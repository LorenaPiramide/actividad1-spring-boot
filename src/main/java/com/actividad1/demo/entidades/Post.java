package com.actividad1.demo.entidades;

public class Post {
    private final String texto;;
    private int id = -1;
    private Usuario usuario;
    private int repost = -1;

    public Post(String texto, Usuario usuario, int repost) {
        this.texto = texto;
        this.usuario = usuario;
        this.repost = repost;
    }

    public Post(String texto, Usuario usuario) {
        this.texto = texto;
        this.usuario = usuario;
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

    public int getRepost() {
        return repost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setRepost(int repost) {
        this.repost = repost;
    }

    @Override
    public String toString() {
        return "\nTexto: " + texto + "\nUsuario: " + usuario;
    }
}
