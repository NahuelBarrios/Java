package com.informacion.controller;

import com.informacion.serviceImpl.GastosServiceImpl;
import com.informacion.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    
    @Autowired
    private GastosServiceImpl gastosService;
    
    @Autowired
    private UsuarioServiceImpl usuarioService;
    
    @GetMapping("/")
    public String index(Model model)
    {
        var gastosAux = gastosService.listaGastos();
        model.addAttribute("listagastos", gastosAux);
        
        var usuarioAux = usuarioService.listaUsuario();
        model.addAttribute("listausuarios", usuarioAux);
        return "index";
    }
    
}
