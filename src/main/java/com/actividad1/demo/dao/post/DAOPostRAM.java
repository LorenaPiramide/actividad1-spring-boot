package com.actividad1.demo.dao.post;


import com.actividad1.demo.entidades.Post;
import com.actividad1.demo.entidades.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class DAOPostRAM { //implements DAOPost {
    private int idIndex = 0;
    public List<Usuario> usuariosReposts;
    //public List<Post> postsFiltrados;
    public List<Post> posts;

    public DAOPostRAM() {
        this.usuariosReposts = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    //@Override
    public void addPost(Post post) {
        post.setId(idIndex);
        idIndex++;
        this.posts.add(post);
    }

    //@Override
    public void repost(Post postOriginal, Usuario usuarioRepost) {
        Post repost = new Post(postOriginal.getTexto(), usuarioRepost, true);

        repost.setFecha(LocalDateTime.now());

        this.addPost(repost);
    }

    //@Override
    public List<Post> getPostPorUsuario(Usuario usuario) {
        List<Post> postUSuario = new ArrayList<>();
        for (Post post : this.posts) {
            if (post.getUsuario().getNombreUsuario().equals(usuario.getNombreUsuario())) {
                postUSuario.add(post);
            }
        }
        return postUSuario;
    }

    //@Override
    public int getNumeroReposts(Post post) {
        int mostrarNumeroReposts = 0;
        for (Post p : this.posts) {
            if (p.getRepost()) {
                mostrarNumeroReposts++;
            }
        }
        return mostrarNumeroReposts;
    }

    //@Override
    public List<Post> getPosts() {
        return this.posts;
    }

    //@Override
    public List<Post> ordenarAscendente() {
        this.posts.sort(Comparator.comparing(Post::getFecha));
        return this.posts;
    }

    //@Override
    public List<Post> ordenarDescendente() {
        this.posts.sort((p1, p2) -> p2.getFecha().compareTo(p1.getFecha()));
        return this.posts;
    }

    //@Override
    public List<Post> filtrarPorUsuario(String usuario) {
        List<Post> postsFiltrados = new ArrayList<>();
        for (Post post : this.posts) {
            if (post.getUsuario().getNombreUsuario().equals(usuario)) {
                postsFiltrados.add(post);
            }
        }
        return postsFiltrados;
    }

    //@Override
    public List<Post> filtrarPorContenido(String texto) {
        List<Post> postsFiltrados = new ArrayList<>();
        for (Post post : this.posts) {
            if (post.getTexto() != null && post.getTexto().toLowerCase().contains(texto.toLowerCase())) {
                postsFiltrados.add(post);
            }
        }
        return postsFiltrados;
    }

    //@Override
    public List<Post> filtrarPorFecha(String fechaString) {
        List<Post> postsFiltrados = new ArrayList<>();
        try {
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaBuscada = LocalDate.parse(fechaString);

            for (Post post : this.posts) {
                if (post.getFecha().toLocalDate().equals(fechaBuscada)) {
                    postsFiltrados.add(post);
                }
            }
        } catch (Exception e) {
            return postsFiltrados;
        }
        return postsFiltrados;
    }

}
