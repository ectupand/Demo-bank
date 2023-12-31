package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.model.ClientModel;
import com.example.demo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/client")
    public ResponseEntity<List<Client>> readAll() {
        return new ResponseEntity<>(clientService.readAll(), HttpStatus.OK);
    }
    @GetMapping("/client/")
    public ResponseEntity<List<Client>> readByName(@RequestParam(value="name") String name){
        return new ResponseEntity<>(clientService.readByName(name), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> readById(@PathVariable Long id){
        return new ResponseEntity<>(clientService.readById(id), HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<Client> create(@RequestBody ClientModel model) {
        return new ResponseEntity<>(clientService.create(model), HttpStatus.OK);
    }

    @PostMapping("/client/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id){
        return new ResponseEntity<>(clientService.update(clientService.readById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/client/{id}")
    public HttpStatus delete(@PathVariable Long id){
        clientService.delete(id);
        return HttpStatus.OK;
    }

}
