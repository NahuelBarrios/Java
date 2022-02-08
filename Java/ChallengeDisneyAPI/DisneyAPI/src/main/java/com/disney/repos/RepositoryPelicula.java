package com.disney.repos;

import com.disney.entities.Pelicula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPelicula extends JpaRepository<Pelicula, Integer>{
    
    List<Pelicula> findByTitulo(String nombre);
    
    Pelicula findByIdPelicula(Integer idPelicula);
}
