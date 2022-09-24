package com.example.mastercode.dto;

import com.example.mastercode.entities.common.IdentificableEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionDTO(Long id,
                             BigDecimal amount,
                             String concept,
                             String enterprise,
                             String employee,
                             LocalDate createdAt,
                             LocalDate updatedAt) implements IdentificableEntity {


    @Override
    public Long getId() {
        return id;
    }
}
