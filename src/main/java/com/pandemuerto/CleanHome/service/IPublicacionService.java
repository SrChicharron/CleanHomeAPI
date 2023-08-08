package com.pandemuerto.CleanHome.service;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Publicacion;

import java.util.List;

public interface IPublicacionService {

    List<Publicacion> getPublicaciones();
    MessageResponseBean addPublicacion(Publicacion publicacion);
    MessageResponseBean updatePublicacion(Publicacion publicacion);
    MessageResponseBean deletePublicacion(int id);
}
