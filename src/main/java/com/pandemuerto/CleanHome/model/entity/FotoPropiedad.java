package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity(name = "FOTO_PROPIEDAD")
@Table(name = "FOTO_PROPIEDAD")
public class FotoPropiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Basic(optional = false)
    private int id;

    @Column(name = "FOTO")
    @NotEmpty
    @Basic(optional = false)
    private String foto;

    @Column(name = "ID_PROPIEDAD")
    @Basic(optional = false)
    private int idPropiedad;
}
