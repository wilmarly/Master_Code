package com.example.mastercode.FrontController;

import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.Interface.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class FcTransactionController {

    private final TransactionService instance;

    public FcTransactionController(TransactionService instance) {
        this.instance = instance;
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
        this.instance.create(transaction);
        return new RedirectView("/transactions");
    }

    @GetMapping("/transactions")
    private String Transactions (Model model){
        model.addAttribute("transactions",instance.findAll());
        return "transactions";
    }

    @GetMapping("/enterprises/{id}/transactions")
    public String getTransactionByEnterprise(@PathVariable("id") Long id, Model model){

        List<Transaction> transaction = instance.findAllByEnterprise(id);

        model.addAttribute("transactionList",transaction);

        return "transactions";
    }
}
