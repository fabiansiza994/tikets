package com.fmsp.tikets.controller;

import com.fmsp.tikets.criteria.SearchRequest;
import com.fmsp.tikets.entity.dto.TicketsDTO;
import com.fmsp.tikets.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tikets")
public class TicketsController {

    public final TicketService ticketService;

    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("v1/create-ticket")
    public ResponseEntity<TicketsDTO> saveTicket(@RequestBody TicketsDTO ticketsDTO){
        var tiket = ticketService.save(ticketsDTO);
        return new ResponseEntity<>(tiket, HttpStatus.CREATED);
    }

    @PostMapping("v1/list-ticket")
    public ResponseEntity<Object> listTicket(@RequestBody SearchRequest searchRequest){
        var tiket = ticketService.findAll(searchRequest);
        return new ResponseEntity<>(tiket.getContent(), HttpStatus.OK);
    }

    @PutMapping("v1/edit-ticket")
    public ResponseEntity<TicketsDTO> editTicket(@RequestBody TicketsDTO ticketsDTO){
        var tiket = ticketService.edit(ticketsDTO);
        return new ResponseEntity<>(tiket, HttpStatus.CREATED);
    }

    @DeleteMapping("v1/delete-ticket/{id}")
    public ResponseEntity<Object> listTicket(@PathVariable Long id){
        ticketService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
