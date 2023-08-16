package com.pandemuerto.CleanHome.controller;

import com.jcraft.jsch.JSchException;
import com.pandemuerto.CleanHome.jwt.JwtUtils;
import com.pandemuerto.CleanHome.model.bean.request.ClientSignUpRequestBean;
import com.pandemuerto.CleanHome.model.bean.request.LoginRequestBean;
import com.pandemuerto.CleanHome.model.bean.request.SignUpRequestBean;
import com.pandemuerto.CleanHome.model.bean.response.JwtResponseBean;
import com.pandemuerto.CleanHome.model.bean.response.MessageResponseBean;
import com.pandemuerto.CleanHome.model.entity.*;
import com.pandemuerto.CleanHome.repository.IUsuarioRepository;
import com.pandemuerto.CleanHome.repository.IUserRepository;
import com.pandemuerto.CleanHome.service.IFileTransferService;
import com.pandemuerto.CleanHome.service.impl.UserDetailsImpl;
import com.pandemuerto.CleanHome.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//@CrossOrigin(origins = {"http://localhost:3000","192.168.0.110:19000"}, maxAge = 3600)
@RestController
@RequestMapping("/ch/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IFileTransferService fileTransferService;

    private Utils utils= new Utils();

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
        jwtResponseBean.setRol(roles.get(0));
        if(jwtResponseBean.getRol().equals("ROLE_EMPLEADO")||jwtResponseBean.getRol().equals("ROLE_CLIENTE")){
        Usuario usuario= usuarioRepository.findByUsername(userDetails.getUsername());
        jwtResponseBean.setIdUsuario(usuario.getId());
        }
        return ResponseEntity.ok(jwtResponseBean);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequestBean signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponseBean("Error: Username ya registrado!"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
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
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponseBean("Usuario registrado exitosamente!"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@Valid @RequestBody ClientSignUpRequestBean signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponseBean("Error: Username ya registrado!"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
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
        userRepository.save(user);
        Usuario usuario = new Usuario();
        usuario.setName(signupRequest.getName());
        usuario.setLastname(signupRequest.getLastName());
        usuario.setCellphone(signupRequest.getCellphone());
        usuario.setBirthday(signupRequest.getBirthday());
        usuario.setUsername(signupRequest.getUsername());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new MessageResponseBean("Registro Exitoso!"));
    }

    @GetMapping("/getUsuario/{username}")
    public ResponseEntity<?> getInfoUsuario(@PathVariable String username){
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/editarInfoUser/{username}")
    public ResponseEntity<?> updateInfoUser(@PathVariable String username, @RequestBody Usuario usuRequest){
        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario != null) {
            usuario.setName(usuRequest.getName());
            usuario.setLastname(usuRequest.getLastname());
            usuario.setCellphone(usuRequest.getCellphone());
            usuario.setDescripcion(usuRequest.getDescripcion());
            usuarioRepository.save(usuario);
            return ResponseEntity.ok(new MessageResponseBean("La informacion del usuario se ha actualizado con exito"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getUsuarios")
    public ResponseEntity<?> getNewUsers() {
        List<User> list = userRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/editarEstatusUser/{username}")
    public ResponseEntity<?> updateStatusUser(@PathVariable String username, @RequestBody User userRequest) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));


            user.setEnabled(userRequest.getEnabled());
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponseBean("El estatus del usuario fue editado con éxito."));

    }

    @PostMapping("/addFoto")
    public ResponseEntity<?> addFoto(
            @RequestParam("foto") MultipartFile foto,
            @RequestParam("comprobante") MultipartFile comprobante,
            @RequestParam("idUsuario") int idUsuario){
        Usuario usuario= usuarioRepository.findById(idUsuario).orElse(new Usuario());
        String nombreFoto =utils.getUUIDName(foto.getOriginalFilename());
        String nombreComprobante =utils.getUUIDName(foto.getOriginalFilename());
        try {
            fileTransferService.uploadImage(foto,nombreFoto);
            fileTransferService.uploadImage(comprobante,nombreComprobante);
        } catch (JSchException e) {
            e.printStackTrace();
            MessageResponseBean responseBean = new MessageResponseBean("Error al  cargar las imagenes");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBean);
        }
        usuario.setFoto(nombreFoto);
        usuario.setComprobante(nombreComprobante);
        Usuario updated=usuarioRepository.save(usuario);
        return ResponseEntity.ok(updated);
    }

}
