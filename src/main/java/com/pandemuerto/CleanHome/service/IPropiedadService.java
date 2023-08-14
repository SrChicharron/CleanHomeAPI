package com.pandemuerto.CleanHome.service;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.ComprobantePropiedad;
import com.pandemuerto.CleanHome.model.entity.FotoPropiedad;
import com.pandemuerto.CleanHome.model.entity.Propiedad;

import java.util.List;

public interface IPropiedadService {
    List<Propiedad> getPropiedades();

    Propiedad addPropiedad(Propiedad propiedad);

    Propiedad updatePropiedad(Propiedad propiedad);

    MessageResponseBean deletePropiedad(int id);

    Propiedad findPropiedadById(int id);

    List<Propiedad> findPropiedadesByIdUsuario(int idUsuario);

    MessageResponseBean addFotos(List<FotoPropiedad> fotos, int idPropiedad);

    MessageResponseBean addComprobantes(List<ComprobantePropiedad> comprobantes, int idPropiedad);

}
