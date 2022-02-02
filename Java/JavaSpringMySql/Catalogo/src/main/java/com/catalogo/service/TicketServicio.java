package com.catalogo.service;

import com.catalogo.dtos.TicketDTO;
import com.catalogo.entities.Ticket;
import com.catalogo.repository.TicketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServicio {
 
    @Autowired
    private TicketRepository repo;
    
    @Autowired
    private UsuarioServicio repoU;
    
    @Autowired
    private ProductoServicio repoP;
    
    public Ticket crearTicket(TicketDTO ticketDTO)
    {
        Ticket ticket = new Ticket();
        
        ticket.setFechaTicket(ticketDTO.getFechaTicket());
        ticket.setUsuario(repoU.findByIdUsuario(ticketDTO.getUsuario()));
        ticket.setProducto(repoP.buscarIdProducto(ticketDTO.getProducto()));
        
        return repo.save(ticket);
    }
    
    public List<Ticket> listarTickets()
    {
        return (List<Ticket>)repo.findAll();
    }
 
    public Ticket buscarIdTicket(Long idTicket){
        return repo.findByIdTicket(idTicket);
    }
    
    public void guardar(Ticket ticket)
    {
        repo.save(ticket);
    }
    
    public void borrar(Ticket ticket)
    {
        repo.delete(ticket);
    }
    
}
