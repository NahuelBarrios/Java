package com.catalogo.controller;

import com.catalogo.dtos.TicketDTO;
import com.catalogo.entities.Ticket;
import com.catalogo.models.response.GenericResponse;
import com.catalogo.models.response.TicketResponse;
import com.catalogo.service.ProductoServicio;
import com.catalogo.service.TicketServicio;
import com.catalogo.service.UsuarioServicio;
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

    @Autowired
    private ProductoServicio servicioP;

    @Autowired
    private UsuarioServicio servicioU;

    @PostMapping("/agregarTicket")
    public ResponseEntity<GenericResponse> agregarTicket(@RequestBody TicketDTO ticketDTO) {

        GenericResponse rta = new GenericResponse();

        Ticket ticket = servicioT.crearTicket(ticketDTO);

        rta.id = ticket.getIdTicket();
        rta.isOk = true;
        rta.message = "Ticket creado correctamente";
        return ResponseEntity.ok(rta);

    }

    @PutMapping("/editarTicket/{idTicket}")
    public ResponseEntity<GenericResponse> editarTicket(@RequestBody TicketDTO ticketDTO, @PathVariable Long idTicket) {
        GenericResponse rta = new GenericResponse();
        Ticket ticket = servicioT.buscarIdTicket(idTicket);

        if (ticket.getIdTicket() != null) {
            ticket.setFechaTicket(ticketDTO.getFechaTicket());
            ticket.setUsuario(servicioU.findByIdUsuario(ticketDTO.getUsuario()));
            ticket.setProducto(servicioP.buscarIdProducto(ticketDTO.getProducto()));

            rta.isOk = true;
            rta.message = "Se edito el ticket Correctamente";
            servicioT.guardar(ticket);
            return ResponseEntity.ok(rta);
        } else {
            rta.isOk = false;
            rta.message = "No se edito el ticket";
            return ResponseEntity.badRequest().body(rta);
        }

    }

    @DeleteMapping("/eliminarTicket/{idTicket}")
    public ResponseEntity<GenericResponse> eliminarTicket(@PathVariable Long idTicket) {
        GenericResponse rta = new GenericResponse();
        Ticket ticket = servicioT.buscarIdTicket(idTicket);

        if (ticket.getIdTicket() != null) {

            rta.isOk = true;
            rta.message = "Se elimino el ticket Correctamente";
            servicioT.borrar(ticket);
            return ResponseEntity.ok(rta);
        } else {
            rta.isOk = false;
            rta.message = "No se elimino el ticket";
            return ResponseEntity.badRequest().body(rta);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<TicketResponse>> listarTickets() {
        List<Ticket> listaTicket = servicioT.listarTickets();
        List<TicketResponse> listaTicketResponse = new ArrayList<>();

        for (Ticket ticket : listaTicket) {
            TicketResponse ticketResponse = new TicketResponse(ticket.getIdTicket(), ticket.getFechaTicket(), ticket.getUsuario().getNombreUsuario(), ticket.getProducto().getNombreProducto());
            listaTicketResponse.add(ticketResponse);
        }
        return ResponseEntity.ok(listaTicketResponse);
    }

}
