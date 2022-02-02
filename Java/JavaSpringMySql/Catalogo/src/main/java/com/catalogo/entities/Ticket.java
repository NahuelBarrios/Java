package com.catalogo.entities;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaTicket;
    
    @ManyToOne
    @JoinColumn(name="usuarioTicket")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="productoTicket")
    private Producto producto;
}
