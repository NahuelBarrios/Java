package com.disney.Service;

import com.disney.dtos.PeliculaDTO;
import com.disney.entities.Genero;
import com.disney.entities.Pelicula;
import com.disney.repos.RepositoryPelicula;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPelicula {
    
    @Autowired
    private RepositoryPelicula repoP;
    
    @Autowired
    private ServicioGenero sg;
    
    public Pelicula crearNuevaPelicula(PeliculaDTO peliculaDTO)
    {
        Pelicula pelicula = new Pelicula();
        
        pelicula.setImagen(peliculaDTO.getImagen());
        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setFechaCreacion(peliculaDTO.getFechaCreacion());
        pelicula.setCalificacion(peliculaDTO.getCalificacion());
        
        Genero genero = sg.encontrarIdGenero(peliculaDTO.getIdGenero());
        pelicula.setGenero(genero);
        
        this.guardar(pelicula);
        
        return pelicula;
    }
    
    
    public List<Pelicula> listarPeliculas()
    {
        return repoP.findAll();
    }
    
    public void guardar(Pelicula pelicula) {
        repoP.save(pelicula);
    }
    
    public void eliminarPelicula(Pelicula pelicula) {
        repoP.delete(pelicula);
    }
    
    public Pelicula encontrarIdPelicula(Integer idPelicula)
    {
        return repoP.findByIdPelicula(idPelicula);
    }
    
    public List<Pelicula> encontrarNombrePelicula(String nombre)
    {
        return repoP.findByTitulo(nombre);
    }
}
