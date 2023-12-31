package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BankAccount sender_account_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BankAccount receiver_account_id;
    @Column(nullable = false, columnDefinition="decimal", precision=15, scale=2)
    private BigDecimal moneyAmount;
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime created_at;

}
