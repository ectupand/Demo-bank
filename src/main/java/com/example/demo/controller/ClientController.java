package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.model.ClientModel;
import com.example.demo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<Client> create(@RequestBody ClientModel model) {
        return new ResponseEntity<>(clientService.create(model), HttpStatus.OK);
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>> readAll() {
        return new ResponseEntity<>(clientService.readAll(), HttpStatus.OK);
    }
    @GetMapping("/client/")
    public List<Client> readByName(@RequestParam(value="name") String name){
        return clientService.readByName(name);
    }

    @GetMapping("/client/{id}")
    public Client readById(@PathVariable Long id){
        return clientService.readById(id);
    }

    @PostMapping("/client/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id){
        return new ResponseEntity<>(clientService.update(clientService.findById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/client/{id}")
    public HttpStatus delete(@PathVariable Long id){
        clientService.delete(id);
        return HttpStatus.OK;
    }

}
