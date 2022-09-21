package com.example.mastercode.services;

import com.example.mastercode.dto.TransactionDto;
import com.example.mastercode.entities.Transaction;
import com.example.mastercode.repositories.TransactionRepository;
import com.example.mastercode.services.Interface.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private TransactionDto convertEntityDto(Transaction transaction) {

        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setIdTransaction(transaction.getIdTransaction());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setConcept(transaction.getConcept());
        transactionDto.setEnterprise(transaction.getEnterprise().getName());
        transactionDto.setEmployee(transaction.getEmployee().getProfile().getName());
        transactionDto.setCreated_at(transaction.getCreated_at());
        transactionDto.setUpdated_at(transaction.getUpdated_at());

        return transactionDto;
    }
    @Override
    public List<TransactionDto> findAll() {

        return  transactionRepository.findAll()
                .stream()
                .map(this::convertEntityDto)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Long idTransaction) {
        Optional<Transaction> transaction = transactionRepository.findById(idTransaction);

        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setIdTransaction(transaction.get().getIdTransaction());
        transactionDto.setAmount(transaction.get().getAmount());
        transactionDto.setConcept(transaction.get().getConcept());
        transactionDto.setEnterprise(transaction.get().getEnterprise().getName());
        transactionDto.setEmployee(transaction.get().getEmployee().getProfile().getName());
        transactionDto.setCreated_at(transaction.get().getCreated_at());
        transactionDto.setUpdated_at(transaction.get().getUpdated_at());

        return transactionDto;
    }

    @Override
    public Transaction create(Transaction entity) {

        entity = transactionRepository.save(entity);
        System.out.println(entity);
        return entity;

    }

    @Override
    public Transaction update(Long id, Transaction entity) {

        Optional<Transaction> transactionUpdate = transactionRepository.findById(id);
        Transaction transaction = transactionUpdate.get();

        if (entity.getAmount() != 0.0){
            transaction.setAmount(entity.getAmount());
        }
        if (entity.getConcept() != null){
            transaction.setConcept(entity.getConcept());
        }
        if (entity.getEnterprise() != null){
            transaction.setEnterprise(entity.getEnterprise());
        }
        if (entity.getEmployee() != null){
            transaction.setEmployee(entity.getEmployee());
        }
        if (entity.getCreated_at() != null){
            transaction.setCreated_at(entity.getCreated_at());
        }
        if (entity.getUpdated_at() != null){
            transaction.setUpdated_at(entity.getUpdated_at());
        }

        return transactionRepository.save(entity);

    }

    @Override
    public boolean delete(Long id) {

        transactionRepository.deleteById(id);
        return true;

    }

    public List<Transaction> getTransactionEmployee(Long idEmployee) {
        return transactionRepository.findByEmployeeIdEmployee(idEmployee);
    }
}


