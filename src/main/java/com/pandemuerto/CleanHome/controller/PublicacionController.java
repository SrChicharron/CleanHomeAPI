package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Publicacion;
import com.pandemuerto.CleanHome.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ch/publicacion")
public class PublicacionController {
    @Autowired
    private IPublicacionService publicacionService;
    @GetMapping("/getPublicaciones")
    public ResponseEntity<?> getAllPublicaciones(){
        List<Publicacion> publicaciones = publicacionService.getPublicaciones();
        return ResponseEntity.ok(publicaciones);
    }


    @PostMapping("/addPublicacion")
    public ResponseEntity<?> addPublicacion(@RequestBody Publicacion publicacion){
        MessageResponseBean response = publicacionService.addPublicacion(publicacion);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updatePublicacion")
    public ResponseEntity<?> updatePublicacion(@RequestBody Publicacion publicacion){
        MessageResponseBean response = publicacionService.updatePublicacion(publicacion);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deletePublicacion")
    public ResponseEntity<?> deletePublicacion(@RequestBody Publicacion publicacion){
        MessageResponseBean response = publicacionService.deletePublicacion(publicacion.getId());
        return ResponseEntity.ok(response);
    }
}
