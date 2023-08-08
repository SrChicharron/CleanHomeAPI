package com.pandemuerto.CleanHome.model.bean.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestBean {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
