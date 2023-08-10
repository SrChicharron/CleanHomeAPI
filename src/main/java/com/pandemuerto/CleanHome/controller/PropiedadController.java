package com.pandemuerto.CleanHome.controller;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.ComprobantePropiedad;
import com.pandemuerto.CleanHome.model.entity.FotoPropiedad;
import com.pandemuerto.CleanHome.model.entity.Propiedad;
import com.pandemuerto.CleanHome.model.entity.Publicacion;
import com.pandemuerto.CleanHome.service.IFileTransferService;
import com.pandemuerto.CleanHome.service.IPropiedadService;
import com.pandemuerto.CleanHome.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ch/propiedad")
public class PropiedadController {

    @Autowired
    IPropiedadService propiedadService;

    @Autowired
    IFileTransferService fileTransferService;

    private Utils utils= new Utils();

    @GetMapping("/getPropiedades")
    public ResponseEntity<?> getAllClientes(@RequestParam int idCliente) {
        List<Propiedad> list = propiedadService.getPropiedades();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/addPropiedad")
    public ResponseEntity<?> addPropiedad(@RequestBody Propiedad propiedad){
        Propiedad origin=propiedadService.findPropiedadById(propiedad.getId());
        propiedad.setFoto(origin.getFoto());
        propiedad.setComprobante(origin.getComprobante());
        Propiedad response = propiedadService.addPropiedad(propiedad);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addFotos")
    public ResponseEntity<?> addFotos(
            @RequestParam("fotos") MultipartFile[] fotos,
            @RequestParam("idPropiedad") int idpropiedad){
        List<FotoPropiedad> fotoPropiedads = new ArrayList<>();
        Map<String,MultipartFile> mapFotos = new HashMap<>();
        for (MultipartFile foto : fotos) {
            String name =utils.getUUIDName(foto.getOriginalFilename());
            mapFotos.put(name,foto);
            FotoPropiedad fotoUpd = new FotoPropiedad();
            fotoUpd.setFoto(name);
            fotoUpd.setIdPropiedad(idpropiedad);
            fotoPropiedads.add(fotoUpd);
        }
        try {
            fileTransferService.uploadImage(mapFotos);
        } catch (JSchException e) {
            e.printStackTrace();
            MessageResponseBean responseBean = new MessageResponseBean("Error al  cargar las imagenes");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBean);
        }
        MessageResponseBean response = propiedadService.addFotos(fotoPropiedads,idpropiedad);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addComprobantes")
    public ResponseEntity<?> addComprobantes(
            @RequestParam("comprobantes") MultipartFile[] comprobantes,
            @RequestParam("idPropiedad") int idpropiedad){
        List<ComprobantePropiedad> comprobantePropiedads=new ArrayList<>();
        Map<String,MultipartFile> mapComps = new HashMap<>();
        for (MultipartFile comprobante : comprobantes) {
            String name =utils.getUUIDName(comprobante.getOriginalFilename());
            mapComps.put(name,comprobante);
            ComprobantePropiedad comprobanteUpd = new ComprobantePropiedad();
            comprobanteUpd.setComprobante(name);
            comprobanteUpd.setIdPropiedad(idpropiedad);
            comprobantePropiedads.add(comprobanteUpd);
        }
        try {
            fileTransferService.uploadImage(mapComps);
        } catch (JSchException e) {
            e.printStackTrace();
            MessageResponseBean responseBean = new MessageResponseBean("Error al  cargar las imagenes");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBean);
        }
        MessageResponseBean response = propiedadService.addComprobantes(comprobantePropiedads,idpropiedad);
        return ResponseEntity.ok(response);
    }

}
