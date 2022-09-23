package com.example.mastercode.controller;

import com.example.mastercode.dto.TransactionDto;
import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.TransactionServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {
    private final TransactionServiceImpl transactionServiceImpl;

    public TransactionController(TransactionServiceImpl transactionServiceImpl) {
        this.transactionServiceImpl = transactionServiceImpl;
    }
/*
    @GetMapping()
    public List<TransactionDto> getTransactionList() {
        return transactionServiceImpl.findAll();
    }*/

    @PostMapping("/transaction")
    public RedirectView createTransaction(@ModelAttribute @DateTimeFormat(pattern = "YY-MM-DD" ) Transaction transaction, Model model)
    {
        model.addAttribute(transaction);
        this.transactionServiceImpl.create(transaction);
        return new RedirectView("/transactions");
    }
/*
    @PostMapping()
    public Transaction createTransaction(@RequestBody Transaction request)  {
        System.out.println(request);
        return transactionServiceImpl.create(request);
    }
*/
    @GetMapping("/transaction/{id}")
    public Optional<TransactionDto> getTransactionId(@PathVariable Long id) {
        return Optional.ofNullable(transactionServiceImpl.findById(id));
    }

    @GetMapping("/transaction/transaction-by-employee/{idEmployee}")
    public List<Transaction> getTransactionEmployee(@PathVariable Long idEmployee) {
        return transactionServiceImpl.getTransactionEmployee(idEmployee);
    }

    @PatchMapping("/transaction/{id}")
    public Transaction modifyTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionServiceImpl.update(id, transaction);
    }

    @DeleteMapping("/transaction/{id}")
    public boolean deleteTransaction(@PathVariable Long id) {
        return transactionServiceImpl.delete(id);
    }
}
