package com.example.demo.model;

import com.example.demo.entity.Client;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountModel {
    private Client client;
    private BigDecimal balance;
    private String name;
}
