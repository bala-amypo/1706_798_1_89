package com.example.demo.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        String description = invoice.getDescription();

        for (CategorizationRule rule : rules) {

            // EXACT match
            if ("EXACT".equalsIgnoreCase(rule.getRuleType())
                    && description.equals(rule.getPattern())) {
                return rule.getCategory();
            }

            // CONTAINS match
            if ("CONTAINS".equalsIgnoreCase(rule.getRuleType())
                    && description.contains(rule.getPattern())) {
                return rule.getCategory();
            }

            // REGEX match
            if ("REGEX".equalsIgnoreCase(rule.getRuleType())
                    && description.matches(rule.getPattern())) {
                return rule.getCategory();
            }
        }

        return null; // No rule matched
    }
}
