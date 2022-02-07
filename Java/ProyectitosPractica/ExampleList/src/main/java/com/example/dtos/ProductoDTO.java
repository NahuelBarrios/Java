package com.example.dtos;

import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class ProductoDTO {
    
    @NotBlank(message = "Nombre invalido")
    private String nombreProducto;
    
}
