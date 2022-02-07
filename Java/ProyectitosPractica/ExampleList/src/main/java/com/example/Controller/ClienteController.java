package com.example.Controller;

import com.example.dtos.ClienteDTO;
import com.example.entities.Cliente;
import com.example.models.response.GenericResponse;
import com.example.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private ClienteService serviceC;
    
    @PostMapping("/crearCliente")
    public ResponseEntity<GenericResponse> crearCliente(@RequestBody ClienteDTO clienteDTO) {
        GenericResponse rta = new GenericResponse();
        
        Cliente nuevoCliente = serviceC.crearCliente(clienteDTO);
        
        if (nuevoCliente != null) {
            
            nuevoCliente.setNombre(clienteDTO.getNombre());
            rta.id = nuevoCliente.getIdCliente();
            rta.isOk = true;
            rta.message = "Cliente creado correctamente";
            return ResponseEntity.ok(rta);
        } else {
            rta.isOk = false;
            rta.message = "Cliente NO ha sido creado correctamente";
            return ResponseEntity.badRequest().body(rta);
        }
        
    }
    
}
