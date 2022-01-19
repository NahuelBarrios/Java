package com.informacion.controller;

import com.informacion.entities.Usuario;
import com.informacion.serviceImpl.UsuarioServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioServiceImpl usuarioService;
    
    @GetMapping("/agregarUsuario")
    public String agregarUsuario(Usuario usuario)
    {
        return "nuevousuario";
    }
    
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@Valid Usuario usuario,Errors errores)
    {
        if(errores.hasErrors())
        {
            return "nuevousuario";
        }
        
        usuarioService.saveUsuario(usuario);
        return "redirect:/";
    }
    
}
