package com.aryaman.bank_statement_analyzer.analysis;

public class MerchantResponse {

    private String merchant;
    private Double total;

    public MerchantResponse(String merchant, Double total) {
        this.merchant = merchant;
        this.total = total;
    }

    public String getMerchant() {
        return merchant;
    }

    public Double getTotal() {
        return total;
    }
}