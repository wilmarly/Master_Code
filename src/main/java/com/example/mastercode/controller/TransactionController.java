package com.example.mastercode.controller;

import com.example.mastercode.dto.TransactionDto;
import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.TransactionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("transaction")
public class TransactionController {
    private final TransactionServiceImpl transactionServiceImpl;

    public TransactionController(TransactionServiceImpl transactionServiceImpl) {
        this.transactionServiceImpl = transactionServiceImpl;
    }

    @GetMapping()
    public List<TransactionDto> getTransactionList() {
        return transactionServiceImpl.findAll();
    }


    @PostMapping()
    public Transaction createTransaction(@RequestBody Transaction request)  {
        System.out.println(request);
        return transactionServiceImpl.create(request);
    }

    @GetMapping("/{id}")
    public Optional<TransactionDto> getTransactionId(@PathVariable Long id) {
        return Optional.ofNullable(transactionServiceImpl.findById(id));
    }

    @GetMapping("/transaction-by-employee/{idEmployee}")
    public List<Transaction> getTransactionEmployee(@PathVariable Long idEmployee) {
        return transactionServiceImpl.getTransactionEmployee(idEmployee);
    }

    @PatchMapping("/{id}")
    public Transaction modifyTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionServiceImpl.update(id, transaction);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTransaction(@PathVariable Long id) {
        return transactionServiceImpl.delete(id);
    }
}
