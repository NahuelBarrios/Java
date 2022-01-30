package com.catalogo.dtos;

import com.catalogo.entities.Usuario;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {
    
    @NotBlank(message = "Imagen invalida")
    private String imagenProducto;
    
    @NotBlank(message = "Nombre invalido")
    private String nombreProducto;
    
    @NotBlank(message = "precio invalido")
    private Double precioProducto;

    private Date creationDate; 

    @Positive(message = "El usuario id debe ser positivo")
    private Usuario usuario;
}
