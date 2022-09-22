package com.example.mastercode.dto;

import java.util.List;

public class TransactionByEnterpriseResponse {
    private Long idEnterprise;
    private String nameEnterprise;
    private List<TransactionShortDto> transactionList;

    public Long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(Long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getNameEnterprise() {
        return nameEnterprise;
    }

    public void setNameEnterprise(String nameEnterprise) {
        this.nameEnterprise = nameEnterprise;
    }

    public List<TransactionShortDto> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<TransactionShortDto> transactionList) {
        this.transactionList = transactionList;
    }
}


