package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class IndexController {
    private final ClientService clientService;

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("clients", clientService.readAll());
        return "index";
    }
}
