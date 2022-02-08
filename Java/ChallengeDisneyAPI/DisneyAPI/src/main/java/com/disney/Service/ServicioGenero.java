package com.disney.Service;

import com.disney.entities.Genero;
import com.disney.repos.RepositoryGenero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioGenero {
 
    @Autowired
    private RepositoryGenero repoG;
    
    public boolean crear(Genero genero){
        if(existe(genero.getNombre())){
            return false;
        }
        repoG.save(genero);
        return true;
    }
    
    public Genero encontrarIdGenero(Integer idGenero)
    {
        return repoG.findByIdGenero(idGenero);
    }
    
    public List<Genero> listarGeneros()
    {
        return (List<Genero>)repoG.findAll();
    }
    
    private boolean existe(String nombre)
    {
        Genero genero = repoG.findByNombre(nombre);
        return genero != null;
    }
    
    public void guardar(Genero genero)
    {
        repoG.save(genero);
    }
    
    public void eliminar(Genero genero)
    {
        repoG.delete(genero);
    }
    
}
