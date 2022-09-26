package com.example.mastercode.FrontController;

import com.example.mastercode.dto.EnterpriseDto;
import com.example.mastercode.dto.TransactionByEnterpriseResponse;
import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.Interface.EmployeeService;
import com.example.mastercode.services.Interface.EnterpriseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class FcEnterprise {

    private final EnterpriseService instance;

    public FcEnterprise(EnterpriseService instance) {
        this.instance = instance;
    }



    @GetMapping("/enterprises/{id}/transactions")
    public String getTransactionByEnterprise(@PathVariable("id") Long id, Model model){
        TransactionByEnterpriseResponse transaction = instance.transactionByEnterprise(id);
                model.addAttribute("transactionList",transaction);
        return null;
    }

}
