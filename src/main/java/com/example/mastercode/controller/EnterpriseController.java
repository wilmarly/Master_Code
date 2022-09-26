package com.example.mastercode.controller;

import com.example.mastercode.dto.EnterpriseDto;
import com.example.mastercode.dto.TransactionByEnterpriseResponse;
import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.Interface.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/enterprise")
public class EnterpriseController {
    private final EnterpriseService instance;//Se inyecta la interfase

    public EnterpriseController(EnterpriseService instance) {
        this.instance = instance;
    }

    @GetMapping()
    public List<EnterpriseDto> getEnterpriseList() {
        return instance.findAll();
    }

    @PostMapping()
    public Enterprise createEnterprise(@RequestBody Enterprise request) {
        return instance.create(request);
    }

    @GetMapping("/{id}")
    public Optional<EnterpriseDto> getEnterpriseId(@PathVariable Long id) {
        return Optional.ofNullable(instance.findById(id));
    }

    @PatchMapping("/{id}")
    public Enterprise modifyEnterprise(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        return instance.update(id, enterprise);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEnterprise(@PathVariable Long id){
        return instance.delete(id);
    }
    
    @GetMapping("/transaction_by_enterprise/{id}")
    public TransactionByEnterpriseResponse getTransactionByEnterprise(@PathVariable Long id){
        return instance.transactionByEnterprise(id);
    }
}
