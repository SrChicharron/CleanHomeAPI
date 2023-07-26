package com.pandemuerto.CleanHome.model.bean;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponseBean {
    private String token;
    private String type = "Bearer";
    private String username;
    private String email;
    private List<String> roles;
}
