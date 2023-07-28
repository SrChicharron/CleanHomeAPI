package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
@Entity(name = "DATOSREGISTER")
@Table(name = "DATOSREGISTER")
public class DatosRegister {


    public static final String TABLE_NAME= "DATOSREGISTER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Basic(optional = false)
    private int id;



    @Column(name = "USERNAME")
    @NotEmpty
    @Basic(optional = false)
    private String username;


    @Column(name = "NAME")
    @NotEmpty
    @Basic(optional = false)
    private String name;

    @Column(name = "LASTNAME")
    @NotEmpty
    @Basic(optional = false)
    private String lastname;

    @Column(name = "PHONENUMBER")
    @NotEmpty
    @Basic(optional = false)
    private String phonenumber;

    @Column(name = "BIRTHDATE")
    @Basic(optional = false)
    private String birthdate;
}
