package com.aryaman.bank_statement_analyzer.controller;

import com.aryaman.bank_statement_analyzer.analysis.CashflowResponse;
import com.aryaman.bank_statement_analyzer.analysis.MerchantResponse;
import com.aryaman.bank_statement_analyzer.analysis.RiskResponse;
import com.aryaman.bank_statement_analyzer.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/cashflow")
    public CashflowResponse getCashflow() {
        return analysisService.getCashflow();
    }

    @GetMapping("/categories")
    public Map<String, Double> getCategorySpending() {
        return analysisService.getSpendingByCategory();
    }

    @GetMapping("/monthly")
    public Map<String, Double> getMonthlySpending() {
        return analysisService.getMonthlySpending();
    }

    @GetMapping("/top-merchants")
    public List<MerchantResponse> getTopMerchants() {
        return analysisService.getTopMerchants();
    }

    @GetMapping("/risk")
    public RiskResponse getRiskAnalysis() {
        return analysisService.getRiskAnalysis();
    }
}