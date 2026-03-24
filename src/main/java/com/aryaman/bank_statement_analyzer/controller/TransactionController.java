package com.aryaman.bank_statement_analyzer.controller;

import com.aryaman.bank_statement_analyzer.model.Transaction;
import com.aryaman.bank_statement_analyzer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        System.out.println(transaction);
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/bulk")
    public List<Transaction> addTransactions(@RequestBody List<Transaction> transactions) {
        return transactionService.saveAll(transactions);
    }
}