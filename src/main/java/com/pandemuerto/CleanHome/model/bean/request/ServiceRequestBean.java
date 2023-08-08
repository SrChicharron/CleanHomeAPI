package com.pandemuerto.CleanHome.model.bean.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceRequestBean {

    private String nombre;


    private String descripcion;
}
