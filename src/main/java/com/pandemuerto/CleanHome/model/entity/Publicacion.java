package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

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
    @Basic(optional = false)
    @Column(name = "PAGO_OFRECIDO")
    private Float pagoOfrecido;
    @Basic(optional = false)
    @Column(name = "ID_TIPO_SERVICIO")
    private int idTipoServicio;
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private int idUsuario;
}
