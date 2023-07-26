package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.jwt.JwtUtils;
import com.pandemuerto.CleanHome.model.bean.JwtResponseBean;
import com.pandemuerto.CleanHome.model.bean.LoginRequestBean;
import com.pandemuerto.CleanHome.model.bean.MessageResponseBean;
import com.pandemuerto.CleanHome.model.bean.SignUpRequestBean;
import com.pandemuerto.CleanHome.model.entity.Usuario;
import com.pandemuerto.CleanHome.repository.IRolRepository;
import com.pandemuerto.CleanHome.repository.IUsuarioRepository;
import com.pandemuerto.CleanHome.service.impl.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ch/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IRolRepository rolRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestBean loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        JwtResponseBean jwtResponseBean = new JwtResponseBean();
        jwtResponseBean.setToken(jwt);
        jwtResponseBean.setUsername(userDetails.getUsername());
        jwtResponseBean.setEmail(userDetails.getEmail());
        jwtResponseBean.setRoles(roles);
        return ResponseEntity.ok(jwtResponseBean);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequestBean signupRequest) {
        if (usuarioRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponseBean("Error: Username ya registrado!"));
        }

        if (usuarioRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponseBean("Error: Email ya Registrado!"));
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(signupRequest.getUsername());
        usuario.setPassword(encoder.encode(signupRequest.getPassword()));
        usuario.setEmail(signupRequest.getEmail());
        usuario.setEnabled(signupRequest.getEnabled());
        usuario.setAuthorities(signupRequest.getAuthorities());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new MessageResponseBean("Usuario registrado exitosamente!"));
    }
}
