package com.example.demo.service;

import com.example.demo.entity.BankAccount;
import com.example.demo.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccount create(BankAccount model){
        BankAccount bankAccount = BankAccount.builder()
                .client(model.getClient())
                .balance(model.getBalance())
                .build();
        return bankAccountRepository.save(bankAccount);
    }

    public List<BankAccount> readAll(){
        return bankAccountRepository.findAll();
    }

    public List<BankAccount> readByName(String name){
        return bankAccountRepository.findByClientName(name);
    }

    public List<BankAccount> readByClientId(Long id){
        return bankAccountRepository.findByClientId(id);
    }

    public Optional<BankAccount> readByAccountId(Long id){
        return bankAccountRepository.findById(id);
    }

    public void delete(Long id) {
        bankAccountRepository.deleteById(id);
    }

    public BankAccount update(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

}
