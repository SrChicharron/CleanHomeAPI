package com.pandemuerto.CleanHome.model.bean.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponseBean {
    private String token;
    private String type = "Bearer";
    private String username;
    private String email;
    private String rol;
    private int idUsuario;
}
