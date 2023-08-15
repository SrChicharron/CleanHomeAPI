package com.pandemuerto.CleanHome.service.impl;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Resena;
import com.pandemuerto.CleanHome.repository.IResenaRepository;
import com.pandemuerto.CleanHome.service.IResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResenaServiceImpl implements IResenaService {
    @Autowired
    IResenaRepository resenaRepository;
    @Override
    public Resena addResena(Resena resena) {
        return resenaRepository.save(resena);
    }

    @Override
    public Resena updateResena(Resena resena) {
        return resenaRepository.save(resena);
    }

    @Override
    public MessageResponseBean deleteResena(int idResena) {
        MessageResponseBean response = new MessageResponseBean();
        resenaRepository.deleteById(idResena);
        response.setMessage("Eliminacion Correcta");
        return response;
    }

    @Override
    public List<Resena> getResenaByEvaluado(int idEvaluado) {
        List<Resena> response= new ArrayList<>();
        resenaRepository.findAllByEvaluadoId(idEvaluado).forEach(response::add);
        return response;
    }

    @Override
    public List<Resena> getResenaByEvaluador(int idEvaluador) {
        List<Resena> response= new ArrayList<>();
        resenaRepository.findAllByEvaluadorId(idEvaluador).forEach(response::add);
        return response;
    }

    @Override
    public List<Resena> getResenaByPublicacion(int idPublicacion) {
        List<Resena> response= new ArrayList<>();
        resenaRepository.findAllByPublicacionId(idPublicacion).forEach(response::add);
        return response;
    }
}
