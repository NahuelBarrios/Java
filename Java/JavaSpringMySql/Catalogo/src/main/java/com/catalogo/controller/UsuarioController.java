package com.catalogo.controller;

import com.catalogo.dtos.UsuarioDTO;
import com.catalogo.entities.Usuario;
import com.catalogo.models.response.GenericResponse;
import com.catalogo.models.response.UsuarioResponse;
import com.catalogo.service.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<GenericResponse> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        GenericResponse rta = new GenericResponse();

        Usuario usuario = usuarioService.crearNuevoUsuario(usuarioDTO);

        rta.id = usuario.getIdUsuario();
        rta.isOk = true;
        rta.message = "Usuario creado correctamente";
        return ResponseEntity.ok(rta);
    }

    @PutMapping(value = "editar/{idUsuario}")
    public ResponseEntity<GenericResponse> modifyUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioDTO usuarioDTO) {
        GenericResponse rta = new GenericResponse();

        Usuario usuarioAux = usuarioService.findByIdUsuario(idUsuario);

        if (usuarioAux.getIdUsuario() != null) {
            usuarioAux.setNombreUsuario(usuarioDTO.getNombreUsuario());
            usuarioAux.setApellidoUsuario(usuarioDTO.getApellidoUsuario());
            usuarioAux.setDireccionUsuario(usuarioDTO.getDireccionUsuario());
            usuarioAux.setTelefono(usuarioDTO.getTelefono());

            rta.isOk = true;
            rta.message = "Se actualizaron los datos";
            usuarioService.guardarUsuario(usuarioAux);
            return ResponseEntity.ok(rta);
        } else {
            rta.isOk = false;
            rta.message = "No existe ese id de usuario para modificar";
            return ResponseEntity.badRequest().body(rta);
        }
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<GenericResponse> deleteUsuario(@PathVariable Long idUsuario) {
        GenericResponse rta = new GenericResponse();

        Usuario usuario = usuarioService.findByIdUsuario(idUsuario);

        if (usuario.getIdUsuario() != null) {
            rta.isOk = true;
            rta.message = "Se borro el usuario";
            usuarioService.borrarUsuario(usuario);
            return ResponseEntity.ok(rta);
        } else {
            rta.isOk = false;
            rta.message = "No existe ese id de usuario para eliminar";
            return ResponseEntity.badRequest().body(rta);

        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarPersonajes();

        List<UsuarioResponse> listaResponse = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            UsuarioResponse usuarioResponse = new UsuarioResponse(usuario.getNombreUsuario(), usuario.getApellidoUsuario(), usuario.getDireccionUsuario(), usuario.getTelefono());
            listaResponse.add(usuarioResponse);
        }
        return ResponseEntity.ok(listaResponse);
    }

    @GetMapping(value = "/lista", params = "name")
    public ResponseEntity<List<Usuario>> listarUsuario(@RequestParam String name)
    {
        List<Usuario> listaUsuarios = usuarioService.encontrarUsuarioByNombre(name);
        
        if(listaUsuarios.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(listaUsuarios);
    }
    
    
    
}
