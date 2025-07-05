package com.example.dbservice.service;

import com.example.dbservice.dto.TransactionDTO;
import com.example.dbservice.entity.Transaction;
import com.example.dbservice.mapper.TransactionMapper;
import com.example.dbservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Save a transaction (POST)
    public TransactionDTO saveTransaction(TransactionDTO dto) {
        Transaction transaction = TransactionMapper.toEntity(dto);
        Transaction saved = transactionRepository.save(transaction);
        return TransactionMapper.toDto(saved);
    }

    // Get transactions by status (GET)
    public List<TransactionDTO> getTransactionsByStatus(BigDecimal status) {
        List<Transaction> transactions = transactionRepository.findByStatus(status);
        return transactions.stream()
                .map(TransactionMapper::toDto)
                .collect(Collectors.toList());
    }
}
