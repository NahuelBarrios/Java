package com.disney.entities;

import java.util.*;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "pelicula_id")
    private Integer idPelicula;

    private String imagen;
    
    private String titulo;
    
    @Temporal(TemporalType.DATE)
    @Column(name= "fecha_creacion")
    private Date fechaCreacion;
    
    private Double calificacion;
    
    @ManyToOne
    @JoinColumn(name= "genero_id", referencedColumnName = "genero_id")
    private Genero genero;
    
    @ManyToMany(mappedBy= "peliculas",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Personaje> personajes = new ArrayList<>();
    }
