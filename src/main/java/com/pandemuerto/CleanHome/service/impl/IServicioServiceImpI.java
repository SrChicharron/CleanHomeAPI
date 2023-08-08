package com.pandemuerto.CleanHome.service.impl;

import com.pandemuerto.CleanHome.model.entity.Servicio;
import com.pandemuerto.CleanHome.repository.IServicioRepository;
import com.pandemuerto.CleanHome.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IServicioServiceImpI implements IServicioService {
    @Autowired
    IServicioRepository servicioRepository;

    @Override
    public List<Servicio> getAllServicios(){
        List<Servicio> servicios = new ArrayList<>();
        servicioRepository.findAll().forEach(servicios::add);
        return servicios;
    }

}
