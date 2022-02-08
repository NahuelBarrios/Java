package com.disney.repos;

import com.disney.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryGenero extends JpaRepository<Genero, Integer>{
    
    Genero findByNombre(String nombre);
    
    Genero findByIdGenero(Integer idGenero);
    
}
