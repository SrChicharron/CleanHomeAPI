package com.pandemuerto.CleanHome.service.impl;

import com.pandemuerto.CleanHome.model.entity.Estado;
import com.pandemuerto.CleanHome.model.entity.TipoPropiedad;
import com.pandemuerto.CleanHome.repository.IEstadoRepository;
import com.pandemuerto.CleanHome.repository.ITipoPropiedadRepository;
import com.pandemuerto.CleanHome.service.ICatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogoServiceImpl implements ICatalogoService {
    @Autowired
    private ITipoPropiedadRepository tipoPropiedadRepository;

    @Autowired
    private IEstadoRepository estadoRepository;
    @Override
    public List<TipoPropiedad> getTipos() {
        List<TipoPropiedad> tipos = new ArrayList<>();
        tipoPropiedadRepository.findAll().forEach(tipos::add);
        return tipos;
    }

    @Override
    public List<Estado> getEstados() {
        List<Estado> estados = new ArrayList<>();
        estadoRepository.findAll().forEach(estados::add);
        return estados;
    }
}
