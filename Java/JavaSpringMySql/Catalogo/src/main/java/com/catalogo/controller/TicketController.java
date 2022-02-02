package com.catalogo.controller;

import com.catalogo.dtos.TicketDTO;
import com.catalogo.entities.Ticket;
import com.catalogo.models.response.GenericResponse;
import com.catalogo.models.response.TicketResponse;
import com.catalogo.service.TicketServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketServicio servicioT;


    @PostMapping("/agregarTicket")
    public ResponseEntity<GenericResponse> agregarTicket(@RequestBody TicketDTO ticketDTO) {

        GenericResponse rta = new GenericResponse();

        Ticket ticket = servicioT.crearTicket(ticketDTO);

        rta.id = ticket.getIdTicket();
        rta.isOk = true;
        rta.message = "Ticket creado correctamente";
        return ResponseEntity.ok(rta);

    }

    @GetMapping("/lista")
    public ResponseEntity<List<TicketResponse>> listarTickets() {
//        Usuario nombreUsuarioAux;
//        Producto nombreProductoAux;
        List<Ticket> listaTicket = servicioT.listarTickets();
        List<TicketResponse> listaTicketResponse = new ArrayList<>();

        for (Ticket ticket : listaTicket) {
            
//            nombreUsuarioAux = servicioU.findByIdUsuario(ticket.getUsuario().getIdUsuario());
//            nombreProductoAux = servicioP.buscarIdProducto(ticket.getProducto().getIdProducto());
            TicketResponse ticketResponse = new TicketResponse(ticket.getIdTicket(),ticket.getFechaTicket(),ticket.getUsuario().getNombreUsuario(),ticket.getProducto().getNombreProducto());
            listaTicketResponse.add(ticketResponse);
        }
        return ResponseEntity.ok(listaTicketResponse);
    }

}
