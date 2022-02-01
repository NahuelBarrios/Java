package com.catalogo.repository;

import com.catalogo.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    public List<Usuario> findByNombreUsuario(String nombre);
 
    public Usuario findByIdUsuario(Long idUsuario);
    
}
