package com.example.demo.controller;

import com.example.demo.entity.BankAccount;
import com.example.demo.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @GetMapping("/account")
    public ResponseEntity<List<BankAccount>> readAll(){
        return new ResponseEntity<>(bankAccountService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/account/")
    public ResponseEntity<List<BankAccount>> readByName(@RequestParam(value = "name") String name){
        return new ResponseEntity<>(bankAccountService.readByName(name), HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<List<BankAccount>> readById(@PathVariable Long id){
        return new ResponseEntity<>(bankAccountService.readByClientId(id), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<BankAccount> create(@RequestBody BankAccount model) {
        return new ResponseEntity<>(bankAccountService.create(model), HttpStatus.OK);
    }

    @PostMapping("/account/{id}")
    public ResponseEntity<BankAccount> update(@PathVariable Long id){
        Optional<BankAccount> bankAccount = bankAccountService.readByAccountId(id);
        return bankAccount.map(account
                -> new ResponseEntity<>(bankAccountService.update(account), HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(new BankAccount(), HttpStatus.OK)
        );
    }

    @DeleteMapping("/account/{id}")
    public HttpStatus delete(@PathVariable Long id){
        bankAccountService.delete(id);
        return HttpStatus.OK;
    }
}
