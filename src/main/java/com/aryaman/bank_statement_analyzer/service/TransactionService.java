package com.aryaman.bank_statement_analyzer.service;

import com.aryaman.bank_statement_analyzer.model.Transaction;
import com.aryaman.bank_statement_analyzer.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aryaman.bank_statement_analyzer.utils.CategoryUtils;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {

        String category = CategoryUtils.categorize(transaction.getCounterparty());
        transaction.setCategory(category);

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> saveAll(List<Transaction> transactions) {
        for (Transaction t : transactions) {
            String category = CategoryUtils.categorize(t.getCounterparty());
            t.setCategory(category);
        }

        return transactionRepository.saveAll(transactions);
    }
}