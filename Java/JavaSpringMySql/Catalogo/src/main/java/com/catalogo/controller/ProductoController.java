package com.catalogo.controller;

import com.catalogo.dtos.ProductoDTO;
import com.catalogo.entities.Producto;
import com.catalogo.models.response.GenericResponse;
import com.catalogo.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoServicio servicioP;

    @PostMapping("/crearProdcuto")
    public ResponseEntity<GenericResponse> agregar(@RequestBody ProductoDTO productoDTO, BindingResult results) {

        GenericResponse rta = new GenericResponse();

        if (results.hasErrors()) {
            rta.isOk = false;
            rta.message = "Producto NO creado correctamente";
            
            return ResponseEntity.badRequest().body(rta);
        } else {
            Producto producto = servicioP.crearNuevoProducto(productoDTO);
            
            rta.id = producto.getIdProducto();
            rta.isOk = true;
            rta.message = "SE creo correctamente el producto";
            
            return ResponseEntity.ok(rta);        
        }

    }
}
