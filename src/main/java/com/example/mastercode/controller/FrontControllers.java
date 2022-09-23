package com.example.mastercode.controller;

import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.TransactionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontControllers {

    TransactionServiceImpl transactionServiceImpl;

    public FrontControllers(TransactionServiceImpl transactionServiceImpl) {
        this.transactionServiceImpl = transactionServiceImpl;
    }

    @GetMapping("/")
    public String index(){return "index";}


    @GetMapping("/transactions")
    private String Transactions (Model model){
        model.addAttribute("transactions",transactionServiceImpl.findAll());
        return "transactions";
    }
    @GetMapping("transactions/new")
    public String newTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "new-transaction";
    }

}
