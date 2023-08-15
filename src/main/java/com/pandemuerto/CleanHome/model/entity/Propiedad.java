package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

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
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "CALLE")
    private String calle;
    @Basic(optional = false)
    @Column(name = "NUMERO_EXTERIOR")
    private String numeroExt;
    @Basic(optional = false)
    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;
    @Basic(optional = false)
    @Column(name = "COLONIA")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "REFERENCIAS")
    private String referencias;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private String estatus;
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PROPIEDAD")
    private TipoPropiedad tipoPropiedad;
    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private int idUsuario;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PROPIEDAD")
    private List<FotoPropiedad> foto;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PROPIEDAD")
    private List<ComprobantePropiedad> comprobante;

}
