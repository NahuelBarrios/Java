package com.catalogo.models.response;

import java.util.Date;

public class TicketResponse {
    
    public Long idTicket;

    public Date fechaTicket;

    public String usuario;

    public String producto;

    
    public TicketResponse(){}
    
    public TicketResponse(Long idTicket, Date fechaTicket,String usuario,String producto){
    
        this.idTicket = idTicket;
        this.fechaTicket = fechaTicket;
        this.usuario = usuario;
        this.producto = producto;
        
    }
    
    
}
