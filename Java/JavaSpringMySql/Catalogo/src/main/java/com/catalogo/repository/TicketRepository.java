package com.catalogo.repository;

import com.catalogo.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
    public Ticket findByIdTicket(Long idTicket);
}
