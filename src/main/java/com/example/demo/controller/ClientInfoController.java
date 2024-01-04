package com.example.demo.controller;

import com.example.demo.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@AllArgsConstructor
public class ClientInfoController {
    private final BankAccountService bankAccountService;

    @GetMapping("/client/{id}")
    public String getClientInfo(Model model, @PathVariable Long id){
        model.addAttribute("accounts", bankAccountService.readByClientId(id));
        model.addAttribute("id", id);
        return "clientInfo";
    }
}
