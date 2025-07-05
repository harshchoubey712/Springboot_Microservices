package com.example.dbservice.mapper;

import com.example.dbservice.dto.TransactionDTO;
import com.example.dbservice.entity.Transaction;

import java.math.BigDecimal;

public class TransactionMapper {

    public static TransactionDTO toDto(Transaction entity) {
        if (entity == null) return null;

        TransactionDTO dto = new TransactionDTO();
        dto.setId(entity.getId() != null ? entity.getId().toString() : null);
        dto.setAmount(entity.getAmount() != null ? entity.getAmount().doubleValue() : null);
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static Transaction toEntity(TransactionDTO dto) {
        if (dto == null) return null;

        Transaction entity = new Transaction();
        if (dto.getId() != null) {
            try {
                entity.setId(Long.parseLong(dto.getId()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid ID format: must be a number", e);
            }
        }
        entity.setAmount(dto.getAmount() != null ? BigDecimal.valueOf(dto.getAmount()) : null);
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
