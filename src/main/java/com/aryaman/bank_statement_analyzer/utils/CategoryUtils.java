package com.aryaman.bank_statement_analyzer.utils;

import java.util.Map;

public class CategoryUtils {

    private static final Map<String, String> categoryMap = Map.ofEntries(
            Map.entry("swiggy", "Food"),
            Map.entry("zomato", "Food"),
            Map.entry("amazon", "Shopping"),
            Map.entry("amzn", "Shopping"),
            Map.entry("flipkart", "Shopping"),
            Map.entry("uber", "Transport"),
            Map.entry("ola", "Transport"),
            Map.entry("netflix", "Subscription"),
            Map.entry("spotify", "Subscription"),
            Map.entry("salary", "Income")
    );

    public static String categorize(String counterparty) {

        if (counterparty == null) return "Other";

        String lower = counterparty.toLowerCase();

        for (String key : categoryMap.keySet()) {
            if (lower.contains(key)) {
                return categoryMap.get(key);
            }
        }

        return "Other";
    }
}