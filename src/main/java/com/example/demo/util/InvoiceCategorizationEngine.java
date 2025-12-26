package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice, List<CategorizationRule> rules) {

        if (invoice == null || rules == null || rules.isEmpty()) {
            return null;
        }

        String description = invoice.getDescription();
        if (description == null) {
            return null;
        }

        // ✅ FIX: copy rules before sorting (tests pass immutable list)
        List<CategorizationRule> sortedRules = new ArrayList<>(rules);
        sortedRules.sort(
                Comparator.comparing(CategorizationRule::getPriority).reversed()
        );

        for (CategorizationRule rule : sortedRules) {

            String keyword = rule.getKeyword();
            String matchType = rule.getMatchType();

            if (keyword == null || matchType == null) {
                continue;
            }

            switch (matchType) {

                case "EXACT":
                    if (description.equalsIgnoreCase(keyword)) {
                        return rule.getCategory();
                    }
                    break;

                case "CONTAINS":
                    if (description.toLowerCase()
                            .contains(keyword.toLowerCase())) {
                        return rule.getCategory();
                    }
                    break;

                case "REGEX":
                    if (Pattern.compile(keyword, Pattern.CASE_INSENSITIVE)
                            .matcher(description)
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
}
