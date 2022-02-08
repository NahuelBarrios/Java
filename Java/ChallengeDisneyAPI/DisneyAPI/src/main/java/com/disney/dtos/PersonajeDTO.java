package com.disney.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDTO {
    
    @NotBlank(message = "imagen invalido")
    private String imagen;
    
    @NotBlank(message = "Nombre invalido")
    private String nombre;
    
    @Positive(message = "la edad debe ser positivo")
    private Integer edad;
    
    @Positive(message = "El peso debe ser positivo")
    private Double peso;
    
    @NotBlank(message = "Nombre invalido")
    private String historia;
    
    
}
