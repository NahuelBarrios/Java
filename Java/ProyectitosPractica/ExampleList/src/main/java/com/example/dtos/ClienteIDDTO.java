package com.example.dtos;

import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class ClienteIDDTO {
    
    @NotBlank(message = "Id invalido")
    private Integer idCliente;
}
