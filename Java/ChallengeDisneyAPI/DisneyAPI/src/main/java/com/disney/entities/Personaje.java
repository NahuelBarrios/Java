package com.disney.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personajes")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "personaje_id")
    private Integer idPersonaje;
    
    private String imagen;
    
    private String nombre;
    
    private Integer edad;
    
    private Double peso;
    
    private String historia;
    
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private List<Pelicula> peliculas = new ArrayList<>();
    
}
