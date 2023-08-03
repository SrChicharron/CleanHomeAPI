package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.model.entity.TipoPropiedad;
import com.pandemuerto.CleanHome.service.ICatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CatalogoController {
    @Autowired
    ICatalogoService catalogoService;
    @GetMapping("/getTipos")
    public ResponseEntity<?> gettipoPropiedad() {
        List<TipoPropiedad> list = catalogoService.getTipos();
        return  ResponseEntity.ok(list);
    }
}
