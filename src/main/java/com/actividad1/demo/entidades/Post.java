package com.actividad1.demo.entidades;

import java.time.LocalDateTime;

public class Post {
    private String texto;
    private int id = -1;
    private Usuario usuario;
    private int repost = -1;
    private LocalDateTime fecha;

    public Post(String texto, Usuario usuario, int repost) {
        this.texto = texto;
        this.usuario = usuario;
        this.repost = repost;
    }

    public Post(String texto, Usuario usuario) {
        this.texto = texto;
        this.usuario = usuario;
    }

    public Post() {
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\nTexto: " + texto + " " + usuario;
    }
}
