package com.example.mastercode.FrontController;

import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.entities.Transaction;
import com.example.mastercode.services.Interface.EnterpriseService;
import com.example.mastercode.services.Interface.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class FcEnterpriseController {

    private final EnterpriseService enterpriseService;
    private final TransactionService transactionService;

    public FcEnterpriseController(EnterpriseService enterpriseService, TransactionService transactionService) {
        this.enterpriseService = enterpriseService;
        this.transactionService = transactionService;
    }

    //Mostrar todas las empresas
    @GetMapping("/enterprises")
    private String Enterprises(Model model) {
        model.addAttribute("enterprises", enterpriseService.findAll());
        return "enterprises";
    }

    // crear una empresa
    @GetMapping("enterprises/new")
    public String formEnterprise(Model model) {
        model.addAttribute("enterprise", new Enterprise());
        return "new-enterprise";
    }

    @PostMapping("/enterprises/new")
    public RedirectView createEnterprise(@ModelAttribute @DateTimeFormat
            (pattern = "YY-MM-DD") Enterprise enterprise, Model model) {
        model.addAttribute(enterprise);
        this.enterpriseService.create(enterprise);
        return new RedirectView("/enterprises");
    }

    //Editar una empresa
    @GetMapping("/enterprises/{id}")
    public String formModifyEnterprise(@PathVariable Long id, Model model) {
        model.addAttribute("modify", enterpriseService.findById(id));
        return "modify-enterprise";
    }

    @PostMapping("/enterprises/{id}")
    public RedirectView modifyEnterprise(@PathVariable Long id, Enterprise enterprise, Model model) {
        model.addAttribute("modify", enterpriseService.update(id, enterprise));
        return new RedirectView("/enterprises");
    }

    //Eliminar una empresa
    @GetMapping("/enterprises/delete/{id}")
    String deleteEnterprise(@PathVariable Long id) {
        enterpriseService.delete(id);
        return "redirect:/enterprises";
    }
}
