package com.example.dtos;

import javax.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
public class ClienteDTO {
    
    @NotBlank(message = "Nombre invalido")
    private String nombre;
    
}
