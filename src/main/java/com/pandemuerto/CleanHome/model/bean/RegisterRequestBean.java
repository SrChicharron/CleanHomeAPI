package com.pandemuerto.CleanHome.model.bean;
import com.pandemuerto.CleanHome.model.entity.Rol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor


public class RegisterRequestBean  extends SignUpRequestBean {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastname;

    @NotBlank
    @Size(min = 10, max = 10)
    private String phonenumber;


    private String birthdate;


    public RegisterRequestBean(@NotBlank @Size(min = 3, max = 20) String username, @NotBlank @Size(min = 4, max = 50) String email, @NotBlank @Size(min = 6, max = 40) String password, Boolean enabled, List<Rol> authorities) {
        super(username, email, password, enabled, authorities);
    }
}
