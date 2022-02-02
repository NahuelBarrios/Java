package com.catalogo.dtos;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
public class TicketDTO {
 
    @NotBlank(message = "fecha invalido")
    private Date fechaTicket;
    
    @NotBlank(message = "usuario invalido")
    private Long usuario;
    
    @NotBlank(message = "producto invalido")
    private Long producto;
}
