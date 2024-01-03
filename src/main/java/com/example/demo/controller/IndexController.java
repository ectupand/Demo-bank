package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.model.ClientModel;
import com.example.demo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class IndexController {
    private final ClientService clientService;

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("clients", clientService.readAll());
        model.addAttribute("newClient", new Client());
        return "index";
    }

    @PostMapping(value = "/processForm")
    public String createClient(@ModelAttribute("newClient") ClientModel newClient, Model model){
        clientService.create(newClient);
        return "redirect:/";
    }

}
