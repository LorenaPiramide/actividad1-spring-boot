package com.actividad1.demo.entidades;

public class Post {
    private final String texto;
    private final Usuario usuario;

    public Post(String texto, Usuario usuario) {
        this.texto = texto;
        this.usuario = usuario;
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
