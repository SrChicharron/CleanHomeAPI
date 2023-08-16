package com.pandemuerto.CleanHome.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "USER")
@Table(name = "USER")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 270508607443436466L;

    @Id
    @Column(name = "USERNAME")
    @NotEmpty
    @Basic(optional = false)
    private String username;

    @Column(name = "PASSWORD")
    @NotEmpty
    @Basic(optional = false)
    private String password;

    @Column(name = "EMAIL")
    @NotEmpty
    @Basic(optional = false)
    private String email;

    @Column(name = "ENABLED")
    @Basic(optional = false)
    private Boolean enabled;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USERNAME")
    private List<Rol> authorities;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USERNAME")
    private List<Usuario> informacion;
}

