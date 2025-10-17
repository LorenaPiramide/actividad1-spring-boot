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
    public void addPost(String texto, String fecha) {
        try {
            String query = "INSERT INTO Post VALUES (?, ?)";
            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(0, texto);
            preparedStatement.setDate(1, Date.valueOf(fecha));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void repost(Post post, Usuario usuario) {

    }

    @Override
    public List<Post> getPostPorUsuario(Usuario usuario) {
        return List.of();
    }

    @Override
    public int getNumeroReposts(Post post) {
        return 0;
    }

    @Override
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Post";
        try {
            PreparedStatement preparedStatement = BDConnector.getInstance().prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            // Creo que tengo que obtener el id, pero debería hacer un constructor con el id???? Vacío no cuela, lo he probado
            if (rs.next()) {
                Post post = new Post(rs.getString("texto"), LocalDateTime.parse(rs.getString("fecha")));
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return List.of();
    }

    @Override
    public List<Post> ordenarAscendente() {
        return List.of();
    }

    @Override
    public List<Post> ordenarDescendente() {
        return List.of();
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
