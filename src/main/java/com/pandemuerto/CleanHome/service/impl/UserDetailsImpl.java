package com.pandemuerto.CleanHome.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pandemuerto.CleanHome.model.entity.Rol;
import com.pandemuerto.CleanHome.model.entity.User;
import com.pandemuerto.CleanHome.model.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private Collection<? extends GrantedAuthority> informacion;

    public UserDetailsImpl(String username, String email, String password,
                           Collection<? extends GrantedAuthority> authorities,
                           Collection<? extends GrantedAuthority> informacion) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.informacion = informacion;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Rol rol:user.getAuthorities()){
            authorities.add(new SimpleGrantedAuthority(rol.getAuthority()));
        }

        List<GrantedAuthority> informacion = new ArrayList<>();
        for (Usuario usuario:user.getInformacion()){
            informacion.add(new SimpleGrantedAuthority(usuario.getUsername()));
        }

        return new UserDetailsImpl(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities,informacion);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(username, user.username);
    }
}
