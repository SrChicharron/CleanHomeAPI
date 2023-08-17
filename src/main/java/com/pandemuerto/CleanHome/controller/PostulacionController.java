package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Postulacion;
import com.pandemuerto.CleanHome.service.IPostulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ch/postulacion")
public class PostulacionController {

    @Autowired
    private IPostulacionService postulacionService;

    @GetMapping("/getPostulaciones")
    public ResponseEntity<?> getPostulaciones(@RequestParam int idPublicacion){
        List<Postulacion> postulaciones = postulacionService.getPostulacionesByPublicacion(idPublicacion);
        return ResponseEntity.ok(postulaciones);
    }

    @GetMapping("/getPostulacionesCliente")
    public ResponseEntity<?> getPostulacionesCliente(@RequestParam int idCliente){
        List<Postulacion> postulaciones = postulacionService.getPostulacionesByCliente(idCliente);
        return ResponseEntity.ok(postulaciones);
    }

    @GetMapping("/getPostulacionesEmpleado")
    public ResponseEntity<?> getPostulacionesEmpleado(@RequestParam int idEmpleado){
        List<Postulacion> postulaciones = postulacionService.getPostulacionesByEmpleado(idEmpleado);
        return ResponseEntity.ok(postulaciones);
    }

    @PostMapping("/addPostulacion")
    public ResponseEntity<?> addPostulacion(@RequestBody Postulacion postulacion){
        Postulacion response = postulacionService.addPostulacion(postulacion);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updatePostulacion")
    public ResponseEntity<?> updatePostulacion(@RequestBody Postulacion postulacion){
        Postulacion response = postulacionService.updatePostulacion(postulacion);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deletePostulacion")
    public ResponseEntity<?> deletePostulacion(@RequestParam int idPostulacion){
        MessageResponseBean response = postulacionService.deletePostulacion(idPostulacion);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/editarEstatusPostulacion")
    public ResponseEntity<?> editarEstatusPostulacion(@RequestParam int id,@RequestBody Postulacion postulacionRequest){
        Postulacion postulacion = postulacionService.findPostulacionById(id);
        if(postulacion!=null){
            postulacion.setEstatus(postulacionRequest.getEstatus());
            postulacionService.updatePostulacion(postulacion);
            return ResponseEntity.ok(new MessageResponseBean("El estatus de la postulacion fue editado con éxito."));
        }else{
            return ResponseEntity.badRequest().body(new MessageResponseBean("La postulacion no existe."));
        }
    }
}
