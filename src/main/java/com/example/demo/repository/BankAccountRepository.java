package com.example.demo.repository;

import com.example.demo.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findByClientName(String name);
    List<BankAccount> findByClientId(Long id);
}
