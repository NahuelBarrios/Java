package com.catalogo.dtos;

import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class UsuarioDTO {
    
    @NotBlank(message = "Nombre invalido")
    private String nombreUsuario;
    
    @NotBlank(message = "Apellido invalido")
    private String apellidoUsuario;
    
    @NotBlank(message = "direccion invalido")
    private String direccionUsuario;
    
    @NotBlank(message = "Telefono invalido")
    private String telefono;
}
