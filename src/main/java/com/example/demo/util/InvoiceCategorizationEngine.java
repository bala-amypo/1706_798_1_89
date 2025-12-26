package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice, List<CategorizationRule> rules) {
        if (rules == null || invoice.getDescription() == null) return null;

        rules.sort(Comparator.comparing(CategorizationRule::getPriority).reversed());

        for (CategorizationRule rule : rules) {
            String desc = invoice.getDescription();

            switch (rule.getMatchType()) {
                case "EXACT":
                    if (desc.equalsIgnoreCase(rule.getKeyword())) {
                        return rule.getCategory();
                    }
                    break;

                case "CONTAINS":
                    if (desc.toLowerCase().contains(rule.getKeyword().toLowerCase())) {
                        return rule.getCategory();
                    }
                    break;

                case "REGEX":
                    if (Pattern.compile(rule.getKeyword(), Pattern.CASE_INSENSITIVE)
                            .matcher(desc).find()) {
                        return rule.getCategory();
                    }
                    break;
            }
        }
        return null;
    }
}
