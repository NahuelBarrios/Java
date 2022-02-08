package com.disney.Service;

import com.disney.dtos.PersonajeDTO;
import com.disney.entities.Personaje;
import com.disney.repos.RepositoryPersonaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersonaje {
    
    @Autowired
    private RepositoryPersonaje repoP;
    
    public Personaje crearNuevoPersonaje(PersonajeDTO personajeDTO)
    {
        Personaje personaje = new Personaje();
        
        personaje.setImagen(personajeDTO.getImagen());
        personaje.setNombre(personajeDTO.getNombre().toLowerCase().trim());
        personaje.setEdad(personajeDTO.getEdad());
        personaje.setPeso(personajeDTO.getPeso());
        personaje.setHistoria(personajeDTO.getHistoria());
        
        return repoP.save(personaje);
    }
    
    public List<Personaje> listarPersonajes()
    {
        return (List<Personaje>) repoP.findAll();
    }
    
    public void guardar(Personaje personaje)
    {
        repoP.save(personaje);
    }
    
    public void borrar(Personaje personaje)
    {
        repoP.delete(personaje);
    }
    
    public Personaje encontrarIdPersonaje(Integer idPersonaje)
    {
        return repoP.findByIdPersonaje(idPersonaje);
    }
    
    public List<Personaje> encontrarNombrePersonaje(String nombrePersonaje)
    {
        return repoP.findByNombre(nombrePersonaje);
    }
    
    public List<Personaje> encontrarEdadPersonaje(Integer edadPersonaje)
    {
        return repoP.findByEdad(edadPersonaje);
    }
    
}
