package com.example.mastercode.services.Interface;

import com.example.mastercode.dto.EnterpriseDto;
import com.example.mastercode.dto.TransactionByEnterpriseResponse;
import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.entities.Transaction;

import java.util.List;

public interface EnterpriseService {
    List<EnterpriseDto> findAll();
    EnterpriseDto findById(Long id);
    Enterprise create(Enterprise entity);
    Enterprise update(Long id, Enterprise entity);
    void delete (Long id);
    TransactionByEnterpriseResponse transactionByEnterprise(Long idEnterprises);

}
