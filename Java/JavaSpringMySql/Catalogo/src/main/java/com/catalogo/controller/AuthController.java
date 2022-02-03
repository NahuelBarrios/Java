package com.catalogo.controller;

import com.catalogo.dtos.LoginDTO;
import com.catalogo.dtos.RegistroDTO;
import com.catalogo.entities.Rol;
import com.catalogo.entities.User;
import com.catalogo.models.response.GenericResponse;
import com.catalogo.repository.RolRepository;
import com.catalogo.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repoU;

    @Autowired
    private RolRepository repoR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<GenericResponse> authenticateUser(@RequestBody LoginDTO loginDTO) {
        GenericResponse rta = new GenericResponse();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        rta.isOk = true;
        rta.message = "Ingreso con exito";

        return ResponseEntity.ok(rta);
    }

    @PostMapping("/registro")
    public ResponseEntity<GenericResponse> registroUser(@RequestBody RegistroDTO registroDTO) {
        GenericResponse rta = new GenericResponse();

        if (repoU.existsByUsername(registroDTO.getUsername())) {
            rta.isOk = false;
            rta.message = "Ya existe ese username, ingrese otro";
            return ResponseEntity.badRequest().body(rta);
        }
        
        if(repoU.existsByEmail(registroDTO.getEmail())) {
            rta.isOk = false;
            rta.message = "Ya existe ese email, ingrese otro";
            return ResponseEntity.badRequest().body(rta);
        }
        
        User user = new User();
        user.setName(registroDTO.getName());
        user.setUsername(registroDTO.getUsername());
        user.setEmail(registroDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registroDTO.getPassword()));

        Rol roles = repoR.findByNameRol("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));
        
        repoU.save(user);
        rta.isOk = true;
        rta.message = "Registro se realizo con exito";

        return ResponseEntity.ok(rta);
        
    }
}
