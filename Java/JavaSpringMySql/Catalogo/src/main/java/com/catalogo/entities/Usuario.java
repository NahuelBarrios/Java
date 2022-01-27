package com.catalogo.entities;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private String nombreUsuario;
    
    private String apellidoUsuario;
    
    private String direccionUsuario;
    
    private String telefono;
    
}
