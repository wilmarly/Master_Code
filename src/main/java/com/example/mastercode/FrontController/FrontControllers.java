package com.example.mastercode.FrontController;

import com.example.mastercode.entities.Transaction;
import com.example.mastercode.entities.User;
import com.example.mastercode.services.Interface.TransactionService;
import com.example.mastercode.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControllers {

    UserService userService;

    public FrontControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal)
    {
        if(principal != null){
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user", user);
        }
        return "index";

    }
}
