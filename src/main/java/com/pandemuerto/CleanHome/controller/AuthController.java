package com.pandemuerto.CleanHome.controller;

import com.pandemuerto.CleanHome.jwt.JwtUtils;
import com.pandemuerto.CleanHome.model.bean.request.ClientSignUpRequestBean;
import com.pandemuerto.CleanHome.model.bean.request.LoginRequestBean;
import com.pandemuerto.CleanHome.model.bean.request.SignUpRequestBean;
import com.pandemuerto.CleanHome.model.bean.response.JwtResponseBean;
import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.Usuario;
import com.pandemuerto.CleanHome.model.entity.User;
import com.pandemuerto.CleanHome.repository.IClienteRepository;
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
//@CrossOrigin(origins = {"http://localhost:3000","192.168.0.110:19000"}, maxAge = 3600)
@RestController
@RequestMapping("/ch/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IClienteRepository clienteRepository;

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

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(encoder.encode(signupRequest.getPassword()));
        user.setEmail(signupRequest.getEmail());
        user.setEnabled(signupRequest.getEnabled());
        user.setAuthorities(signupRequest.getAuthorities());
        usuarioRepository.save(user);
        return ResponseEntity.ok(new MessageResponseBean("Usuario registrado exitosamente!"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@Valid @RequestBody ClientSignUpRequestBean signupRequest) {
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

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(encoder.encode(signupRequest.getPassword()));
        user.setEmail(signupRequest.getEmail());
        user.setEnabled(signupRequest.getEnabled());
        user.setAuthorities(signupRequest.getAuthorities());
        usuarioRepository.save(user);
        Usuario usuario = new Usuario();
        usuario.setName(signupRequest.getName());
        usuario.setLastname(signupRequest.getLastName());
        usuario.setCellphone(signupRequest.getCellphone());
        usuario.setBirthday(signupRequest.getBirthday());
        usuario.setUsername(signupRequest.getUsername());
        clienteRepository.save(usuario);
        return ResponseEntity.ok(new MessageResponseBean("Registro Exitoso!"));
    }
}
