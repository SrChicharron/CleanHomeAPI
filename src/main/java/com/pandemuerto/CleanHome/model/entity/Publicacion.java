package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "PUBLICACION")
@Table(name = "PUBLICACION")
public class Publicacion implements Serializable {
    @Serial
    private static final long serialVersionUID = -5086992860957266637L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHA")
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "PAGO_OFRECIDO")
    private Float pagoOfrecido;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "ID_PROPIEDAD")
    private Propiedad propiedad;
    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO")
    private Servicio servicio;
}
