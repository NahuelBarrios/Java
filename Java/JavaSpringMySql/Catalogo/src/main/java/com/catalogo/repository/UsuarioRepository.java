package com.catalogo.repository;

import com.catalogo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    public Usuario findByNombreUsuario(String nombre);
 
    public Usuario findByIdUsuario(Long idUsuario);
    
}
