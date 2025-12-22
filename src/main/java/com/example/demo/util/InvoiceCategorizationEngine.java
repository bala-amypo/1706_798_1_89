package com.example.demo.util;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules) {

        rules.sort((a, b) -> b.getPriority() - a.getPriority());

        for (CategorizationRule rule : rules) {

            String desc = invoice.getDescription();

            if ("EXACT".equals(rule.getMatchType()) &&
                desc.equalsIgnoreCase(rule.getKeyword()))
                return rule.getCategory();

            if ("CONTAINS".equals(rule.getMatchType()) &&
                desc.toLowerCase().contains(rule.getKeyword().toLowerCase()))
                return rule.getCategory();

            if ("REGEX".equals(rule.getMatchType()) &&
                Pattern.compile(rule.getKeyword()).matcher(desc).find())
                return rule.getCategory();
        }
        return null;
    }
}
