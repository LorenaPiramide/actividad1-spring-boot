package com.actividad1.demo.model;

public class Usuario {
    private int contador = 0;
    private int id;
    private String nombreUsuario;
    private String email;
    private String password;

    public Usuario(String nombreUsuario, String email, String password) {
        contador++;
        this.id = contador;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario + ". Email: " + email + ". \n";
    }
}
