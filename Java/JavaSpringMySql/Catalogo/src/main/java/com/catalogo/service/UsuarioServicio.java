package com.catalogo.service;

import com.catalogo.entities.Usuario;
import com.catalogo.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicio {
 
    @Autowired
    private UsuarioRepository repo;
    
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
    
    public Optional<Usuario> encontrarUsuarioByNombre(Usuario usuario)
    {
        return repo.findByNombreUsuario(usuario.getNombreUsuario());
    }
    
}
