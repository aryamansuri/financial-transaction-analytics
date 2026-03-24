package com.aryaman.bank_statement_analyzer.service;

import com.aryaman.bank_statement_analyzer.analysis.CashflowResponse;
import com.aryaman.bank_statement_analyzer.analysis.MerchantResponse;
import com.aryaman.bank_statement_analyzer.analysis.RiskResponse;
import com.aryaman.bank_statement_analyzer.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AnalysisService {

    @Autowired
    private TransactionRepository transactionRepository;

    public CashflowResponse getCashflow() {

        Double totalDebits = transactionRepository.getTotalDebits();
        Double totalCredits = transactionRepository.getTotalCredits();

        if (totalDebits == null) totalDebits = 0.0;
        if (totalCredits == null) totalCredits = 0.0;

        Double net = totalCredits - totalDebits;

        return new CashflowResponse(
                totalDebits,
                totalCredits,
                net
        );
    }

    public Map<String, Double> getSpendingByCategory() {

        List<Object[]> results = transactionRepository.getSpendingByCategory();

        Map<String, Double> response = new HashMap<>();

        for (Object[] row : results) {
            String category = (String) row[0];
            Double total = (Double) row[1];

            if (category == null) {
                category = "Other";
            }

            response.put(category, total);
        }

        return response;
    }

    public Map<String, Double> getMonthlySpending() {

        List<Object[]> results = transactionRepository.getMonthlySpending();

        Map<String, Double> response = new LinkedHashMap<>();

        for (Object[] row : results) {
            String month = (String) row[0];
            Double total = (Double) row[1];

            response.put(month, total);
        }

        return response;
    }

    public List<MerchantResponse> getTopMerchants() {

        List<Object[]> results = transactionRepository.getTopMerchants();

        List<MerchantResponse> response = new ArrayList<>();

        for (Object[] row : results) {
            String merchant = (String) row[0];
            Double total = (Double) row[1];

            if (merchant == null) merchant = "Unknown";

            response.add(new MerchantResponse(merchant, total));
        }

        return response;
    }

    public RiskResponse getRiskAnalysis() {

        // Cashflow
        Double debits = transactionRepository.getTotalDebits();
        Double credits = transactionRepository.getTotalCredits();

        if (debits == null) debits = 0.0;
        if (credits == null) credits = 0.0;

        boolean negativeCashflow = credits < debits;

        // Category breakdown
        List<Object[]> categoryData = transactionRepository.getSpendingByCategory();

        double totalSpending = 0;
        for (Object[] row : categoryData) {
            totalSpending += (Double) row[1];
        }

        List<String> highSpendingCategories = new ArrayList<>();

        for (Object[] row : categoryData) {
            String category = (String) row[0];
            Double amount = (Double) row[1];

            if (category == null) category = "Other";

            if (totalSpending > 0 && (amount / totalSpending) > 0.4) {
                highSpendingCategories.add(category);
            }
        }

        // 3. Top merchant dependency
        List<Object[]> merchantData = transactionRepository.getTopMerchants();

        boolean topMerchantDependency = false;

        if (!merchantData.isEmpty()) {
            Double topMerchantAmount = (Double) merchantData.get(0)[1];

            if (totalSpending > 0 && (topMerchantAmount / totalSpending) > 0.5) {
                topMerchantDependency = true;
            }
        }

        return new RiskResponse(
                highSpendingCategories,
                negativeCashflow,
                topMerchantDependency
        );
    }
}