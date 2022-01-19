package com.informacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    
}
