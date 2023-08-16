package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "USUARIO")
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = -6673078097350304094L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Basic(optional = false)
    private int id;
    @Column(name = "NAME")
    @NotEmpty
    @Basic(optional = false)
    private String name;
    @Column(name = "LASTNAME")
    @NotEmpty
    @Basic(optional = false)
    private String lastname;
    @Column(name = "CELLPHONE")
    @NotEmpty
    @Basic(optional = false)
    private String cellphone;
    @Column(name = "BIRTHDAY")
    @NotEmpty
    @Basic(optional = false)
    private String birthday;
    @Column(name = "USERNAME")
    @NotEmpty
    @Basic(optional = false)
    private String username;

    @Column(name = "DESCRIPCION")
    @Basic(optional = true)
    private String descripcion;

    @Column(name = "FOTO")
    @Basic(optional = true)
    private String foto;

    @Column(name = "COMPROBANTE")
    @Basic(optional = true)
    private String comprobante;
}
