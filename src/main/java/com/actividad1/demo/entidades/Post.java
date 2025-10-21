package com.actividad1.demo.entidades;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private String texto;
    private String usuario;
    private LocalDateTime fecha;

    public Post(int id, String texto, String usuario, LocalDateTime fecha) {
        this.id = id;
        this.texto = texto;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public String getUsuario() {
        return usuario;
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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\nTexto: " + texto + ". " + usuario;
    }
}
