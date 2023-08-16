package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "POSTULACION")
@Table(name = "POSTULACION")
public class Postulacion implements Serializable {
    @Serial
    private static final long serialVersionUID = -2396336427200222457L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_PUBLICACION")
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "ID_EMPLEADO")
    private Usuario empleado;

    @Basic(optional = true)
    @Column(name = "ESTATUS")
    private String estatus;

    @Transient
    private Propiedad propiedad;
}
