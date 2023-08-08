package com.pandemuerto.CleanHome.service.impl;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Propiedad;
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

    @Override
    public List<Propiedad> getPropiedades() {
        List<Propiedad> propiedades = new ArrayList<>();
        propiedadRepository.findAll().forEach(propiedades::add);
        return propiedades;
    }

    @Override
    public MessageResponseBean addPropiedad(Propiedad propiedad) {
        MessageResponseBean response = new MessageResponseBean();
        if(propiedadRepository.save(propiedad).getId()!=0){
            response.setMessage("Guardado correcto");
        }else{
            response.setMessage("Ocurrio un error al guardar en BD");
        }
        return response;
    }

    @Override
    public MessageResponseBean updatePropiedad(Propiedad propiedad) {
        MessageResponseBean response = new MessageResponseBean();
        if(propiedadRepository.save(propiedad).getId()!=0){
            response.setMessage("Actualizacion correcta");
        }else{
            response.setMessage("Ocurrio un error al actualizar en BD");
        }
        return response;
    }

    @Override
    public MessageResponseBean deletePropiedad(int id) {
        MessageResponseBean response = new MessageResponseBean();
        propiedadRepository.deleteById(id);
        response.setMessage("Eliminacion correcta");
        return response;
    }


}
