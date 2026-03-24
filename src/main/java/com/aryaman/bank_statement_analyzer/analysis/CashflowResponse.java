package com.aryaman.bank_statement_analyzer.analysis;

public class CashflowResponse {

    private Double totalDebits;
    private Double totalCredits;
    private Double netCashflow;

    public CashflowResponse(Double totalDebits, Double totalCredits, Double netCashflow) {
        this.totalDebits = totalDebits;
        this.totalCredits = totalCredits;
        this.netCashflow = netCashflow;
    }

    public Double getTotalDebits() {
        return totalDebits;
    }

    public Double getTotalCredits() {
        return totalCredits;
    }

    public Double getNetCashflow() {
        return netCashflow;
    }
}