package com.pandemuerto.CleanHome.service;

import com.pandemuerto.CleanHome.model.entity.Estado;
import com.pandemuerto.CleanHome.model.entity.TipoPropiedad;

import java.util.List;

public interface ICatalogoService {
    List<TipoPropiedad> getTipos();

    List<Estado> getEstados();
}
