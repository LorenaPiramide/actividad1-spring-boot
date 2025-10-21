package com.actividad1.demo.entidades;

public class Repost {
    private int idPostRepost;
    private String usuarioRepost;

    public Repost(int idPostRepost, String usuarioRepost) {
        this.idPostRepost = idPostRepost;
        this.usuarioRepost = usuarioRepost;
    }

    public int getIdPostRepost() {
        return idPostRepost;
    }

    public void setIdPostRepost(int idPostRepost) {
        this.idPostRepost = idPostRepost;
    }

    public String getUsuarioRepost() {
        return usuarioRepost;
    }

    public void setUsuarioRepost(String usuarioRepost) {
        this.usuarioRepost = usuarioRepost;
    }
}
