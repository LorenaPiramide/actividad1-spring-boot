package com.actividad1.demo.dao.post;

import com.actividad1.demo.dao.BDConnector;
import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAOPostMySQL implements DAOPost{
    @Override
    public void addPost(String texto, String nombreUsuario) {
        try {
            String query = "INSERT INTO Post (texto, fk_usuario_post, fecha) VALUES (?, ?, NOW())";
            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, texto);
            preparedStatement.setString(2, nombreUsuario);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

//    @Override
//    public void repost(Post post, Usuario usuario) {
//
//    }

    @Override
    public List<Post> getPostPorUsuario(Usuario usuario) {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Usuario WHERE fk_usuario_post = ?";
        try {
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, usuario.getNombreUsuario());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post(rs.getInt("id_post"), rs.getString("texto"), rs.getString("fk_usuario_post"), rs.getTimestamp("fecha").toLocalDateTime());
                posts.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return posts;
    }

//    @Override
//    public int getNumeroReposts(Post post) {
//        return 0;
//    }

    @Override
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Post";
        try {
            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Post post = new Post(rs.getInt("id_post"), rs.getString("texto"), rs.getString("fk_usuario_post"), rs.getTimestamp("fecha").toLocalDateTime());
                posts.add(post);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return posts;
    }

    @Override
    public List<Post> ordenarAscendente() {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Post ORDER BY fecha ASC";
        try {
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post(rs.getInt("id_post"), rs.getString("texto"), rs.getString("fk_usuario_post"), rs.getTimestamp("fecha").toLocalDateTime());
                posts.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return posts;
    }

    @Override
    public List<Post> ordenarDescendente() {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Post ORDER BY fecha DESC";
        try {
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post(rs.getInt("id_post"), rs.getString("texto"), rs.getString("fk_usuario_post"), rs.getTimestamp("fecha").toLocalDateTime());
                posts.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return posts;
    }

    @Override
    public List<Post> filtrarPorUsuario(String usuario) {
        return List.of();
    }

    @Override
    public List<Post> filtrarPorContenido(String contenido) {
        return List.of();
    }

    @Override
    public List<Post> filtrarPorFecha(String fecha) {
        return List.of();
    }
}
