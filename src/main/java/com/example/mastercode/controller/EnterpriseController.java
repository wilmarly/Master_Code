package com.example.mastercode.controller;

import com.example.mastercode.dto.EnterpriseDto;
import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.services.EnterpriseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("enterprise")
public class EnterpriseController {
    private final EnterpriseServiceImpl enterpriseServiceImpl;

    public EnterpriseController(EnterpriseServiceImpl enterpriseServiceImpl) {
        this.enterpriseServiceImpl = enterpriseServiceImpl;
    }

    @GetMapping()
    public List<EnterpriseDto> getEnterpriseList() {
        return enterpriseServiceImpl.findAll();
    }

    @PostMapping()
    public Enterprise createEnterprise(@RequestBody Enterprise request) {
        return enterpriseServiceImpl.create(request);
    }

    @GetMapping("/{id}")
    public Optional<EnterpriseDto> getEnterpriseId(@PathVariable Long id) {
        return Optional.ofNullable(enterpriseServiceImpl.findById(id));
    }

    @PatchMapping("/{id}")
    public Enterprise modifyEnterprise(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        return enterpriseServiceImpl.update(id, enterprise);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEnterprise(@PathVariable Long id){
        return enterpriseServiceImpl.delete(id);
    }
}
