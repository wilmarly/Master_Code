package com.example.mastercode.services.contracts;

import com.example.mastercode.dto.TransactionDTO;

import java.util.List;

public interface TransactionBusiness extends BaseService<TransactionDTO> {

    List<TransactionDTO> findAllByEnterprise(String nit);
}
