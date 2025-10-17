package com.actividad1.demo.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id; // Antes estaba = -1, pero ahora está en bd
    private String texto;
    private Usuario usuario;
    private boolean repost = false; // No lo uso en bd
    private LocalDateTime fecha;
    private List<String> usuariosLike; // No lo uso en bd

    public Post(String texto, Usuario usuario, boolean repost) {
        this.texto = texto;
        this.usuario = usuario;
        this.repost = repost;
        this.usuariosLike = new ArrayList<>();
    }

    public Post(String texto, Usuario usuario) {
        this.texto = texto;
        this.usuario = usuario;
        //this.usuariosLike = new ArrayList<>(); Antes lo usaba sin bd
    }

    public Post(String texto, LocalDateTime fecha) {
        this.texto = texto;
        this.fecha = fecha;
    }

    public Post() {
        this.usuariosLike = new ArrayList<>();
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

    public boolean getRepost() {
        return repost;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public List<String> getUsuariosLike() {
        return usuariosLike;
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

    public void setRepost(boolean repost) {
        this.repost = repost;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setUsuariosLike(List<String> usuariosLike) {
        this.usuariosLike = usuariosLike;
    }

    public boolean dioLike(String nombreUsuario) {
        return usuariosLike.contains(nombreUsuario);
    }

    public void addLike(String nombreUsuario) {
        if (!dioLike(nombreUsuario)) {
            usuariosLike.add(nombreUsuario);
        }
    }

    public void quitarLike(String nombreUsuario) {
        usuariosLike.remove(nombreUsuario);
    }

    public int getNumeroLikes() {
        return usuariosLike.size();
    }

    @Override
    public String toString() {
        return "\nTexto: " + texto + ". " + usuario;
    }
}
