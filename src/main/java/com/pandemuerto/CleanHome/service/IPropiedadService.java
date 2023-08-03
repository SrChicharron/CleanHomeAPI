package com.pandemuerto.CleanHome.service;

import com.pandemuerto.CleanHome.model.entity.Propiedad;
import com.pandemuerto.CleanHome.model.entity.TipoPropiedad;

import java.util.List;

public interface IPropiedadService {
    List<Propiedad> getPropiedades();

    List<TipoPropiedad> getTipos();
}
