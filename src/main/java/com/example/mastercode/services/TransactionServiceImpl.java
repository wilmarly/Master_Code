package com.example.mastercode.services;

import com.example.mastercode.entities.Transaction;
import com.example.mastercode.repositories.TransactionRepository;
import com.example.mastercode.services.Interface.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> findAll() throws Exception {
        try {

            List<Transaction> entities = transactionRepository.findAll();
            return entities;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Transaction findById(Long id) throws Exception {
        try {
            Optional<Transaction> entityOptional = transactionRepository.findById(id);
            return entityOptional.get();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Transaction create(Transaction entity) throws Exception {
        try {
            entity = transactionRepository.save(entity);
            System.out.println(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Transaction update(Long id, Transaction entity) throws Exception {
        try {
            Optional<Transaction> transactionOptional = transactionRepository.findById(id);
            Transaction transactionUpdate = transactionOptional.get();
            transactionUpdate = transactionRepository.save(entity);
            System.out.println(entity);
            return transactionUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (transactionRepository.existsById(id)) {
                transactionRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Transaction> getTransactionEmployee(Long idEmployee) {
        return transactionRepository.findByEmployeeIdEmployee(idEmployee);
    }
}


