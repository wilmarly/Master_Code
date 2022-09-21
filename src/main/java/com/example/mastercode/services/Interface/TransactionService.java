package com.example.mastercode.services.Interface;

import com.example.mastercode.dto.TransactionDto;
import com.example.mastercode.entities.Transaction;

import java.util.List;

public interface TransactionService {
    List<TransactionDto> findAll();
    TransactionDto findById(Long id);
    Transaction create(Transaction entity);
    Transaction update(Long id, Transaction entity);
    boolean delete (Long id);
    List<Transaction> getTransactionEmployee(Long idEmployee);
}
