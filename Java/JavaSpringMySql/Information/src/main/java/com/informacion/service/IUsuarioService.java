package com.informacion.service;

import com.informacion.entities.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    public void saveUsuario(Usuario usuario);
    
    public List<Usuario> listaUsuario();
    
    public void deleteUsuario(Usuario usuario);
    
    public Usuario encontrarUsuario(Usuario usuario);
    
}
