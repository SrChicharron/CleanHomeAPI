package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.model.entity.Estado;
import com.pandemuerto.CleanHome.model.entity.TipoPropiedad;
import com.pandemuerto.CleanHome.service.ICatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ch/catalogo")
public class CatalogoController {
    @Autowired
    ICatalogoService catalogoService;
    @GetMapping("/getTipos")
    public ResponseEntity<?> getTipoPropiedad() {
        List<TipoPropiedad> list = catalogoService.getTipos();
        return  ResponseEntity.ok(list);
    }

    @GetMapping("/getEstados")
    public ResponseEntity<?> getEstados() {
        List<Estado> list = catalogoService.getEstados();
        return  ResponseEntity.ok(list);
    }
}
