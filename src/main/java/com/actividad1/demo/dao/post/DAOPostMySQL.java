package com.actividad1.demo.dao.post;

import com.actividad1.demo.dao.BDConnector;
import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public List<Post> getPostPorUsuario(Usuario usuario) {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Post WHERE fk_usuario_post = ?";
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
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Post WHERE fk_usuario_post = ?";
        try {
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, usuario);
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
    public List<Post> filtrarPorContenido(String contenido) {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Post WHERE texto = ?";
        try {
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, contenido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post(rs.getInt("id_post"), rs.getString("texto"), rs.getString("fk_ usuario_post"), rs.getTimestamp("fecha").toLocalDateTime());
                posts.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return posts;
    }

    @Override
    public List<Post> filtrarPorFecha(String fecha) {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Post WHERE fecha = ?";
        try {
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, fecha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post(rs.getInt("id_post"), rs.getString("texto"), rs.getString("fk_ usuario_post"), rs.getTimestamp("fecha").toLocalDateTime());
                posts.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return posts;
    }

    @Override
    public void darLike(String nombreUsuario, int postId) {
        try {
            String query = "INSERT INTO Like (fk_usuario_like, fk_post_like) VALUES (?, ?)"; //todo, mirar el nombre en la base de datos cuando se pueda, AWS está caído
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.setInt(2, postId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void quitarLike(String nombreUsuario, int postId) {
        try {
            String query = "DELETE FROM Like WHERE fk_usuario_like = ? AND fk_post_like = ?"; //todo nombres bd
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.setInt(2, postId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean usuarioDioLike(String nombreUsuario, int postId) {
        try {
            String query = "SELECT * FROM Like WHERE fk_usuario_like = ? AND fk_post_like = ?";
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.setInt(2, postId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public int getNumeroLikes(int postId) {
        try {
            String query = "SELECT COUNT(*) as count FROM Like WHERE fk_post_like = ?";
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setInt(1, postId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("count");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void repostear(String nombreUsuario, int postId) {
        try {
            String query = "INSERT INTO Repost (fk_usuario_repost, fk_post_repost) VALUES (?, ?)";
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.setInt(2, postId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public boolean usuarioReposteado(String nombreUsuario, int postId) {
        try {
            String query = "SELECT * FROM Repost WHERE fk_usuario_repost = ? AND fk_post_repost = ?";
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.setInt(2, postId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public int getNumeroReposts(int postId) {
        try {
            String query = "SELECT COUNT(*) as count FROM Repost WHERE fk_post_repost = ?";
            PreparedStatement ps = BDConnector.getInstance().prepareStatement(query);
            ps.setInt(1, postId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("count");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
