package com.pandemuerto.CleanHome.service.impl;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Publicacion;
import com.pandemuerto.CleanHome.repository.IPublicacionRepository;
import com.pandemuerto.CleanHome.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacionServiceImpl implements IPublicacionService {

    @Autowired
    private IPublicacionRepository publicacionRepository;
    @Override
    public List<Publicacion> getPublicaciones() {
        List<Publicacion> publicaciones = new ArrayList<>();
        publicacionRepository.findAll().forEach(publicaciones::add);
        return publicaciones;
    }

    @Override
    public MessageResponseBean addPublicacion(Publicacion publicacion) {
        MessageResponseBean response = new MessageResponseBean();
        if(publicacionRepository.save(publicacion).getId()!=0){
            response.setMessage("Guardado correcto");
        }else{
            response.setMessage("Ocurrio un error al guardar en BD");
        }
        return response;
    }

    @Override
    public MessageResponseBean updatePublicacion(Publicacion publicacion) {
        MessageResponseBean response = new MessageResponseBean();
        if(publicacionRepository.save(publicacion).getId()!=0){
            response.setMessage("Actualizacion correcta");
        }else{
            response.setMessage("Ocurrio un error al Actualizar en BD");
        }
        return response;
    }

    @Override
    public MessageResponseBean deletePublicacion(int id) {
        MessageResponseBean response = new MessageResponseBean();
        publicacionRepository.deleteById(id);
        response.setMessage("Eliminacion correcta");
        return response;
    }
}
