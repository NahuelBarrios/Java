package com.catalogo.service;

import com.catalogo.dtos.UsuarioDTO;
import com.catalogo.entities.Usuario;
import com.catalogo.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicio {
 
    @Autowired
    private UsuarioRepository repo;
    
    public Usuario crearNuevoUsuario(UsuarioDTO usuarioDto)
    {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setApellidoUsuario(usuarioDto.getApellidoUsuario());
        usuario.setDireccionUsuario(usuarioDto.getDireccionUsuario());
        usuario.setTelefono(usuarioDto.getTelefono());
        
        return repo.save(usuario);
    }
    
    
    public List<Usuario> listarPersonajes()
    {
        return (List<Usuario>) repo.findAll();
    }
    
    public void guardarUsuario(Usuario usuario)
    {
        repo.save(usuario);
    }
    
    public void borrarUsuario(Usuario usuario)
    {
        repo.delete(usuario);
    }
    
    public Usuario encontrarUsuarioById(Usuario usuario)
    {
        return repo.findById(usuario.getIdUsuario()).orElse(null);
    }
    
    public Usuario encontrarUsuarioByNombre(Usuario usuario)
    {
        return repo.findByNombreUsuario(usuario.getNombreUsuario());
    }
    
}
