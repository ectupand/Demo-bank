package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.service.BankAccountService;
import com.example.demo.service.ClientService;
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
    public String getClientInfo(Model model, @PathVariable String id){
        model.addAttribute("accounts", bankAccountService.readByClientId(Long.valueOf(id)));
        model.addAttribute("id", id);
        return "clientInfo";
    }
}
