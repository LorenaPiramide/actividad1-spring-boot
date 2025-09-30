package com.actividad1.demo.model;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String password;

    public Usuario(int id, String nombreUsuario, String password) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario;
    }
}
