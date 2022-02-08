package com.disney.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id")
    private Integer idGenero;
    
    private String nombre;
    
    private String imagen;
    
    @JsonIgnore
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Pelicula> peliculas = new ArrayList<>();
    
}
