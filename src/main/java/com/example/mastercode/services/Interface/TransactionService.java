package com.example.mastercode.services.Interface;

import com.example.mastercode.entities.Transaction;

import java.util.List;

public interface TransactionService extends BaseService<Transaction> {
    List<Transaction> getTransactionEmployee(Long idEmployee);
}
