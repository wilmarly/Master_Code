package com.example.mastercode.FrontController;

import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.Interface.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControllers {

    @GetMapping("/")
    public String index(){return "index";}
}
