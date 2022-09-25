package com.example.mastercode.FrontController;

import com.example.mastercode.dto.TransactionByEnterpriseResponse;
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

import java.time.LocalDate;


@Controller
public class FrntCtrllerTransaction {

    private final TransactionService instance;

    public FrntCtrllerTransaction(TransactionService instance) {
        this.instance = instance;
    }

    @PostMapping("/transaction/new")
    public RedirectView createTransaction(@ModelAttribute @DateTimeFormat(pattern = "YY-MM-DD") Transaction transaction, Model model) {

        model.addAttribute(transaction);

        this.instance.create(transaction);

        return new RedirectView("/transactions");
    }
}
