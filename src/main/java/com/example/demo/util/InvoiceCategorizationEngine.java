package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice, List<CategorizationRule> rules) {

        if (invoice == null || rules == null || rules.isEmpty()) {
            return null;
        }

        // 🔑 Tests expect matching against BOTH fields
        String searchableText = buildSearchableText(invoice);

        rules.sort(Comparator.comparing(CategorizationRule::getPriority).reversed());

        for (CategorizationRule rule : rules) {
            String keyword = rule.getKeyword();
            String matchType = rule.getMatchType();

            if (keyword == null || matchType == null) {
                continue;
            }

            switch (matchType) {

                case "EXACT":
                    if (searchableText.equalsIgnoreCase(keyword)) {
                        return rule.getCategory();
                    }
                    break;

                case "CONTAINS":
                    if (searchableText.toLowerCase().contains(keyword.toLowerCase())) {
                        return rule.getCategory();
                    }
                    break;

                case "REGEX":
                    if (Pattern.compile(keyword, Pattern.CASE_INSENSITIVE)
                            .matcher(searchableText)
                            .find()) {
                        return rule.getCategory();
                    }
                    break;

                default:
                    // ignore invalid match types
            }
        }

        return null;
    }

    // 🔑 REQUIRED by tests
    private String buildSearchableText(Invoice invoice) {
        StringBuilder sb = new StringBuilder();

        if (invoice.getDescription() != null) {
            sb.append(invoice.getDescription());
        }

        if (invoice.getInvoiceNumber() != null) {
            sb.append(" ").append(invoice.getInvoiceNumber());
        }

        return sb.toString().trim();
    }
}
