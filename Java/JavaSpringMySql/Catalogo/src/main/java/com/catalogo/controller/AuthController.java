package com.catalogo.controller;

import com.catalogo.dtos.IngresarDTO;
import com.catalogo.dtos.RegistroDTO;
import com.catalogo.entities.Rol;
import com.catalogo.entities.User;
import com.catalogo.models.response.GenericResponse;
import com.catalogo.repository.RolRepository;
import com.catalogo.repository.UserRepository;
import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RolRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
 
//    @PostMapping("/ingresar")
//    public ResponseEntity<String> authenticateUser(@RequestBody IngresarDTO ingresarDTO)
//    {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(ingresarDTO.getUsername(),ingresarDTO.getPassword()));
//    
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//         return new ResponseEntity<>("User signed-in succesfully!.",HttpStatus.OK);
//    }
    
    @PostMapping("/ingresar")
    public ResponseEntity<GenericResponse> authenticateUser(@RequestBody IngresarDTO ingresarDTO)
    {
        GenericResponse rta = new GenericResponse();    
        
        //Chequea si el username existe en la db
        if(userRepository.existsByUsername(ingresarDTO.getUsername()))
        {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(ingresarDTO.getUsername(),ingresarDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            rta.isOk = true;
            rta.message = "Bienvenido usuario: " + ingresarDTO.getUsername();
            return ResponseEntity.ok(rta);
            
        }
        else{
            rta.isOk = false;
            rta.message = "No existe ese nombre de usuario";
            return ResponseEntity.badRequest().body(rta);
        }
    }
    
    @PostMapping("/registro")
    public ResponseEntity<GenericResponse> registerUSer(@RequestBody RegistroDTO registroDTO)
    {
        GenericResponse rta = new GenericResponse();
        //Chequea si el username existe en la db
        if(userRepository.existsByUsername(registroDTO.getUsername()))
        {
            rta.isOk = false;
            rta.message = "Ya existe ese nombre de usuario";
            return ResponseEntity.badRequest().body(rta);
        }
      
        //Creo el objeto usuario
        User user = new User();
        user.setUsername(registroDTO.getUsername());
        user.setPassword(registroDTO.getPassword());
        
        user.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
        
        Rol roles = roleRepository.findByNombre("ROLE_USER").get();
        user.setRoles(Collections.singleton(roles));
        
        userRepository.save(user);
        rta.isOk = true;
        rta.id = user.getIdUsuario();
        rta.message = "Se creo el usuario: " +user.getUsername() + "/ Con los roles: " + user.getRoles();
        return ResponseEntity.ok(rta);
    }
    
}
