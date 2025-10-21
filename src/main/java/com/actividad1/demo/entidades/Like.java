package com.actividad1.demo.entidades;

public class Like {
    private int idPostLike;
    private String usuarioLike;

    public Like(int idPostRepost, String usuarioRepost) {
        this.idPostLike = idPostRepost;
        this.usuarioLike = usuarioRepost;
    }

    public int getIdPostLike() {
        return idPostLike;
    }

    public void setIdPostLike(int idPostLike) {
        this.idPostLike = idPostLike;
    }

    public String getUsuarioLike() {
        return usuarioLike;
    }

    public void setUsuarioLike(String usuarioLike) {
        this.usuarioLike = usuarioLike;
    }
}
