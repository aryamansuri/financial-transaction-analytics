package com.aryaman.bank_statement_analyzer.repository;

import com.aryaman.bank_statement_analyzer.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = 'DEBIT'")
    Double getTotalDebits();

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = 'CREDIT'")
    Double getTotalCredits();

    @Query("""
        SELECT COALESCE(t.category, 'Other'), SUM(t.amount)
        FROM Transaction t
        WHERE t.type = 'DEBIT'
        GROUP BY COALESCE(t.category, 'Other')
    """)
    List<Object[]> getSpendingByCategory();

    @Query("""
        SELECT FUNCTION('TO_CHAR', t.date, 'YYYY-MM'), SUM(t.amount)
        FROM Transaction t
        WHERE t.type = 'DEBIT'
        GROUP BY FUNCTION('TO_CHAR', t.date, 'YYYY-MM')
        ORDER BY FUNCTION('TO_CHAR', t.date, 'YYYY-MM')
    """)
    List<Object[]> getMonthlySpending();

    @Query("""
        SELECT t.counterparty, SUM(t.amount)
        FROM Transaction t
        WHERE t.type = 'DEBIT'
        GROUP BY t.counterparty
        ORDER BY SUM(t.amount) DESC
    """)
    List<Object[]> getTopMerchants();
}
