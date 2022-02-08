package com.disney.repos;

import com.disney.entities.Personaje;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPersonaje extends JpaRepository<Personaje,Integer>{
    
    List<Personaje> findByNombre(String nombre);
    
    List<Personaje> findByEdad(Integer edad);
    
    Personaje findByIdPersonaje(Integer idPersonaje);
    
}
