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
    
    @PutMapping(value="editar/{idUsuario}")
    public ResponseEntity<GenericResponse> modifyUsuario(@PathVariable Long idUsuario,@RequestBody UsuarioDTO usuarioDTO)
    {
         GenericResponse rta = new GenericResponse(); 
         
         Usuario usuarioAux = usuarioService.findByIdUsuario(idUsuario);
        
         if(usuarioAux.getIdUsuario() != null)
         {
             usuarioAux.setNombreUsuario(usuarioDTO.getNombreUsuario());
             usuarioAux.setApellidoUsuario(usuarioDTO.getApellidoUsuario());
             usuarioAux.setDireccionUsuario(usuarioDTO.getDireccionUsuario());
             usuarioAux.setTelefono(usuarioDTO.getTelefono());
             
             rta.isOk= true;
             rta.message = "Se actualizaron los datos";
             usuarioService.guardarUsuario(usuarioAux);
             return ResponseEntity.ok(rta);
         }
         else{
             rta.isOk = false;
             rta.message = "No existe ese id de usuario para modificar";
             return ResponseEntity.badRequest().body(rta);
         }
    }
    
    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<GenericResponse> deleteUsuario(@PathVariable Long idUsuario)
    {
        GenericResponse rta = new GenericResponse();
        
        Usuario usuario = usuarioService.findByIdUsuario(idUsuario);
        
        if(usuario.getIdUsuario() != null)
        {
            rta.isOk = true;
            rta.message = "Se borro el usuario";
            usuarioService.borrarUsuario(usuario);
            return ResponseEntity.ok(rta);
        }
        else{
           rta.isOk = false;
             rta.message = "No existe ese id de usuario para eliminar";
             return ResponseEntity.badRequest().body(rta);
            
        }
        
    }
}
