package com.example.demo.controller;

import com.example.demo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ClientsController {
    private final ClientService clientService;

    @GetMapping("/client")
    public String getClients(Model model){
        model.addAttribute("clients", clientService.readAll());
        return "clientsList";
    }
}
