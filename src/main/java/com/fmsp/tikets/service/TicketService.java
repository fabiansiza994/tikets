package com.fmsp.tikets.service;

import com.fmsp.tikets.criteria.SearchRequest;
import com.fmsp.tikets.entity.dto.TicketsDTO;
import org.springframework.data.domain.Page;

public interface TicketService {
    TicketsDTO save(TicketsDTO ticketsDTO);

    Page<TicketsDTO> findAll(SearchRequest searchRequest);

    void delete(Long id);

    TicketsDTO edit(TicketsDTO ticketsDTO);
}
