package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.model.bean.request.ServiceRequestBean;
import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Servicio;
import com.pandemuerto.CleanHome.repository.IServicioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ch/servicio")
public class ServicioController {

        @Autowired
    public IServicioRepository servicioRepository;

    @GetMapping("/getServicios")
    public ResponseEntity<?> getAllServicios() {
        List<Servicio> list = servicioRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getServicio/{id}")
    public ResponseEntity<?> getServicio(@PathVariable Long id){
        Servicio servicio = servicioRepository.findById(id).orElse(null);
        if (servicio==null){
            return ResponseEntity.badRequest().body(new MessageResponseBean("El servicio no existe."));
        } else {
            return ResponseEntity.ok(servicio);
        }
    }

    @PostMapping("/agregarServicio")
    public ResponseEntity<?> agregarService(@Valid @RequestBody ServiceRequestBean serviceRequest){
        Servicio servicio = new Servicio();
        servicio.setNombre(serviceRequest.getNombre());
        servicio.setDescripcion(serviceRequest.getDescripcion());
        servicioRepository.save(servicio);

        return ResponseEntity.ok(new MessageResponseBean("Servicio agregado con exito!"));

    }

    @PutMapping("/editarServicio/{id}")
    public ResponseEntity<?> editarService(@PathVariable Long id, @Valid @RequestBody ServiceRequestBean serviceRequest) {
        Servicio servicio = servicioRepository.findById(id).orElse(null);
//        System.out.print(servicio);
        if (servicio == null) {
            return ResponseEntity.badRequest().body(new MessageResponseBean("El servicio no existe."));
        } else {

            servicio.setNombre(serviceRequest.getNombre());
            servicio.setDescripcion(serviceRequest.getDescripcion());

            servicioRepository.save(servicio);

            return ResponseEntity.ok(new MessageResponseBean("Servicio editado con éxito."));
        }
    }


    @DeleteMapping("/eliminarServicio/{id}")
    public ResponseEntity<?> eliminarService(@PathVariable Long id,@Valid Servicio serviceRequest){
        Servicio servicio = servicioRepository.findById(id).orElse(null);

        if(servicio==null){
            return ResponseEntity.badRequest().body(new MessageResponseBean("El servicio no existe."));
        }else {

            servicioRepository.delete(serviceRequest);
            return ResponseEntity.ok(new MessageResponseBean("Servicio eliminado con éxito."));
        }
    }
}
