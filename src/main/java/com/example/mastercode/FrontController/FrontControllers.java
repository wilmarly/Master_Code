package com.example.mastercode.FrontController;

import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.Interface.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControllers {

    TransactionService transactionService;

    public FrontControllers(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String index(){return "index";}


    @GetMapping("/transactions")
    private String Transactions (Model model){
        model.addAttribute("transactions",transactionService.findAll());
        return "transactions";
    }
    @GetMapping("transactions/new")
    public String newTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "new-transaction";
    }

}
