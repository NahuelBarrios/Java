package com.informacion.serviceImpl;

import com.informacion.dao.UsuarioDao;
import com.informacion.entities.Usuario;
import com.informacion.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public List<Usuario> listaUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }
    
}
