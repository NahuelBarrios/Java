package com.catalogo.controller;

import com.catalogo.dtos.UsuarioDTO;
import com.catalogo.entities.Usuario;
import com.catalogo.models.response.GenericResponse;
import com.catalogo.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioServicio usuarioService;
    
    @PostMapping("/crearUsuario")
    public ResponseEntity<GenericResponse> createUsuario(@RequestBody UsuarioDTO usuarioDTO)
    {
        GenericResponse rta = new GenericResponse(); 
        
        Usuario usuario = usuarioService.crearNuevoUsuario(usuarioDTO);
        
        rta.id = usuario.getIdUsuario();
        rta.isOk = true;
        rta.message = "Usuario creado correctamente";
        return ResponseEntity.ok(rta);
        
    }
}
