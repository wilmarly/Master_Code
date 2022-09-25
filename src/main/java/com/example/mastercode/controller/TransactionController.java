package com.example.mastercode.controller;

import com.example.mastercode.dto.TransactionDto;
import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.Interface.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("transaction")
public class TransactionController {
    private final TransactionService instance;

    public TransactionController(TransactionService instance) {
        this.instance = instance;
    }

    @GetMapping()
    public List<TransactionDto> getTransactionList() {
        return instance.findAll();
    }


//    @PostMapping()
//    public Transaction createTransaction(@RequestBody Transaction request)  {
//        return instance.create(request);
//    }

    @GetMapping("/{id}")
    public Optional<TransactionDto> getTransactionId(@PathVariable Long id) {
        return Optional.ofNullable(instance.findById(id));
    }

    @GetMapping("/transaction-by-employee/{idEmployee}")
    public List<Transaction> getTransactionEmployee(@PathVariable Long idEmployee) {
        return instance.getTransactionEmployee(idEmployee);
    }

    @PatchMapping("/{id}")
    public Transaction modifyTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return instance.update(id, transaction);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTransaction(@PathVariable Long id) {
        return instance.delete(id);
    }
}
