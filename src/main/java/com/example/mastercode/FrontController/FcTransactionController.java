package com.example.mastercode.FrontController;

import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.Interface.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

@Controller
public class FcTransactionController {

    private final TransactionService transactionService;

    public FcTransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    //Crear una transaccion
    @GetMapping("transactions/new")
    public String newTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "new-transaction";
    }

    @PostMapping("/transactions/new")
    public RedirectView createTransaction(@ModelAttribute @DateTimeFormat
            (pattern = "YY-MM-DD") Transaction transaction, Model model) {
        model.addAttribute(transaction);
        this.transactionService.create(transaction);
        return new RedirectView("/transactions");
    }

    @GetMapping("/transactions")
    private String Transactions (Model model){
        model.addAttribute("transactions", transactionService.findAll());
        return "transactions";
    }
    @GetMapping("/transactions/enterprises/{id}")
    public String getTransactionByEnterprise(@PathVariable Long id, Model model){
        List<Transaction> transaction = transactionService.findAllByEnterprise(id);
        model.addAttribute("transactionList",transaction);
        System.out.println(model);
        return "transactionsById";
    }


}
