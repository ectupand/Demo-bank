package com.example.demo.controller;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.Client;
import com.example.demo.model.BankAccountModel;
import com.example.demo.service.BankAccountService;
import com.example.demo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ClientsController {
    private final BankAccountService bankAccountService;
    private final ClientService clientService;

    @GetMapping("/client")
    public String getClients(Model model){
        model.addAttribute("clients", clientService.readAll());
        model.addAttribute("newAccount", new BankAccount());
        return "clientsList";
    }

    @PostMapping(value = "/client/create-account")
    public String createClient(@ModelAttribute("newAccount") BankAccountModel newBankAccount){
        bankAccountService.create(newBankAccount);
        return "redirect:/client";
    }
}
