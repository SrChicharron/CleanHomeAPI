package com.pandemuerto.CleanHome.service.impl;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Postulacion;
import com.pandemuerto.CleanHome.model.entity.Propiedad;
import com.pandemuerto.CleanHome.repository.IPostulacionRepository;
import com.pandemuerto.CleanHome.repository.IPropiedadRepository;
import com.pandemuerto.CleanHome.service.IPostulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostulacionServiceImpl implements IPostulacionService {
    @Autowired
    private IPostulacionRepository postulacionRepository;

    @Autowired
    private IPropiedadRepository propiedadRepository;
    @Override
    public Postulacion addPostulacion(Postulacion postulacion) {
        return postulacionRepository.save(postulacion);
    }

    @Override
    public List<Postulacion> getPostulacionesByPublicacion(int idPublicacion) {
        List<Postulacion> postulacions = new ArrayList<>();
        postulacionRepository.findAllByPublicacionId(idPublicacion).forEach(postulacions::add);
        for(int i=0;i<postulacions.size();i++){
            Propiedad prop=propiedadRepository.findById(postulacions.get(i).getPublicacion().getPropiedad().getId()).orElse(new Propiedad());
            postulacions.get(i).setPropiedad(prop);
        }
        return postulacions;
    }
    @Override
    public List<Postulacion> getPostulacionesByCliente(int idCliente) {
        List<Postulacion> postulacions = new ArrayList<>();
        postulacionRepository.findAllByClienteId(idCliente).forEach(postulacions::add);
        for(int i=0;i<postulacions.size();i++){
            Propiedad prop=propiedadRepository.findById(postulacions.get(i).getPublicacion().getPropiedad().getId()).orElse(new Propiedad());
            postulacions.get(i).setPropiedad(prop);
        }
        return postulacions;
    }
    @Override
    public List<Postulacion> getPostulacionesByEmpleado(int idEmpleado) {
        List<Postulacion> postulacions = new ArrayList<>();
        postulacionRepository.findAllByEmpleadoId(idEmpleado).forEach(postulacions::add);
        for(int i=0;i<postulacions.size();i++){
            Propiedad prop=propiedadRepository.findById(postulacions.get(i).getPublicacion().getPropiedad().getId()).orElse(new Propiedad());
            postulacions.get(i).setPropiedad(prop);
        }
        return postulacions;
    }

    @Override
    public Postulacion updatePostulacion(Postulacion postulacion) {
        return postulacionRepository.save(postulacion);
    }

    @Override
    public MessageResponseBean deletePostulacion(int idPostulacion) {
        MessageResponseBean responseBean = new MessageResponseBean();
        postulacionRepository.deleteById(idPostulacion);
        responseBean.setMessage("Eliminacion correcta");
        return responseBean;
    }

    @Override
    public Postulacion findPostulacionById(int id){
        Postulacion postulacion=postulacionRepository.findById(id).orElse(null);
        return postulacion;
    }
}
