package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Resena;
import com.pandemuerto.CleanHome.service.IResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ch/resena")
public class ResenaController {
    @Autowired
    private IResenaService resenaService;
    @GetMapping("/getResenasPublicacion")
    public ResponseEntity<?> getResenasPublicacion(@RequestParam int idPublicacion){
        List<Resena> resenas = resenaService.getResenaByPublicacion(idPublicacion);
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/getResenasEvaluado")
    public ResponseEntity<?> getResenasEvaluado(@RequestParam int idEvaluado){
        List<Resena> resenas = resenaService.getResenaByEvaluado(idEvaluado);
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/getResenasEvaluador")
    public ResponseEntity<?> getResenasEvaluador(@RequestParam int idEvaluador){
        List<Resena> resenas = resenaService.getResenaByEvaluador(idEvaluador);
        return ResponseEntity.ok(resenas);
    }

    @PostMapping("/addResena")
    public ResponseEntity<?> addPostulacion(@RequestBody Resena resena){
        Resena response = resenaService.addResena(resena);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateResena")
    public ResponseEntity<?> updateResena(@RequestBody Resena resena){
        Resena response = resenaService.updateResena(resena);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/deleteResena")
    public ResponseEntity<?> deletePostulacion(@RequestParam int idResena){
        MessageResponseBean response = resenaService.deleteResena(idResena);
        return ResponseEntity.ok(response);
    }
}
