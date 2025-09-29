package com.actividad1.demo.model;

public class Post {
    private int contador = 0;
    private int id;
    private String texto;
    private Usuario usuario; // El usuario tiene varios posts

    public Post(String texto, Usuario usuario) {
        contador++;
        this.id = contador;
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
