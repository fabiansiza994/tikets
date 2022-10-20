package com.fmsp.tikets.service.impl;

import com.fmsp.tikets.criteria.SearchRequest;
import com.fmsp.tikets.criteria.SearchSpecification;
import com.fmsp.tikets.entity.TicketsEntity;
import com.fmsp.tikets.entity.dto.TicketsDTO;
import com.fmsp.tikets.repository.TiketRepository;
import com.fmsp.tikets.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TiketRepository tiketRepository;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TiketRepository tiketRepository, ModelMapper modelMapper) {
        this.tiketRepository = tiketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketsDTO save(TicketsDTO ticketsDTO) {
        ticketsDTO.setCreatedDate(Instant.now());
        var tiket = tiketRepository.save(modelMapper.map(ticketsDTO, TicketsEntity.class));
        return modelMapper.map(tiket, TicketsDTO.class);
    }

    @Override
    public Page<TicketsDTO> findAll(SearchRequest searchRequest) {
        SearchSpecification<TicketsEntity> specification = new SearchSpecification<>(searchRequest);
        Pageable pageable = SearchSpecification.getPageable(searchRequest.getPage(), searchRequest.getSize());
        var ticket = tiketRepository.findAll(specification, pageable);
        var ticketList = ticket.getContent().stream()
                .map(ticketItem -> modelMapper.map(ticketItem, TicketsDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(ticketList, pageable, ticket.getTotalElements());
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        tiketRepository.deleteById(id);
    }

    @Override
    public TicketsDTO edit(TicketsDTO ticketsDTO) {
        this.findById(ticketsDTO.getId());
        ticketsDTO.setUpdatedDate(Instant.now());
        var ticket = tiketRepository.save(modelMapper.map(ticketsDTO, TicketsEntity.class));
        return modelMapper.map(ticket, TicketsDTO.class);
    }

    public void findById(Long id){
        var ticket = tiketRepository.findById(id);
        if(ticket.isEmpty()){
            throw new RuntimeException("Record not found");
        }
    };
}
