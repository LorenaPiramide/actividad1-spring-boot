package com.actividad1.demo.dao.usuario;

import com.actividad1.demo.dao.BDConnector;
import com.actividad1.demo.dao.DAOFactory;
import com.actividad1.demo.entidades.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuarioMySQL implements DAOUsuario {
    //private Usuario usuarioActual = null;
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

            return rs.next();

//            if (rs.next()) {
//                //usuarioActual = new Usuario(nombreUsuario, password);
//              Usuario usuarioActual = DAOFactory.getInstance().getDaoUsuario().obtenerUsuarioPorNombre(nombreUsuario); // Podría buscar el usuario por nombre
//                // todo, aunque aquí parece que no hace falta porque está en usuarioController?
//                return true;
//            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        //return false;
    }

    // Se comprueba si existe o no, porque no puede haber 2 usuarios con el mismo nombre
    // todo, igual aquí podría hacer que si existe el usuario, en el método de arriba, poner que Usuario usuarioActual = usuario ????
    @Override
    public boolean existeUsuario(String nombreUsuario) {
        String query = "SELECT * FROM Usuario WHERE nombre_usuario = ?";
        try {
            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, nombreUsuario);
            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
//            if (rs.next()) {
//                return true;
//            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        //return false;
    }

    // todo, arreglar esto también
    // Esto antes era getUsuarioActual, que devolvía el usuarioActual de static, ahora lo he modificado por buscarUsuarioPorNombre
    @Override
    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        String query = "SELECT * FROM Usuario WHERE nombre_usuario = ?";
        try {
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getString("nombre_usuario"), rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;

//        try {
//            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
//            ps.setString(1, nombreUsuario); // todo ????? Hay que arreglar muchas cosas de posts
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                return new Usuario(rs.getString("nombre_usuario"), rs.getString("password"));
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
//        return null;
    }

//    public void cerrarSesion() {
//        usuarioActual = null;
//    }
}
