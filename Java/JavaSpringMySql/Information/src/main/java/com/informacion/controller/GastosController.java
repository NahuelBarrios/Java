package com.informacion.controller;

import com.informacion.entities.Gastos;
import com.informacion.serviceImpl.GastosServiceImpl;
import com.informacion.serviceImpl.UsuarioServiceImpl;
import java.util.ArrayList;
import java.util.List;
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
    
    @PostMapping("/gastosUsuario")
    public String buscador(@RequestParam("usuarioGastos") String usuarioGastos, Model model)
    {
        var listaGastos = gastosService.listaGastos();
        var listaUsuarios = usuarioService.listaUsuario();
        List<Object> listaNueva = new ArrayList<Object>(); // Tengo que crear con un arrayList
//        List<Usuario> listaNueva = null;
//        
        if(usuarioGastos != null && usuarioGastos.isEmpty())
        {
            return "redirect:/";
        }
//        
//        for(var usuario: listaUsuarios)
//        {
//            if(usuario.getNombreUsuario().equals(usuarioGastos))
//            {
//                listaNueva.add(usuario);
//            }
//        }
//        
//        if(listaNueva != null)
//        {
//            model.addAttribute("listaUsuarios", listaNueva);
//        }
    
        for(var gasto: listaGastos)
        {
            if(gasto.getUsuario().getNombreUsuario().equals(usuarioGastos))
            {
                listaNueva.add(gasto);
            }
        }

        if(listaNueva != null)
        {
            model.addAttribute("listaGastosBuscador", listaNueva);
            model.addAttribute("listausuarios", listaUsuarios);
        }
        else{
            model.addAttribute("listaGastosBuscador", "No tiene Gastos");
        }
        
        return "resultadobuscador";
    }
    
    @GetMapping("/agregarGasto")
    public String agregarGastos(Gastos gastos,Model model)
    {
        var usuarios = usuarioService.listaUsuario();
        
        model.addAttribute("usuarios", usuarios);
        return "nuevogasto";
    }
    
    @PostMapping("/guardarGasto")
    public String guardarGastos(Gastos gastos,Model model)
    {
        gastosService.saveGastos(gastos);
        model.addAttribute("mensaje", "Gasto Agregado");
        
        return "redirect:/";
    }
    
    @GetMapping("/editarGasto/{idGasto}")
    public String editarGasto(Gastos gasto,Model model)
    {
        gasto = gastosService.encontrarGastos(gasto);
        model.addAttribute("gastos", gasto);
       // agregado
        var usuarios = usuarioService.listaUsuario();
        
        model.addAttribute("usuarios", usuarios);
        
        return "nuevogasto";
    }
    
    @GetMapping("/eliminarGasto/{idGasto}")
    public String eliminarGasto(Gastos gasto)
    {
        gastosService.deleteGastos(gasto);
        return "redirect:/";
    }
}
