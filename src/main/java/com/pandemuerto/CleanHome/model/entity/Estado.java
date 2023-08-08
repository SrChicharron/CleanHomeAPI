package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "ESTADO")
@Table( name = "ESTADO")
public class Estado implements Serializable {

    @Serial
    private static final long serialVersionUID = 3376968288732188534L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
}
