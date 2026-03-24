package com.aryaman.bank_statement_analyzer.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String paymentMode;

    private String counterparty;

    private Double amount;

    private String type;

    private String rawDescription;

    private String category;
}