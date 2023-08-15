package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "RESENA")
@Table(name = "RESENA")
public class Resena implements Serializable {
    @Serial
    private static final long serialVersionUID = 1397869520025092892L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_PUBLICACION")
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "ID_EVALUADO")
    private Usuario evaluado;

    @ManyToOne
    @JoinColumn(name = "ID_EVALUADOR")
    private Usuario evaluador;

    @Basic(optional = false)
    @Column(name = "CALIFICACION")
    private int calificacion;

    @Basic(optional = true)
    @Column(name = "COMENTARIOS")
    private String comentarios;
}
