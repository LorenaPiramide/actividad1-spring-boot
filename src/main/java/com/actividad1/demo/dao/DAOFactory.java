package com.actividad1.demo.dao;

import com.actividad1.demo.dao.post.DAOPost;
import com.actividad1.demo.dao.post.DAOPostRAM;
import com.actividad1.demo.dao.usuario.DAOUsuario;
import com.actividad1.demo.dao.usuario.DAOUsuarioRAM;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOUsuario daoUsuario;
    private DAOPost daoPost;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOUsuario getDaoUsuario(){
        if(this.daoUsuario == null){
            this.daoUsuario = new DAOUsuarioRAM();
        }
        return this.daoUsuario;
    }

    public DAOPost getDaoPost(){
        if(this.daoPost == null){
            this.daoPost = new DAOPostRAM();
        }
        return daoPost;
    }
}
