package com.disney.dtos;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
public class PeliculaDTO {
    
    @NotBlank(message = "imagen invalido")
    private String imagen;
    
    @NotBlank(message = "titulo invalido")
    private String titulo;
    
    private Date fechaCreacion;
    
    @Positive(message = "La calificacion debe ser positivo")
    private Double calificacion;

    @Positive(message = "El id debe ser positivo")
    private Integer idGenero;
    
}
