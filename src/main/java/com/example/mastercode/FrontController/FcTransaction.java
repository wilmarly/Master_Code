package com.example.mastercode.FrontController;

import com.example.mastercode.dto.TransactionByEnterpriseResponse;
import com.example.mastercode.dto.TransactionDto;
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
public class FcTransaction {

    private final TransactionService instance;

    public FcTransaction(TransactionService instance) {
        this.instance = instance;
    }


    @GetMapping("/transactions")
    private String Transactions (Model model){
        model.addAttribute("transactions",instance.findAll());
        return "transactions";
    }

    @PostMapping("/transaction/new")
    public RedirectView createTransaction(@ModelAttribute @DateTimeFormat
            (pattern = "YY-MM-DD") Transaction transaction, Model model) {
        model.addAttribute(transaction);
        this.instance.create(transaction);

        return new RedirectView("/transactions");
    }

    @GetMapping("transactions/new")
    public String newTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "new-transaction";
    }
}
