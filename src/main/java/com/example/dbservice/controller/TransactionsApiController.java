package com.example.dbservice.controller;

import com.example.dbservice.api.TransactionsApi;
import com.example.dbservice.dto.TransactionDTO;
import com.example.dbservice.dto.TransactionPage;
import com.example.dbservice.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class TransactionsApiController implements TransactionsApi {

    private final TransactionService transactionService;

    @Autowired
    public TransactionsApiController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<TransactionPage> getTransactionsByStatus(
            BigDecimal status,
            Integer offset,
            Integer limit,
            String xRequestID) {

        List<TransactionDTO> transactions = transactionService.getTransactionsByStatus(status);

        TransactionPage page = new TransactionPage()
                .items(transactions)
                .total(transactions.size())
                .offset(offset != null ? offset : 0)
                .limit(limit != null ? limit : transactions.size())
                .count(transactions.size());

        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity<TransactionDTO> createTransaction(@Valid TransactionDTO transactionDTO) {
        TransactionDTO saved = transactionService.saveTransaction(transactionDTO);
        return ResponseEntity.status(201).body(saved);
    }
}
