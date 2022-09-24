package com.example.mastercode.controller;

import com.example.mastercode.dto.TransactionDTO;
import com.example.mastercode.services.contracts.TransactionBusiness;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/transaction")
public class TransactionController implements BaseController<TransactionDTO> {
    private final TransactionBusiness service;

    public TransactionController(final TransactionBusiness service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<TransactionDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<TransactionDTO> findById(final Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<TransactionDTO> create(final TransactionDTO entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @Override
    public ResponseEntity<TransactionDTO> update(final Long id, final TransactionDTO entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @Override
    public ResponseEntity<Boolean> delete(final Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(path = "/enterprise/{nit}")
    public ResponseEntity<List<TransactionDTO>> allTransactionsByEnterprise(@PathVariable String nit) {
        return ResponseEntity.ok(service.findAllByEnterprise(nit));
    }
}
