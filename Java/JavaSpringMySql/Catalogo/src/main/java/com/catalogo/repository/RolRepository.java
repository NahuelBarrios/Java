package com.catalogo.repository;

import com.catalogo.entities.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
    
    public Optional<Rol> findByNameRol(String name);
}
