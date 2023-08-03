package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity (name = "TIPOPROPIEDAD")
@Table( name = "TIPOPROPIRDAD")

public class TipoPropiedad implements  Serializable{

    @Serial
    private static final long serialVersionUID = -5990070504454631807L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = true)
    @Column(name = "TIPOCASA")
    private String tipo;
}
