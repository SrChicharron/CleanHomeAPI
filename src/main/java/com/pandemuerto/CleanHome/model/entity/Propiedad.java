package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "PROPIEDAD")
@Table(name = "PROPIEDAD")
public class Propiedad implements Serializable {

    @Serial
    private static final long serialVersionUID = 3072813742088588617L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = true)
    @Column(name = "FOTO")
    private String foto;
    @Basic(optional = true)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = true)
    @Column(name = "CALLE")
    private String calle;
    @Basic(optional = true)
    @Column(name = "NUMERO_EXTERIOR")
    private String numeroExt;
    @Basic(optional = true)
    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;
    @Basic(optional = true)
    @Column(name = "COLONIA")
    private String colonia;
    @Basic(optional = true)
    @Column(name = "REFERENCIAS")
    private String referencias;
    @Basic(optional = true)
    @Column(name = "COMPROBANTE")
    private String comprobante;
    @Basic(optional = true)
    @Column(name = "ID_ESTADO")
    private int idEstado;
    @Basic(optional = true)
    @Column(name = "ID_TIPO")
    private int idTipo;

}
