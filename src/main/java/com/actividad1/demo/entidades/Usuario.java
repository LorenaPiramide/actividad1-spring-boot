package com.actividad1.demo.entidades;

public class Usuario {
    private final String nombreUsuario;
    private final String password;

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
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
