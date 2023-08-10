package com.pandemuerto.CleanHome.service.impl;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.ComprobantePropiedad;
import com.pandemuerto.CleanHome.model.entity.FotoPropiedad;
import com.pandemuerto.CleanHome.model.entity.Propiedad;
import com.pandemuerto.CleanHome.repository.IComprobantePropiedadRepository;
import com.pandemuerto.CleanHome.repository.IFotoPropiedadRepository;
import com.pandemuerto.CleanHome.repository.IPropiedadRepository;
import com.pandemuerto.CleanHome.service.IPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropiedadServiceImpl implements IPropiedadService {

    @Autowired
    IPropiedadRepository propiedadRepository;

    @Autowired
    IFotoPropiedadRepository fotoPropiedadRepository;

    @Autowired
    IComprobantePropiedadRepository comprobantePropiedadRepository;

    @Override
    public List<Propiedad> getPropiedades() {
        List<Propiedad> propiedades = new ArrayList<>();
        propiedadRepository.findAll().forEach(propiedades::add);
        return propiedades;
    }

    @Override
    public Propiedad addPropiedad(Propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    @Override
    public Propiedad updatePropiedad(Propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    @Override
    public MessageResponseBean deletePropiedad(int id) {
        MessageResponseBean response = new MessageResponseBean();
        propiedadRepository.deleteById(id);
        response.setMessage("Eliminacion correcta");
        return response;
    }

    @Override
    public Propiedad findPropiedadById(int id) {
        Propiedad propiedad= new Propiedad();
        propiedad=propiedadRepository.findById(id).orElse(new Propiedad());
        return propiedad;
    }

    @Override
    public List<Propiedad> findPropiedadesByIdUsuario(int idUsuario) {
        List<Propiedad> propiedads = new ArrayList<>();
        propiedads = propiedadRepository.findAllByIdUsuario(idUsuario);
        return propiedads;
    }

    @Override
    public MessageResponseBean addPictures(List<FotoPropiedad> fotos, List<ComprobantePropiedad> comprobantes) {
        MessageResponseBean response = new MessageResponseBean();
        fotoPropiedadRepository.saveAll(fotos);
        comprobantePropiedadRepository.saveAll(comprobantes);
        response.setMessage("Guardado de imagenes exitoso");
        return response;
    }


}
