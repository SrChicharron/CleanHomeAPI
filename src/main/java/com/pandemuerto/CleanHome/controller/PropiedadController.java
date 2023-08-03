package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.model.entity.Propiedad;
import com.pandemuerto.CleanHome.model.entity.TipoPropiedad;
import com.pandemuerto.CleanHome.service.IPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ch/auth")
public class PropiedadController {

    @Autowired
    IPropiedadService propiedadService;

    @GetMapping("/getPropiedades")
    public ResponseEntity<?> getAllClientes() {
        List<Propiedad> list = propiedadService.getPropiedades();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/getTipos")
    public ResponseEntity<?> gettipoPropiedad() {
        List<TipoPropiedad> list = propiedadService.getTipos();
        return  ResponseEntity.ok(list);
    }

}
