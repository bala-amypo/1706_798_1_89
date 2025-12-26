package com.example.demo.util;

import com.example.demo.model.*;

import java.util.Comparator;
import java.util.List;

public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice, List<CategorizationRule> rules) {

        return rules.stream()
                .filter(r -> {
                    String desc = invoice.getDescription();
                    if (desc == null) return false;

                    return switch (r.getMatchType()) {
                        case "EXACT" -> desc.equalsIgnoreCase(r.getKeyword());
                        case "CONTAINS" -> desc.toLowerCase().contains(r.getKeyword().toLowerCase());
                        case "REGEX" -> desc.matches(r.getKeyword());
                        default -> false;
                    };
                })
                .max(Comparator.comparingInt(CategorizationRule::getPriority))
                .map(CategorizationRule::getCategory)
                .orElse(null);
    }
}
