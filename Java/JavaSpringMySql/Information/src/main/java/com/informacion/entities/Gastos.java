package com.informacion.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@Entity
@Table(name="gastos")
public class Gastos implements Serializable{
    
    private static final long serialVersionUID = 1L;
                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGasto;
    private String tipoGasto; // Si es en efvo o tarjeta. etc
    private String nombreGasto;
    private Double totalGasto;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    private Date creationDate; 
    
    @ManyToOne
    @JoinColumn(name = "usuarioGasto")
    private Usuario usuario;
}
