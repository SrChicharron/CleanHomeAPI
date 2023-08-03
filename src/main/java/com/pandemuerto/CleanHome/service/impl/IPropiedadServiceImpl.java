package com.pandemuerto.CleanHome.service.impl;

import com.pandemuerto.CleanHome.model.entity.Propiedad;
import com.pandemuerto.CleanHome.model.entity.TipoPropiedad;
import com.pandemuerto.CleanHome.repository.IPropiedadRepository;
import com.pandemuerto.CleanHome.repository.ITipoPropiedadRepository;
import com.pandemuerto.CleanHome.service.IPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPropiedadServiceImpl implements IPropiedadService {

    @Autowired
    IPropiedadRepository propiedadRepository;

    @Override
    public List<Propiedad> getPropiedades() {

        List<Propiedad> propiedades = new ArrayList<>();
        propiedadRepository.findAll().forEach(propiedades::add);
        return propiedades;
    }


}
