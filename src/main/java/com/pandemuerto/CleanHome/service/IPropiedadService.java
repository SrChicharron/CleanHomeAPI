package com.pandemuerto.CleanHome.service;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Propiedad;

import java.util.List;

public interface IPropiedadService {
    List<Propiedad> getPropiedades();

    MessageResponseBean addPropiedad(Propiedad propiedad);

    MessageResponseBean updatePropiedad(Propiedad propiedad);

    MessageResponseBean deletePropiedad(int id);

}
