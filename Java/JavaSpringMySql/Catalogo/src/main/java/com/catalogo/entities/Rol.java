package com.catalogo.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "roles")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    
    private String nombre;
    
}
