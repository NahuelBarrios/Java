package com.catalogo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotNull
    private String nombreUsuario;
    
    @NotNull
    private String apellidoUsuario;
    
    @NotNull
    private String direccionUsuario;
    
    @NotNull
    private String telefono;
    
}
