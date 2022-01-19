package com.informacion.controller;

import com.informacion.entities.Gastos;
import com.informacion.serviceImpl.GastosServiceImpl;
import com.informacion.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gastos")
public class GastosController {
    
    @Autowired
    private GastosServiceImpl gastosService;
    
    @Autowired
    private UsuarioServiceImpl usuarioService;
    
    @GetMapping("/agregarGasto")
    public String agregarGastos(Gastos gastos,Model model)
    {
        var usuarios = usuarioService.listaUsuario();
        
        model.addAttribute("usuarios", usuarios);
        return "nuevogasto";
    }
    
    @PostMapping("/guardarGasto")
    public String guardarGastos(Gastos gastos)
    {
        gastosService.saveGastos(gastos);
        
        return "redirect:/";
    }
    
    @GetMapping("/editarGasto/{idGasto}")
    public String editarGasto(Gastos gasto,Model model)
    {
        gasto = gastosService.encontrarGastos(gasto);
        model.addAttribute("gastos", gasto);
        return "nuevogasto";
    }
    
    @GetMapping("/eliminarGasto/{idGasto}")
    public String eliminarGasto(Gastos gasto)
    {
        gastosService.deleteGastos(gasto);
        return "redirect:/";
    }
}
