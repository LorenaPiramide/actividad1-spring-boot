package com.actividad1.demo.dao.usuario;

import com.actividad1.demo.dao.BDConnector;
import com.actividad1.demo.entidades.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuarioMySQL implements DAOUsuario {
    private Usuario usuarioActual = null;
    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM Usuario";

        try {
            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getString("nombre_usuario"), rs.getString("password"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return usuarios;
    }

    // Igual hay que cambiarlo y poner String nombreUsuario y crear un objeto con esto, igual que la contraseña
    @Override
    public void guardaUsuario(Usuario usuario) {
        try {
            String query = "INSERT INTO Usuario (nombre_usuario, password) VALUES (?, ?)";

            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(2, usuario.getPassword());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean comprobarLogin(String nombreUsuario, String password) {
        String query = "SELECT * FROM Usuario WHERE nombre_usuario = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, nombreUsuario);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                usuarioActual = new Usuario(nombreUsuario, password);
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return false;
    }

    // Se comprueba si existe o no, porque no puede haber 2 usuarios con el mismo nombre
    @Override
    public boolean existeUsuario(String nombreUsuario) {
        String query = "SELECT * FROM Usuario WHERE nombre_usuario = ?";
        try {
            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, nombreUsuario);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return false;
    }

    @Override
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }
}
