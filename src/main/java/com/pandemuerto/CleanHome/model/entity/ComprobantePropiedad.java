package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity(name = "COMPROBANTE_PROPIEDAD")
@Table(name = "COMPROBANTE_PROPIEDAD")
public class ComprobantePropiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Basic(optional = false)
    private int id;

    @Column(name = "COMPROBANTE")
    @NotEmpty
    @Basic(optional = false)
    private String comprobante;

    @Column(name = "ID_PROPIEDAD")
    @Basic(optional = false)
    private int idPropiedad;
}
