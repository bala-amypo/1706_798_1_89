package com.example.demo.service.impl;

import com.example.demo.service.InvoiceService;

import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceCategorizationEngine categorizationEngine;

    public InvoiceServiceImpl(InvoiceCategorizationEngine categorizationEngine) {
        this.categorizationEngine = categorizationEngine;
    }

    @Override
    public String categorizeInvoice(String description) {
        return categorizationEngine.categorize(description);
    }
}
