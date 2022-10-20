package com.fmsp.tikets.entity.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class TicketsDTO {
    private Long id;

    private String user;

    private Instant createdDate;

    private Instant updatedDate;

    private String status;
}
