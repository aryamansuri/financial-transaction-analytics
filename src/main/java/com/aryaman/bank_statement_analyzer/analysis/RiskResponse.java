package com.aryaman.bank_statement_analyzer.analysis;

import java.util.List;

public class RiskResponse {

    private List<String> highSpendingCategories;
    private boolean negativeCashflow;
    private boolean topMerchantDependency;

    public RiskResponse(List<String> highSpendingCategories,
                        boolean negativeCashflow,
                        boolean topMerchantDependency) {
        this.highSpendingCategories = highSpendingCategories;
        this.negativeCashflow = negativeCashflow;
        this.topMerchantDependency = topMerchantDependency;
    }

    public List<String> getHighSpendingCategories() {
        return highSpendingCategories;
    }

    public boolean isNegativeCashflow() {
        return negativeCashflow;
    }

    public boolean isTopMerchantDependency() {
        return topMerchantDependency;
    }
}